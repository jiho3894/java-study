<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<style>
	* {
		text-align:center;
	}

	span {
	font-size:25px;
	}
	
	a {
	font-size:30px;
	text-decoration: none;
	color: red;
	}
</style>
<body>
	<h1>선택하신 내용의 결과 페이지 입니다.</h1>
	<hr><br>
	<!-- UTF-8 인식 -->
    <% request.setCharacterEncoding("UTF-8"); %>
    <%
    	String[]lang = request.getParameterValues("lang");
    	String[]hobby = request.getParameterValues("hobby");
    %>
    <span>관심 언어:</span>
    <%
       for(int i=0; i<lang.length; i++){
       out.println(lang[i]+"");
       }
     %><br>
     <span>취미 :</span>
     <%
        for(int i=0; i<hobby.length; i++){
        out.println(hobby[i]+"");
        }
      %><br>
     	<a href="index.html">
			<span>다시 입력하기</span>
		</a>
</body>
</html>