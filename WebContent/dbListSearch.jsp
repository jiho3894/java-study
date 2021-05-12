<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색기능 추가 목록 페이지 </title>
</head>
<style>
	body {
		margin: 0;
		padding: 0;
		font-size: 20px;
		background: linear-gradient(to right, pink, skyblue);
		text-align: center;
	}
	
	caption {
		margin:auto;
		text-align:center;
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
</style>
<body>
	검색 내용을 확인 해주세요 <br />
	<form name="search_form" action="asearch_act.jsp" method="post">
	<select name="searchk" style="height:20px; width:20%;background-color:#ccdd00;">
		<option value="">검색할 항목을 선택하세요</option>
		<option value="name">이름</option>
		<option value="dept">학과</option>
		<option value="address">주소</option>
	</select>
	<input type="text" name="searchw" value="">
	<input type="submit" value="검색">
	</form>
		<div class="home"> 데이터베이스 연동 테스트 페이지 </div>
		<table border="1">
			<caption> 데이터 목록 </caption>
				<tr>
					<th> 번호 </th>
					<th> 이름 </th>
					<th> 주소 </th>
					<!--
					<th> 입학년도 </th>
					<th> 학과 </th>
					-->
				</tr>
		<%
			try {
				String name, address, birthym, dept; /* String형 변수 선언 */
				int id; /* 정수형 변수 선언 */
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/15db","kim","1234");
				/* if(conn != null) {
				out.println("데이터베이스 연동 성공 <br>");
				System.out.println("연결정보" + conn);
				System.out.println("연결정보(toString)" + conn.toString());
				conn.close();
				out.println("데이터베이스 연결 종료 <br> ");
			} else {
				out.println("데이터베이스 연동 실패 <br>");
			} 
			*/
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select id,name,address,birthym,dept from test order by id desc");
			while(rs.next()){
				id = rs.getInt(1);
				name = rs.getString(2);
				address = rs.getString(3);
				birthym = rs.getString(4);
				dept = rs.getString(5);	
			%>
				<tr>
					<td> <%=id %></td>
					<td> <a href="view.jsp?id=<%=id%>"> <%=name %> </a></td>
					<td> <%=address %></td>
					<!--
					<td> <%=birthym %></td>
					<td> <%=dept %></td>
					-->
				</tr>
			<%
			}
				rs.close(); // select query 문 종료
				stmt.close(); // query 문을 생성하기 위한 문 종료
				conn.close();  // 작업 완료 후 데이터베이스 종료 문
			} catch(Exception e){ /* 예외 처리문 - 오류 처리 문*/
				out.println(e);
			}
		%>
		</table>
		<footer>
		<a href="dbEx01.jsp" class="btn1">이전 페이지</a>
		</footer>
		</body>
</html>