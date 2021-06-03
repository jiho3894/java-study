<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 정보 수정 처리 </title>
</head>
<body>
<% 
try{
	String b_title=request.getParameter("b_title");
	String b_content=request.getParameter("b_content");
	int b_id = Integer.parseInt(request.getParameter("b_id"));
	
	Class.forName("com.mysql.jdbc.Driver"); 
	 /* jdbc Driver 설정 */ 
	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kdb?useUnicode=true&charaterEncoding=utf8","hana","123");
	 /* 데이터베이스 연결   
	 데이터 베이스에서 실행할 질의어(쿼리) 처리*/ 
	 Statement stmt = con.createStatement(); 
	// 쿼리문장을 쓰기위한 stmt 선언
	 
	 String sql = "update mboard set b_title='"+b_title+"', b_content='"+b_content+"'where b_id=" +b_id;
 	stmt.executeUpdate(sql); 
 	response.sendRedirect("finlist.jsp"); 
 	// 정보 수정을 끝내고 리스트 페이지로 돌아감
	stmt.close(); 
	con.close();    
} catch(Exception e){
	out.println(e); 
}
	%>
</body>
</html>