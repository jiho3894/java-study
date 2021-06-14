<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.* " %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>    
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 상세 내용 보기 페이지 </title>
</head>
<style>
	* {
		font-family: 'Noto+Sans+KR';
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
    height: 800px;
    background: linear-gradient(#E0EAFC,#CFDEF3 );
    opacity: 0.9;
    border-radius: 10px;
    box-shadow: 1px 1px 1px 1px black;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }

  h2 {
    text-align: center;
    color: hotpink;
  }

  form {
    width: 800px;
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
  
  footer {
    text-align: center;
    font-size: 25px;
    margin: 35px;
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
<body>
<%
/* 예외 처리문*/
	try {
		String name, mail, title, content, date, pwd, filename, filesize, mailtoyou; 
		int id, view;
		String num =request.getParameter("id");
		Class.forName("com.mysql.jdbc.Driver"); 
		 /* jdbc Driver 설정 */ 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addb?useUnicode=true&charaterEncoding=utf8","kim","1234");
		 /* 데이터베이스 연결   
		 데이터 베이스에서 실행할 질의어(쿼리) 처리*/ 
		Statement stmt = con.createStatement(); 
		// 쿼리문장을 쓰기위한 stmt 선언
		String sql = "select id, name, mail, title, content, date_format(date,'%y년%m월%d일 %H:%i:%s') , view, filename, filesize from blog where id=" + num;
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			id = rs.getInt(1); 
			name = rs.getString(2); 
			mail = rs.getString(3); 
			title = rs.getString(4); 
			content = rs.getString(5); 
			date = rs.getString(6); 
			view = rs.getInt(7); 
			filename = rs.getString(8);
			filesize = rs.getString(9);
			if(!mail.equals("")) {
				mailtoyou = "<a href= mailto:"+mail+">" + name + "</a>";
			} else {
				mailtoyou = "";
			}
		%>
		<h2> <%=id %> </h2>
		<div>
			<!-- list table 생성 -->
			<table border="1">
				<tr>
					<th>제목</th>
					<td colspan="6"> <%=title %> </td>
				</tr>
				<tr>
					<th>작성자</th>
					<th>이메일</th>
					<th> 조회수  </th>  
					<th> 작성일자  </th> 
				</tr>
				<tr>
					<td> <%=name %> </td>
					<td> <%=mail %> </td>
					<td> <%=view %> </td>
					<td> <%=date %> </td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="6"> <%=content %> </td>
				</tr>
				<tr> 
					<td colspan="7">
						<img src="image/<%=filename %>"> <br/>
						 파일 크기: <%=filesize %>
					</td>
				</tr>
			</table>
		</div>
		<footer>
			<a href="flist.jsp">  전체 목록  </a> |
			<a href="fmodify.jsp?id=<%=id %>">  자료 수정 </a> 
		</footer>
		<%
		}
		rs.close(); 	
		stmt.executeUpdate("update blog set view=view+1 where id="+num+""); 
		con.close(); 
	}	catch(Exception e) {
		out.println(e);
	}
%>
</body>
</html>