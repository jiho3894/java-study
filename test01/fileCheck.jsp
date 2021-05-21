<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");    
    String name = request.getParameter("name");
    String subject = request.getParameter("subject");
    String filename1 = request.getParameter("filename1");
    String filename2 = request.getParameter("filename2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드된 결과 화면 페이지</title>
</head>
<body>
	파일 업로드 결과 화면 출력 <br/>
	작성자 : <%=name %> <br/>
	제목: <%=subject %> <br/>
	파일명 1:<a href="upload/<%=filename1 %>"><img src="upload/<%=filename1 %>"></a><br/>
	파일명 2:<a href="upload/<%=filename2 %>"><%=filename2 %></a><br/>
	
	<hr>
	<a href="fileForm.html">이미지 업로드 페이지로 이동</a>
</body>
</html>