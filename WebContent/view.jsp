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
<body>
  <%
  	try{
  	String name, address, birthym, dept;
  	int id = Integer.parseInt(request.getParameter("id"));
  		out.println("선택번호:" + id + "<br>");
  	
  		/* jdbc Driver 설정 */
  	Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addb","kim","1234");
			
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from test where id=" + id);
		if(rs.next()) {
			id = rs.getInt(1);
			name = rs.getString(2);
			address = rs.getString(3);
			birthym = rs.getString(4);
			dept = rs.getString(5);
		%>
		
		<div> 학생 정보 상세 내용</div>
		<table border="1">
			<tr>
				<th> 번호 </th>
				<th> 이름 </th>
				<th> 주소 </th>
				<th> 입학년도 </th>
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
		<a href="modify.jsp?id=<%=id%>"> 정보 수정</a> | 
		<a href="delete.jsp?id=<%=id%>"> 정보 삭제 </a>
	<%
		}
		rs.close();
		stmt.close();
		conn.close();
		
		}catch(Exception e){
			out.println(e);
		}
  %>
	<a href="dbEx01.jsp"> 학생 정보 목록 페이지 </a>
	<br>
	
</body>
</html>