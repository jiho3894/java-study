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
	* {
		font-family: 'Noto+Sans+KR';
	}

	html {
		height: 100%;
		background: linear-gradient(#fd746c, #ff9068);
    display: flex;
    align-items: center;
    justify-content: center;
	}
  
  body {
  	height: 80vh;
  	width: 50vw;
  	box-shadow: 1px 0 0 0 black;
    border-radius: 10px;
    background: linear-gradient(#E0EAFC,#CFDEF3 );
  }

  h1 {
    text-align: center;
    color: hotpink;
  }

  table {
    display: flex;
    justify-content: center;
    align-items: center;
    background: linear-gradient(#E0EAFC,#CFDEF3 );
    border-top: none;
    text-align: center;
  }
  
  tr th {
  	background-color: chartreuse;
  }
  
  td {
  	font-size: 20px;
  	font-weight: 600;
  }

  header {
    text-align: center;
    font-size: 25px;
    margin: 35px;
  }

  a {
    text-decoration: none;
    color: blueviolet;
    border-radius: 10px;
    font-size: 20px;
  }

  a:hover {
    background-color: skyblue;
  }
  
  .topLink {
    position: fixed;
    right: 50px;
    bottom: 50px;
    width: 100px;
    height: 100px;
    border-radius: 100%;
    background-color: yellow;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 20px;
    cursor: pointer;
  }
</style>
<body>
<h1> 업로드 내용 확인 페이지 </h1>
<p> 
<header>
  <a href="fwrite.jsp"> 등록 페이지로 이동 </a>
  <span>||</span>
  <a href="fsearch.jsp"> 검색 페이지로 이동 </a>
</header>
<table border="1">
<tr> 
  <th> 번호  </th> <th> 이미지  </th>
  <th> 제목  </th> <th> 작성자  </th>
  <th> 작성일자  </th> <th> 조회수 </th>
</tr>  
<%  request.setCharacterEncoding("utf-8");  %>
<%
	try{
		/* table field 변수 설정 */
		String name, mail, title, content, date, pwd, filename, filesize, mailtoyou; 
		int id, view, pagecount; 
		int datacount = 0; 
		Class.forName("com.mysql.jdbc.Driver"); 
		 /* jdbc Driver 설정 */ 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addb?useUnicode=true&charaterEncoding=utf8","kim","1234");
		 /* 데이터베이스 연결   
		 데이터 베이스에서 실행할 질의어(쿼리) 처리*/ 
		Statement stmt = con.createStatement(); 
		// 쿼리문장을 쓰기위한 stmt 선언
		ResultSet rs0 = stmt.executeQuery("select count(id) from blog"); 
		if(rs0.next())	{
			datacount = rs0.getInt(1); 
			rs0.close(); 
		}
		/* page 노출 수 지정 */
		int pagesize = 6; 
		if((datacount%10) == 0) pagecount = datacount	/	(pagesize+1) + 1;  
		else pagecount = datacount	/ pagesize + 1;
		int mypage = 1; int abpage = 1; 
		if(request.getParameter("mypage") !=null){
			mypage = Integer.parseInt(request.getParameter("mypage")); 
			abpage = (mypage -1) *pagesize + 1;
			if(abpage <=0) abpage = 1; 
		}
		ResultSet rs = stmt.executeQuery("select id, name, mail, title, content, date_format(date, '%m-%d/%H시%i분'), view, pwd, filename, filesize from blog order by id desc"); 
		if(!rs.next()){
			pagesize=0; 
		}	else {
			rs.absolute(abpage); 
		}
		for(int k=1; k<=pagesize; k++){
			id = rs.getInt(1); 
			name = rs.getString(2); 
			mail = rs.getString(3); 
			title = rs.getString(4); 
			content = rs.getString(5); 
			date = rs.getString(6); 
			view = rs.getInt(7);
			pwd = rs.getString(8);
			filename = rs.getString(9); 
			filesize = rs.getString(10);
			/* 작성자 hover시 이메일 값 */
			if(!mail.equals("")){
				mailtoyou="<a href=mailtoyou:" + mail + ">" + name + "</a>"; 
			} else	{
				mailtoyou = name; 
			}
 %> 
 <tr> 
   <td> <a href="fview.jsp?id=<%=id %>"> <%=id %> </a> </td>
   <td> <img width="300px" height="300px" src="image/<%=filename %>"> </td>
   <td> <a href="fview.jsp?id=<%=id %>"> <%=title %> </a>  </td>
   <td> <%=mailtoyou %> </td> 
   <td> <%=date %> </td> 
   <td> <%=view %> </td>    
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
 <%
    if(pagecount !=1){
    	for(int l=1; l<=pagecount; l++){
    		out.println("<a href=flist.jsp?mypage=" + l + ">" + l + "</a>|"); 
    	} 
    } else {
    		out.println("1"); 
    	}
   
}  catch(Exception e){  /* 예외 처리문 - 오류 처리 문 */ 
	out.println(e); 
}
%>
		<span> <= 페이지 이동 </span>
	</table>
 	<div class="topLink" onclick="window.scrollTo(0,0);">TOP</div>
</body>
</html>