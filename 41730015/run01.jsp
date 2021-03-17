<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입 완료 확인 페이지</title>
<style>
	table {
		border-spacing: 1em 0.5em;
		padding: 5px 2em 1em 5px;
		border: 1px solid orange;
	}
	hr {
		width : 70%;
		float : left;
	}
</style>
</head>
<body>
	가입 완료 되었습니다.<br>
	아래 내용을 확인 바랍니다.<br>
	<hr><br>
	<% request.setCharacterEncoding("UTF-8"); %>
	<table>
	    <tr> <td> 클라이언트 IP : <%= request.getRemoteAddr() %></td> </tr>
	    <tr> <td> 클라이언트 IP : <%= request.getRemoteHost() %></td> </tr>
		<tr> <td> 아이디 : <%= request.getParameter("id") %> </td> </tr>
		<tr> <td> 비밀번호 : <%= request.getParameter("password") %></td> </tr>
		<tr> <td> 성별 : <%= request.getParameter("gender") %> </td></tr>
		<tr> <td> 생년월일 : <%= request.getParameter("date") %> </td></tr>
		<tr> <td> 직책 : <%= request.getParameter("part") %></td> </tr>
	</table>
	<p>
		회원 가입 페이지로 <a href="index.html"> 이동 </a>
	</p>
</body>
</html>