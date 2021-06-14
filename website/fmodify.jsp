<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<%
	/* table field 변수 설정 */
	String filename = null;
	String title = null, content = null, name = null; 
  int id = Integer.parseInt(request.getParameter("id"));  
  out.println("이미지" + id + "<br />"); 
  Class.forName("com.mysql.jdbc.Driver"); 
	 /* jdbc Driver 설정 */ 
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addb?useUnicode=true&charaterEncoding=utf8","kim","1234");
	 /* 데이터베이스 연결   
	 데이터 베이스에서 실행할 질의어(쿼리) 처리*/ 
	Statement stmt = con.createStatement(); 
	// 쿼리문장을 쓰기위한 stmt 선언 
  ResultSet rs = stmt.executeQuery("select title, content , filename from blog where id="+ id); 
  if(rs.next()){
  	title = rs.getString(1);
 		content = rs.getString(2);
 		filename = rs.getString(3);
	}
	rs.close();
	stmt.close(); 
	con.close();  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 리스트 수정 페이지 </title>
<style> 
	* {
		font-family: 'Noto+Sans+KR';
		font-size:20px;
	}

	html {
		width: 100vw;
		height: 100vh;
		background: linear-gradient(#fd746c, #ff9068);
    display: flex;
    align-items: center;
    justify-content: center;
	}

  body {
  	width: 50%;
    height: 400px;
    background: linear-gradient(#E0EAFC,#CFDEF3 );
    opacity: 0.9;
    border-radius: 10px;
    box-shadow: 1px 1px 1px 1px black;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }
  
  table {
    display: flex;
    justify-content: center;
    align-items: center;
    background: linear-gradient(#E0EAFC,#CFDEF3 );
    text-align: center;
  }

  h2 {
    text-align: center;
    color: hotpink;
  }

  form {
    display: flex;
    justify-content: center;
    align-items: center;
    margin: auto;
  }
  
  tr th {
  	background-color: chartreuse;
  }
  
  td {
  	font-size: 20px;
  	font-weight: 500;
  }
  
  a {
    text-decoration: none;
    color: blueviolet;
    border-radius: 10px;
  }

  a:hover {
    background-color: skyblue;
  }
</style>
</head>
<body>
	<a href="fview.jsp?id=<%=id %>"> 돌아가기 </a>
	<form action="fmodify_act.jsp" method="post"> 
	  <table border=1> 
	    <tr> 
	    	<th> 제목  </th>
	      <td> <input type="text" name="title" value="<%=title %> ">   </td>
	    </tr>
	    <tr> 
	    	<th>내용 </th>
	      <td> <textarea name ="content" rows = "5" cols = "45" value="<%=content %>"></textarea>   </td>
	    </tr>
	    <tr> 
	    	<th> 이미지 파일  </th>
	      <td class="under"> <input type="file" name="filename" value="<%=filename %> "> </td> 
	    </tr>
	    <td colspan="2">   
		    <input type="hidden" name="id" value="<%=id %>">
		    <input type="submit" value="수정"> 
	    </td>
	  </table>
	</form>
</body>
</html>