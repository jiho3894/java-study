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
<title>파일 업로드 처리 페이지 </title>
</head>
<body>
<% request.setCharacterEncoding("utf-8");  %>
<%
/*  파일이 업로드 되는 실경로 설정  */ 
 ServletContext scontext = getServletContext(); 
 String realFolder = scontext.getRealPath("images"); 
	try{
		String b_filename=""; 
		String b_filesize=""; 
		MultipartRequest multi = new MultipartRequest(request, realFolder, (1024*1024*5), "utf-8", new DefaultFileRenamePolicy()); 
		Enumeration<?> files = multi.getFileNames(); 
		String file1 = (String)files.nextElement(); 
		String fileName1 = multi.getFilesystemName(file1);
	if(fileName1 == null)	{
		b_filename="default.png";
		b_filesize = "5517Bytes"; 
	} else	{
		b_filename = fileName1; 
		File file = multi.getFile("b_filename"); 
		b_filesize = ""+file.length()+"Bytes"; 
	}
	int b_id = 0; 
	String b_name = multi.getParameter("b_name"); 
	String b_mail = multi.getParameter("b_mail"); 
	String b_title = multi.getParameter("b_title"); 
	String b_content = multi.getParameter("b_content"); 
	String b_pwd = multi.getParameter("b_pwd"); 
	
	/* 데이터베이스 연동 - 드라이버 설정   */ 
	Class.forName("com.mysql.jdbc.Driver"); 
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/15db?useUnicode=true&characterEncoding=utf8","kim","1234");
	Statement stmt = conn.createStatement(); 
	ResultSet rs = stmt.executeQuery("select max(b_id) from mboard"); 
	/* 작성 된 글 번호 처리 문  */ 
	if(rs.next())	{
		b_id = rs.getInt(1);
		b_id = b_id + 1; 
		rs.close(); 
		stmt.close(); 
	} else {
		b_id = 1; 
	}
	PreparedStatement pstmt = conn.prepareStatement("insert into mboard(b_id, b_name, b_mail, b_title, b_content, b_data, b_view, b_pwd, b_filename, b_filesize) values(?, ?, ?, ?, ?, now(), 0, ?, ?, ?)");
	pstmt.setInt(1, b_id); 
	pstmt.setString(2, b_name); 
	pstmt.setString(3, b_mail); 
	pstmt.setString(4, b_title); 
	pstmt.setString(5, b_content); 
	pstmt.setString(6, b_pwd); 
	pstmt.setString(7, b_filename); 
	pstmt.setString(8, b_filesize); 
	pstmt.executeUpdate(); 
	pstmt.close(); 
	conn.close(); 
	response.sendRedirect("flist.jsp");
} catch(Exception e)	{
	out.println(e); 
}
%>
</body>
</html>