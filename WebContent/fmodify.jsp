<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<%
	/* table field 변수 설정 */
	String b_filename = null;
	String b_title = null, b_content = null, b_name = null; 
  int b_id = Integer.parseInt(request.getParameter("b_id"));  
  out.println("이미지" + b_id + "<br />"); 
  Class.forName("com.mysql.jdbc.Driver"); 
	 /* jdbc Driver 설정 */ 
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addb?useUnicode=true&charaterEncoding=utf8","kim","1234");
	 /* 데이터베이스 연결   
	 데이터 베이스에서 실행할 질의어(쿼리) 처리*/ 
	Statement stmt = con.createStatement(); 
	// 쿼리문장을 쓰기위한 stmt 선언 
  ResultSet rs = stmt.executeQuery("select b_title, b_content , b_filename from mboard where b_id="+ b_id); 
  if(rs.next()){
  	b_title = rs.getString(1);
 		b_content = rs.getString(2);
 		b_filename = rs.getString(3);
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
		background: linear-gradient(#EECDA3, #EF629F);
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
	<a href="fview.jsp?b_id=<%=b_id %>"> 돌아가기 </a>
	<form action="fmodify_act.jsp" method="post"> 
	  <table border=1> 
	    <tr> 
	    	<th> 제목  </th>
	      <td> <input type="text" name="b_title" value="<%=b_title %> ">   </td>
	    </tr>
	    <tr> 
	    	<th>내용 </th>
	      <td> <textarea name ="b_content" rows = "5" cols = "45" value="<%=b_content %>"></textarea>   </td>
	    </tr>
	    <tr> 
	    	<th> 이미지 파일  </th>
	      <td class="under"> <input type="file" name="b_filename" value="<%=b_filename %> "> </td> 
	    </tr>
	    <td colspan="2">   
		    <input type="hidden" name="b_id" value="<%=b_id %>">
		    <input type="submit" value="수정"> 
	    </td>
	  </table>
	</form>
</body>
</html>