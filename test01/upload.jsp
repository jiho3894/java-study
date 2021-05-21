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
<title>파일 업로드 처리 완료 페이지</title>
</head>
<body>
	파일 업로드 처리가 완료 되었습니다 <br/>
	<form name="fileCheck" action="fileCheck.jsp" method="post">
		<input type="hidden" name="name" value="<%=name %>">
		<input type="hidden" name="subject" value="<%=subject %>">
		<input type="hidden" name="filename1" value="<%=filename1 %>">
		<input type="hidden" name="filename2" value="<%=filename2 %>">
	</form>
	<a href="fileCheck.jsp" onclick="javascript:filecheck.submit()">업로드 내용 확인</a>
</body>
</html>