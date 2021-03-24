<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<% String uploadPath = request.getRealPath("/upload"); 
	int size = 10*1024*1024;
	String name="";
	String subject="";
	String filename1="";
	String filename2="";
	
	try {
		MultipartRequest multi = new MultipartRequest(request,uploadPath,size,"UTF-8",new DefaultFileRenamePolicy());
		name = multi.getParameter("name");
		System.out.println(name);
		subject = multi.getParameter("subject");
		/* Enumeration 타입으로 변환*/
		Enumeration files = multi.getFileNames();
		String file1 = (String)files.nextElement();
		filename1 = multi.getFilesystemName(file1);
		String file2 = (String)files.nextElement();
		filename2 = multi.getFilesystemName(file2);
	} catch(Exception e) {
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 처리 페이지</title>
</head>
<body>
 	파일 업로드 처리
</body>
</html>