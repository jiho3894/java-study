<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>   
<% request.setCharacterEncoding("utf-8");  %>
<% 
    String name=null, address=null, birthym=null, dept=null; 
    int id = Integer.parseInt(request.getParameter("id")); 
    out.println("선택한 번호:" + id + "<br />"); 
    Class.forName("com.mysql.jdbc.Driver"); 
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addb","kim","1234");
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
<body>
 <form action="modify_act.jsp" method="post"> 
  <table border=1 cellspacing="0"> 
    <tr> 
    	<th> 이름  </th>
        <td><input type="text" name="name" value="<%=name %> "></td>
    </tr>
    <tr> 
    	<th>  주소 </th>
        <td><input type="text" name="address" value="<%=address %> "></td>
    </tr>
    <tr> 
    	<th> 생년월일  </th>
        <td><input type="text" name="birthym" value="<%=birthym %> "></td>
    </tr>
    <tr> 
    	<th> 학과  </th>
        <td><input type="text" name="dept" value="<%=dept %> "></td>
    </tr>
    <tr> 
       	<td colspan="2">   
	      	<input type="hidden" name="id" value="<%=id %>">
	        <input type="submit" value="수정"> 
       	</td> 
    </tr>   
  </table>
 </form>
</body>
</html>