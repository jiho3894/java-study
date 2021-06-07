<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page import="java.sql.* " %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>업로드 내용 확인 페이지 </title>
</head>
<style>
	body {
		width: 100%;
		height: 100vh;
		background: linear-gradient(#E0EAFC, #CFDEF3);
	}
</style>
<body>
<h1> 업로드 내용 확인 페이지 </h1>
<p> 
<table border="1">
<tr> 
  <th> 번호  </th> <th> 이미지  </th>
  <th> 제목  </th> <th> 작성자  </th>
  <th> 작성일자  </th> <th> 조회수 </th>
</tr>  
<%  request.setCharacterEncoding("utf-8");  %>
<%
try{
	String b_name, b_mail, b_title, b_content, b_data, b_pwd, b_filename, b_filesize, mailtoyou; 
	int b_id, b_view, pagecount; 
	int datacount = 0; 
	Class.forName("com.mysql.jdbc.Driver"); 
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addb?useUnicode=true&charaterEncoding=utf8","kim","1234");
	Statement stmt = con.createStatement(); 
	// 쿼리문장을 쓰기위한 stmt 선언
	/* 페이지 처리하기 위한 구문  */ 
	ResultSet rs0 = stmt.executeQuery("select count(b_id) from mboard"); 
	if(rs0.next())	{
		datacount = rs0.getInt(1); 
		rs0.close(); 
	}
	int pagesize = 10; 
	if((datacount%10) == 0) pagecount = datacount	/	(pagesize+1) + 1; 
	else pagecount = datacount	/ pagesize +1;
	int mypage = 1; int abpage = 1; 
	if(request.getParameter("mypage") !=null){
		mypage = Integer.parseInt(request.getParameter("mypage")); 
		abpage = (mypage -1) *pagesize + 1;
		if(abpage <=0) abpage = 1; 
	}
	ResultSet rs = stmt.executeQuery("select b_id, b_name, b_mail, b_title, b_content, date_format(b_data, '%y-%m-%d'), b_view, b_pwd, b_filename, b_filesize from mboard order by b_id desc"); 
	if(!rs.next()){
		pagesize=0; 
	}	else {
		rs.absolute(abpage); 
	}
	for(int k=1; k<=pagesize; k++){
		b_id = rs.getInt(1); 
		b_name = rs.getString(2); 
		b_mail = rs.getString(3); 
		b_title = rs.getString(4); 
		b_content = rs.getString(5); 
		b_data = rs.getString(6); 
		b_view = rs.getInt(7);
		b_pwd = rs.getString(8);
		b_filename = rs.getString(9); 
		b_filesize = rs.getString(10); 
		if(!b_mail.equals("")){
			mailtoyou="<a href=mailtoyou:" + b_mail + ">" + b_name + "</a>"; 
		} else	{
			mailtoyou = b_name; 
		}
 %> 
 <tr> 
   <td> <%=b_id %> </td>
   <td> <img width="300px" height="300px" src="image/<%=b_filename %>"> </td>
   <td> <a href="fview.jsp?b_id=<%=b_id %>"> <%=b_title %> </a>  </td>
   <td> <%=mailtoyou %> </td> 
   <td> <%=b_data %> </td> 
   <td> <%=b_view %> </td>    
 </tr>		
<%		
	if(rs.getRow() == datacount){
		break; 
	} else	{
		rs.next(); 
	}
}
	rs.close(); 
	stmt.close(); 
	con.close();
%>
	</table>
	<%  /*  페이지 가 번호 로 처리 되는 구문  */ 
	if(pagecount !=1){
		for(int l=1; l<=mypage - 1; l++){
			out.println("<a href=flist.jsp?mypage=" + l + ">" + l + "</a>"); 
			out.println("|"); 
		}
		out.println(mypage + "|"); 
		for(int l = mypage +1; l<=pagecount; l++){
			out.println("<a href=flist.jsp?mypage=" + l + ">" + l + "</a>"); 
			out.println("|"); 
		}
	} else	{
		out.println(mypage + "|"); 
	}
} catch(Exception e)	{
	out.println(e); 
}
%>
<p> 
<a href="fwrite.jsp"> 등록 페이지로 이동 </a>
<a href="fsearch.jsp"> 검색 페이지로 이동 </a>
</body>
</html>