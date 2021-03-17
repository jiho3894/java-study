<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입 완료 확인 페이지</title>
<style>
    body {
        text-align: center;
        background: linear-gradient(to right, #fbcac9, #8ca6ce);
    }
    
	table {
		border-spacing: 1em 0.5em;
		padding: 5px 2em 1em 5px;
		border: 1px solid orange;
        margin: auto;
        background-color:white;
        opacity: 0.95;
	}

	hr {
		width : 70%;
	}

    td {
        font-size: 20px;
        float: left;
    }

    i {
        color: green;
    }
</style>
</head>
<body>
    <h1>
	가입 완료 되었습니다.<br>
	아래 내용을 확인 바랍니다.<br>
    </h1>
	<hr><br>
    <% request.setCharacterEncoding("UTF-8"); %>
	<table>
		<tr> <td> 아이디 : <%= request.getParameter("id") %> <i class="fas fa-check"></i></td> </tr>
		<tr> <td> 비밀번호 : <%= request.getParameter("password") %> <i class="fas fa-check"></i></td> </tr>
		<tr> <td> 성별 : <%= request.getParameter("gender") %> <i class="fas fa-check"></i> </td></tr>
		<tr> <td> 생년월일 : <%= request.getParameter("date") %> <i class="fas fa-check"></i> </td></tr>
		<tr> <td> 직책 : <%= request.getParameter("part") %> <i class="fas fa-check"></i></td> </tr>
	</table>
	<p>
		회원 가입 페이지로 <a href="index.html"> 이동 </a>
	</p>
</body>
</html>