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
		background: linear-gradient(#EECDA3, #EF629F);
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
		/* 순수한 41730015의 코드를 위한 b_date를 b_data로 표현 */
		String b_name, b_mail, b_title, b_content, b_data, b_pwd, b_filename, b_filesize, mailtoyou; 
		int b_id, b_view;
		String id =request.getParameter("b_id");
		Class.forName("com.mysql.jdbc.Driver"); 
		 /* jdbc Driver 설정 */ 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addb?useUnicode=true&charaterEncoding=utf8","kim","1234");
		 /* 데이터베이스 연결   
		 데이터 베이스에서 실행할 질의어(쿼리) 처리*/ 
		Statement stmt = con.createStatement(); 
		// 쿼리문장을 쓰기위한 stmt 선언
		String sql = "select b_id, b_name, b_mail, b_title, b_content, date_format(b_data,'%y년%m월%d일 %H:%i:%s') , b_view, b_filename, b_filesize from mboard where b_id=" + id;
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			b_id = rs.getInt(1); 
			b_name = rs.getString(2); 
			b_mail = rs.getString(3); 
			b_title = rs.getString(4); 
			b_content = rs.getString(5); 
			b_data = rs.getString(6); 
			b_view = rs.getInt(7); 
			b_filename = rs.getString(8);
			b_filesize = rs.getString(9);
			if(!b_mail.equals("")) {
				mailtoyou = "<a href= mailto:"+b_mail+">" + b_name + "</a>";
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
					<td colspan="6"> <%=b_title %> </td>
				</tr>
				<tr>
					<th>작성자</th>
					<th>이메일</th>
					<th> 조회수  </th>  
					<th> 작성일자  </th> 
				</tr>
				<tr>
					<td> <%=b_name %> </td>
					<td> <%=b_mail %> </td>
					<td> <%=b_view %> </td>
					<td> <%=b_data %> </td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="6"> <%=b_content %> </td>
				</tr>
				<tr> 
					<td colspan="7">
						<img src="image/<%=b_filename %>"> <br/>
						 파일 크기: <%=b_filesize %>
					</td>
				</tr>
			</table>
		</div>
		<footer>
			<a href="flist.jsp">  전체 목록  </a> |
			<a href="fmodify.jsp?b_id=<%=b_id %>">  자료 수정 </a> 
		</footer>
		<%
		}
		rs.close(); 	
		stmt.executeUpdate("update mboard set b_view=b_view+1 where b_id="+id+""); 
		con.close(); 
	}	catch(Exception e) {
		out.println(e);
	}
%>
</body>
</html>