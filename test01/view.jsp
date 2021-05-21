<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.net.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 상세보기 페이지 </title>
</head>
<style>
	body {
		margin: 0;
		padding: 0;
		font-size: 20px;
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
	
	.home {
		font-size:35px;
		color: black;
	}
	
	th:nth-child(1) {
		background-color: yellow;
	}
	
	th:nth-child(2) {
		background-color: white;
	}
	
	th:nth-child(3) {
		background-color: skyblue;
		color:white;
	}
	
	th:nth-child(4) {
		background-color: skyblue;
		color:white;
	}
	
	t:nth-child(5) {
		background-color: black;
		color:white;
	}
	
	a {
		text-decoration: none;
		
	}
	
	footer {
		background-color: white;
		width:400px;
		height:30px;
		margin:auto;
		margin-top: 20px;
		border-radius:5px;
		cursor:pointer;
	}
	
	a:nth-child(1):hover {
		border-radius:5px;
		background-color: skyblue;
		color:white;
	}
	
	a:nth-child(2):hover {
		border-radius:5px;
		background-color: pink;
		color:white;
	}
</style>
<body>
  <%
  	try{
  	String name, address, birthym, dept;
  	int id = Integer.parseInt(request.getParameter("id"));
  		out.println("선택번호:" + id + "<br>");
  	
  		/* jdbc Driver 설정 */
  	Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addb?useUnicode=true&characterEncoding=utf8","kim","1234");
			
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from test where id=" + id);
		if(rs.next()) {
			id = rs.getInt(1);
			name = rs.getString(2);
			address = rs.getString(3);
			birthym = rs.getString(4);
			dept = rs.getString(5);
		%>
		
		<div class="home"> 학생별 상세 정보 내용</div>
		<table border="1">
			<tr>
				<th> 번호 </th>
				<th> 이름 </th>
				<th> 주소 </th>
				<th> 출생년도 </th>
				<th> 학과 </th>
			</tr>
			<tr>
				<th> <%=id %> </th>
				<th> <%=name %> </th>
				<th> <%=address %> </th>
				<th> <%=birthym %> </th>
				<th> <%=dept %> </th>
			</tr>
		</table>
		<footer>
		<a href="modify.jsp?id=<%=id%>"> 정보 수정</a> |
	<%
		}
		rs.close();
		stmt.close();
		conn.close();
		
		}catch(Exception e){
			out.println(e);
		}
  %>
	<a href="dbEx01.jsp"> 학생정보 리스트 보기 </a>
	<br>
	</footer>
	
</body>
</html>