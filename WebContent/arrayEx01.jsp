<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 성적 처리 프로그램
	학생별 3과목 점수를 입력받고 총점과 평균을 계산하는 프로그램 -->
	성적처리 프로그램 <br>
	<%
		int jumsu[][]={ {90,88,78} , {76,88,98} };
		int total[]= new int[2];
		double average[] = new double[2];
		total[0]= jumsu[0][0] + jumsu[0][1] + jumsu[0][2];
		total[1]= jumsu[1][0] + jumsu[1][1] + jumsu[1][2];
		average[0] = total[0] / 3;
		average[1] = total[1] / 3;
	%>
	1번학생  영어 = <%=jumsu[0][0] %> <br>
	1번학생  수학 = <%=jumsu[0][1] %> <br>
	1번학생  컴퓨터 = <%=jumsu[0][2] %> <br>
	<hr size="1" width="40%" align="left">
	1번학생 총점 = <%=total[0] %> , 평균 = <%=average[0] %><br>
	<hr size="1" width="40%" align="left">
	2번학생  영어 = <%=jumsu[1][0] %> <br>
	2번학생  수학 = <%=jumsu[1][1] %> <br>
	2번학생  컴퓨터 = <%=jumsu[1][2] %> <br>
	<hr size="1" width="40%" align="left">
	2번학생 총점 = <%=total[1] %> , 평균 = <%=average[1] %><br>
</body>
</html>