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
		font-size: 20px;
		background-color: skyblue;
		text-align: center;
	}

	.home {
		font-size:35px;
		color: red;
	}
	
	table {
		border-radius: 5px;
		text-align: center;
		padding: 5px;
		margin:auto;
		margin-top:100px;
	}
	
	table th {
		background-color: yellow;
	}
</style>
<body>
	<div class="home"> 데이터베이스 연동 테스트 페이지 </div>
	<table border="1">
		<caption> 데이터 목록 </caption>
		<tr>
			<th> 번호 </th>
			<th> 이름 </th>
			<th> 주소 </th> 
			<th> 입학년도 </th>
			<th> 학과 </th>
		</tr>
		<%
			try {
				String name, address, birthym, dept; /* String형 변수 선언 */
				int id; /* 정수형 변수 선언 */
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addb","park","1234");
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
					<td> <%=name %></td>
					<td> <%=address %></td>
					<td> <%=birthym %></td>
					<td> <%=dept %></td>
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
</body>
</html>