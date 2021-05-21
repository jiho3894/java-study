<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>학생정보 수정 페이지 </title>
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
</style>
<body>
<% request.setCharacterEncoding("utf-8");  %>
<%
    //int id = Integer.parseInt(request.getParameter("id")); 
    //out.println("해당 번호:"+ id + "<br />"); 
    try{
    	String name=request.getParameter("name"); 
    	String address=request.getParameter("address"); 
    	String birthym=request.getParameter("birthym"); 
    	String dept=request.getParameter("dept"); 
    	int id = Integer.parseInt(request.getParameter("id")); 
    	
    	Class.forName("com.mysql.jdbc.Driver"); 
    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addb?useUnicode=true&characterEncoding=utf8", "kim", "1234");
    	Statement stmt = conn.createStatement(); 
    	String sql = "update test set name= '" + name+ "',  address=' "+address+"' , birthym = '"+birthym+"', dept ='"+dept+"' where id=" + id;
    	stmt.executeUpdate(sql); 
    	response.sendRedirect("dbEx01.jsp"); 
    	stmt.close(); 
    	conn.close();     	
    	
    } catch(Exception e){
    	out.println(e); 
    }
    
%>
</body>
</html>