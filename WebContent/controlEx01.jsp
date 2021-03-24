<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제어문 활용</title>
</head>
<body>
Max 값 계산 <br>
	<%
	/* 변수 선언 */
	int x = 100;
	int y = 300;
	int max;
	/* 최대값을 처리하기 위한 제어문(if문) */
		if ( x >= y) {
			max = x;
		} else {
			max = y;
		}
	%>
수 1 = <%=x %> , 수 2 = <%=y %> <br>
</body>
</html>