<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.net.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>데이터 입력 처리 페이지</title>
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
	
	a {
		text-decoration: none;
	}
</style>
<body>
<div class="home"> 학생 정보 입력 완료 처리 페이지</div>
<%
	try{
		int id = 0;
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		String address = request.getParameter("address");
		String birthym = request.getParameter("birthym");
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/15db?useUnicode=true&characterEncoding=utf8","kim","1234");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select max(id) from test");
		if(rs.next()){
			id = rs.getInt(1);
			id = id+1; /* 기존 id 값에 1을 더하여 누적 하여 번호를 증가 시킴*/
			rs.close();
			stmt.close();
		}else{
			id = 1;
		}
		PreparedStatement pstmt = conn.prepareStatement("insert into test(id, name, address, birthym, dept) values(?,?,?,?,?)"); 
		pstmt.setInt(1 ,id);
		pstmt.setString(2 ,name);
		pstmt.setString(3 ,address);
		pstmt.setString(4 ,birthym);
		pstmt.setString(5 ,dept);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		
		response.sendRedirect("dbEx01.jsp");
		
		}catch(Exception e){
			out.println(e);
		}
%>

<a href="dbform.jsp"> 학생정보 입력 페이지로 이동</a>
<a href="dbEx01.jsp"> 학생정보 페이지로 이동</a>
</body>
</html>
