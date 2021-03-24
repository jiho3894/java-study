<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다중 선택 값 처리 페이지</title>
</head>
<body>
	선택된 내용은 다음과 같습니다.<br>
	<hr size="3" color="green" width="40%" align="left">
	<% 
		request.setCharacterEncoding("UTF-8"); 
		/* 선택된 (checkbox에서) 관심있는 언어를 선택할 때
		     전달되는 값을 저장하기 위한 문자열 클래스 타입의 변수 선언 */
		String[]lang = request.getParameterValues("lang");
		String[]hobby = request.getParameterValues("hobby");
	%>
	
	관심 언어: <%
		/* 체크박스(관심언어)에서 선택된 각각의 항목들에 값이 반복적으로 출력 */
		for(int i=0; i<lang.length; i++){
			out.println(lang[i] + "");
		}
	%>
	<br>
	관심 취미: <%
		/* 다중선택(hobby)처리된 값들이 반복적으로 출력 */
		for(int i=0; i<hobby.length; i++){
			out.println(hobby[i] + "");
		}
	%>
</body>
</html>