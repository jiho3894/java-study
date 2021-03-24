<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다중 선택 처리</title>
</head>
<body>
	관심 있는 언어를 선택하세요 (여러개 선택 가능) <br>
	<form action="select01.jsp" method="post">
		<table border="1">
			<tr>
				<td> 관심 언어 </td>
				<td> 
					<input type="checkbox" name="lang" value="java"> Java 
				 	<input type="checkbox" name="lang" value="Python"> Python
				 	<input type="checkbox" name="lang" value="C"> C
				 	<input type="checkbox" name="lang" value="C#"> C#
				 	<input type="checkbox" name="lang" value="SQL"> SQL
				</td>
			</tr>
			<tr>
				<td> 관심 취미 </td>
				<td>
					<select name="hobby" size="5" multiple>
						<option value="영화">영화</option>
						<option value="게임">게임</option>
						<option value="여행">여행</option>
						<option value="운동">운동</option>
						<option value="댄스">댄스</option>
					</select>
				</td>
			</tr>
		</table>
		<input type="submit" value="send">
		<input type="reset" value="취소">
	</form>
</body>
</html>