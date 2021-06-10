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
		/* table field 변수 설정 */
		String b_title=request.getParameter("b_title");
		String b_content=request.getParameter("b_content");
		String b_filename=request.getParameter("b_filename");
		int b_id = Integer.parseInt(request.getParameter("b_id"));
		
		Class.forName("com.mysql.jdbc.Driver"); 
		 /* jdbc Driver 설정 */ 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addb?useUnicode=true&charaterEncoding=utf8","kim","1234");
		 /* 데이터베이스 연결   
		 데이터 베이스에서 실행할 질의어(쿼리) 처리*/ 
		Statement stmt = con.createStatement(); 
		// 쿼리문장을 쓰기위한 stmt 선언
		 
		String sql = "update mboard set b_title='"+b_title+"', b_content='"+b_content+"', b_filename='"+b_filename+"' where b_id=" +b_id;
	 	stmt.executeUpdate(sql); 
	 	response.sendRedirect("fview.jsp?b_id=" + b_id); 
		stmt.close(); 
		con.close();    
	} catch(Exception e){
		out.println(e); 
	}
%>
</body>
</html>