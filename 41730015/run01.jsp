<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
<link rel="stylesheet" href="result.css">
<title>가입 완료 확인 페이지</title>
</head>
<body>
	<!-- 제목 -->
    <p>
	가입 완료 되었습니다.<br>
	아래 내용을 확인 바랍니다.<br>
    </p>
    <!-- 경계선 -->
	<hr><br>
	<!-- UTF-8 인식 -->
    <% request.setCharacterEncoding("UTF-8"); %>
    <!-- table tag -->
	<table>
		<tr> <td> 이름 : <%= request.getParameter("name") %> <i class="fas fa-check"></i></td> </tr>
		<tr> <td> 아이디 : <%= request.getParameter("id") %> <i class="fas fa-check"></i></td> </tr>
		<tr> <td> 비밀번호 : (정보 일치) <i class="fas fa-check"></i></td> </tr>
		<tr> <td> 성별 : <%= request.getParameter("gender") %> <i class="fas fa-check"></i> </td></tr>
		<tr> <td> 생년월일 : <%= request.getParameter("date") %> <i class="fas fa-check"></i> </td></tr>
		<tr> <td> 직책 : <%= request.getParameter("part") %> <i class="fas fa-check"></i></td> </tr>
	</table>
	<!-- 링크 이동 -->
	<div>
		<a href="index.html">
			<span>다시 입력</span>
		</a>
		<a href="https://www.doowon.ac.kr:442/main.do">
			<span>두원공대 사이트</span>
		</a>
	</div>
</body>
<script src="https://kit.fontawesome.com/76e1965d86.js" crossorigin="anonymous"></script>
</html>