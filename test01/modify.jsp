<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>   
<% request.setCharacterEncoding("utf-8");  %>
<% 
    String name=null, address=null, birthym=null, dept=null; 
    int id = Integer.parseInt(request.getParameter("id")); 
    out.println("선택한 번호:" + id + "<br />"); 
    Class.forName("com.mysql.jdbc.Driver"); 
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addb?useUnicode=true&characterEncoding=utf8","kim","1234");
    Statement stmt = conn.createStatement(); 
    ResultSet rs = stmt.executeQuery("select name, address, birthym, dept from test where id="+id); 
    if(rs.next()){
    	name = rs.getString(1); 
    	address = rs.getString(2); 
    	birthym = rs.getString(3); 
    	dept = rs.getString(4); 
    }
    rs.close(); 
    stmt.close(); 
    conn.close(); 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>수정할 학생 정보 내용 보기</title>
</head>
<style>
	body {
		margin: 0;
		padding: 0;
		font-size: 30px;
		background: linear-gradient(to right, pink, skyblue);
		text-align: center;
	}
	
	table {
		border-radius: 5px;
		text-align: center;
		padding: 5px;
		margin:auto;
		margin-top:100px;
	}
	th {
		font-size:20px;
	}
	
	input, button {
		font-size:20px;	
	}
	.changeBtn {
		cursor:pointer;
	}
	
	th:nth-child(1) {
		background-color: white;
	}
	
	a {
		text-decoration: none;
	}
</style>
<body>
	<div class="home"> 학생 정보 수정 페이지</div>
 <form action="modify_act.jsp" method="post"> 
  <table border=1 > 
    <tr> 
    	<th> 이름  </th>
        <td><input type="text" name="name" value="<%=name %> "></td>
    </tr>
    <tr> 
    	<th>  주소 </th>
        <td><input type="text" name="address" value="<%=address %> "></td>
    </tr>
    <tr> 
    	<th> 출생년도  </th>
        <td><input type="text" name="birthym" value="<%=birthym %> "></td>
    </tr>
    <tr> 
    	<th> 학과  </th>
        <td><input type="text" name="dept" value="<%=dept %> "></td>
    </tr>
    <tr> 
       	<td colspan="2">   
	      	<input type="hidden" name="id" value="<%=id %>">
	        <input class="changeBtn" type="submit" value="수정"> 
	        <button><a href="dbEx01.jsp">돌아가기</a></button>
       	</td> 
    </tr>   
  </table>
 </form>
</body>
</html>