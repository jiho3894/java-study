<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.* " %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>    
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 상세 내용 보기 페이지 </title>
</head>
<body>
<%
/* 예외 처리문*/
	try {
		String b_name, b_mail, b_title, b_content, b_data, b_pwd, b_filename, b_filesize, mailtoyou; 
		int b_id, b_view;
		String id =request.getParameter("b_id");
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/15db?useUnicode=true&characterEncoding=utf8","kim","1234");
		Statement stmt = conn.createStatement();
		String sql = "select b_id, b_mail, b_title, b_content, date_format(b_data,'%y-%c-%e %H:%i:%s') , b_view, b_pwd, b_filename, b_filesize from mboard where b_id=" + id;
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()){
			b_id = rs.getInt(1); 
			b_name = rs.getString(2); 
			b_mail = rs.getString(3); 
			b_title = rs.getString(4); 
			b_content = rs.getString(5); 
			b_data = rs.getString(6); 
			b_view = rs.getInt(7); 
			b_filename = rs.getString(8); 
			b_filesize = rs.getString(9);
			if(!b_mail.equals("")) {
				mailtoyou = "<a href= mailto:"+b_mail+">" + b_name + "</a>";
			} else {
				mailtoyou = "";
			}
		%>
		<p> 상세보기 내용은 <%=id %> 번 글입니다 <br/> </p>
		<div>
			<table border="1">
				<tr>
					<th>번호</th> <th>제목</th> 
					<th>작성자</th>
					<th>이메일</th>
					<th> 내용  </th> <th> 조회수  </th>  <th> 작성일자  </th> 
				</tr>
				<tr>
					<td> <%=b_id %> </td>
					<td> <%=b_title %> </td>
					<td> <%=b_name %> </td>
					<td> <%=mailtoyou %> </td>
					<td> <%=b_data %> </td>
					<td> <%=b_view %> </td>
					<td> <%=b_content %> </td>
				</tr>
				<tr> 
					<td colspan="7">
						<img src="images/<%=b_filename %>"> <br/>
						 파일 크기: <%=b_filesize %>
					</td>
				</tr>
			</table>
		</div>
		<%
		}
		rs.close(); 	
		stmt.executeUpdate("update mboard set b_view=b_view+1 where b_id="+id+""); 
		conn.close(); 
	}	catch(Exception e) {
		out.println(e);
	}
%>

	<a href="flist.jsp">  전체 목록  </a> |
	<a href="fmodify.jsp">  자료 수정 </a> 
</body>
</html>