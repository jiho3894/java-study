<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터베이스 연동 페이지 </title>
</head>
<style>
	body {
		margin: 0;
		padding: 0;
		font-size: 20px;
		background: linear-gradient(to right, pink, skyblue);
		text-align: center;
	}
	.home {
		font-size:35px;
		color: black;
	}
	
	table {
		border-radius: 5px;
		text-align: center;
		padding: 5px;
		margin:auto;
		margin-top:100px;
		border-shadow: 3px;
	}
	
	td:nth-child(1) {
		background-color: yellow;
	}
	
	td.nameBtn {
		background-color: white;
		opacity : 0.9;
	}
	
	td.nameBtn:hover {
		background-color:gray;
	}
	
	td:nth-child(3) {
		background-color: skyblue;
		color:white;
	}
	
	td:nth-child(4) {
		background-color: skyblue;
		color:white;
	}
	
	table th {
		background-color: white;
	}
	
	a {
		text-decoration: none;
	}
	
	p {
		text-decoration: none;
		color: red;
		font-size: 20px;
		padding: 1px red solid;
	}
	
	footer:nth-child(3) {
		background-color: white;
		width:300px;
		height:30px;
		margin:auto;
		margin-top: 20px;
		border-radius:5px;
		cursor:pointer;
	}
	
	footer:nth-child(4) {
		background-color: white;
		width:300px;
		height:30px;
		margin:auto;
		margin-top: 20px;
		border-radius:5px;
		cursor:pointer;
	}
	
	
	footer:hover {
		background-color:gray;
	}
	
	.btn1 {
		text-align:center;
		margin-top:30px;
	}
	
	
	
</style>
<body>
	<div class="home"> 목록페이지 </div>
	<table border="1">
		<caption> 15DB List 내용 </caption>
		<!-- 목록 페이지 -->
		<tr>
			<th> 번호 </th>
			<th> 이름 </th>
			<th> 주소 </th>
			<th> 출생년도 </th>
		</tr>
		<%
			try {
				String name, address, birthym, dept; /* String형 변수선언 */
				int id; /* 정수형 변수선언 */
			/* DB 연동 */
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addb?useUnicode=true&characterEncoding=utf8","kim","1234");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select id, name, address, birthym, dept from test order by id desc");
			while(rs.next()){
				id = rs.getInt(1);
				name = rs.getString(2);
				address = rs.getString(3);
				birthym = rs.getString(4);
				dept = rs.getString(5);	
			%>
			<!-- 15DB에 등록된 정보 -->
				<tr>
					<td> <%=id %></td>
					<td class="nameBtn"> <a href="view.jsp?id=<%=id%>"> <%=name %> </a></td>
					<td> <%=address %></td>
					<td> <%=birthym %></td>					
				</tr>
			<%
			}
				rs.close(); // select query 문 종료
				stmt.close(); // query 문을 생성하기 위한 문 종료
				conn.close();  // 데이터베이스 종료 문
			} catch(Exception e){ /*오류 처리 문*/
				out.println(e);
			}
		%>
		</table>
		<footer>
		<a href="dbform.jsp" class="btn">데이터 입력 사이트로 이동</a> <br/>
		</footer>
		<footer>
		<a href="dbListSearch.jsp" class="btn1">데이터 검색 사이트로 이동</a>
		</footer>
</body>
</html>