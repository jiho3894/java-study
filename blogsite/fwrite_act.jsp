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
	/* 파일이 업로드 되는 실경로 설정  */ 
 	ServletContext scontext = getServletContext();
 	String realFolder = scontext.getRealPath("image"); 
	try	{
		String filename=""; 
		String filesize=""; 
		MultipartRequest multi = new MultipartRequest(request, realFolder, (1024*1024*5), "utf-8", new DefaultFileRenamePolicy()); 
		Enumeration<?> files = multi.getFileNames(); 
		String file1 = (String)files.nextElement(); 
		String fileName1 = multi.getFilesystemName(file1);
	if(fileName1 == null)	{
		filename="default.jpg";
		filesize = "10000Bytes"; 
	} else	{
		filename = fileName1; 
		File file = multi.getFile("filename"); 
		filesize = ""+file.length()+"Bytes"; 
	}
	/* table field 변수 설정 */
	int id = 0; 
	String name = multi.getParameter("name"); 
	String mail = multi.getParameter("mail"); 
	String title = multi.getParameter("title"); 
	String content = multi.getParameter("content"); 
	String pwd = multi.getParameter("pwd");
	
	Class.forName("com.mysql.jdbc.Driver"); 
	 /* jdbc Driver 설정 */ 
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addb?useUnicode=true&charaterEncoding=utf8","kim","1234");
	 /* 데이터베이스 연결   
	 데이터 베이스에서 실행할 질의어(쿼리) 처리*/ 
	Statement stmt = con.createStatement(); 
	// 쿼리문장을 쓰기위한 stmt 선언
	ResultSet rs = stmt.executeQuery("select max(id) from blog"); 
	/* 등록마다 id숫자를 증가시킴 */
	if(rs.next())	{
		id = rs.getInt(1);
		id = id + 1; 
		rs.close(); 
		stmt.close(); 
	} else {
		id = 1; 
	}
	
	PreparedStatement pstmt = con.prepareStatement("insert into blog(id, name, mail, title, content, date, view, pwd, filename, filesize) values(?, ?, ?, ?, ?, now(), 0, ?, ?, ?)");
	pstmt.setInt(1, id); 
	pstmt.setString(2, name); 
	pstmt.setString(3, mail); 
	pstmt.setString(4, title); 
	pstmt.setString(5, content); 
	pstmt.setString(6, pwd); 
	pstmt.setString(7, filename); 
	pstmt.setString(8, filesize); 
	pstmt.executeUpdate(); 
	pstmt.close(); 
	con.close(); 
	/* 등록 후 flist로 이동하기 */
	response.sendRedirect("flist.jsp");
	} catch(Exception e){
	out.println(e); 
	}
%>
</body>
</html>