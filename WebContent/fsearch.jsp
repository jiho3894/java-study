<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.* " %>
<% request.setCharacterEncoding("utf-8");  %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>검색기능 추가 목록 페이지 </title>
</head>
<style>
	* {
		font-family: 'Noto+Sans+KR';
	}

	html {
	height: 100%;
	background: linear-gradient(#EECDA3, #EF629F);
    display: flex;
    align-items: center;
    justify-content: center;
	}
  
  body {
  	height: 80vh;
  	width: 60%;
  	box-shadow: 1px 0 0 0 black;
    border-radius: 10px;
    background: linear-gradient(#E0EAFC,#CFDEF3 );
  }

    form {
    width: 800px;
    display: flex;
    justify-content: center;
    align-items: center;
    margin: auto;
  }
  
  table {
    display: flex;
    justify-content: center;
    align-items: center;
    background: linear-gradient(#E0EAFC,#CFDEF3 );
    border-top: none;
    text-align: center;
  }
  
  header {
    text-align: center;
    font-size: 25px;
    margin: 35px;
  }

  tr th {
  	background-color: chartreuse;
  }
  
  td {
  	font-size: 20px;
  	font-weight: 600;
  }

  h1 {
    text-align: center;
    color: hotpink;
  }
  
  a {
    text-decoration: none;
    color: blueviolet;
    border-radius: 10px;
    font-size: 20px;

  }

  a:nth-last-child() {
  	    margin-left: 100px;
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
	<h1>검색 내용을 확인 해 주세요</h1>
	<header>
	  <a href="fwrite.jsp"> 등록 페이지로 이동 </a>
	  <span>||</span>
	  <a href="flist.jsp"> 등록 리스트로 이동 </a>
	</header> 
	<form name="search_form" action="fsearch_act.jsp" method="post" > 
	<select name="searchk" style="height:20px; width:10%; background-color:skyblue;"> 
	  <option value=""> 검색 항목 </option>
	  <option value="b_title"> 제목 </option>
	  <option value="b_name"> 작성자 </option> 
	</select>
	<input type="text" name="searchw" value=""> 
	<input type="submit" value="검색">
	</form>
	<p> 
	<table border=1> 
	 <tr>   	
	 	<th> 번호 </th> 
	 	<th> 제목</th> 
	    <th> 작성자 </th>
	    <th> 이미지 </th>
	 </tr>
<%
	try{
		/* table field 변수 설정 */
		String b_title, b_name, b_filename;
		int b_id;  
		int datacount =0; 
		int pagecount;   
		
		Class.forName("com.mysql.jdbc.Driver"); 
		 /* jdbc Driver 설정 */ 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addb?useUnicode=true&charaterEncoding=utf8","kim","1234");
		 /* 데이터베이스 연결   
		 데이터 베이스에서 실행할 질의어(쿼리) 처리*/ 
		Statement stmt = con.createStatement(); 
		// 쿼리문장을 쓰기위한 stmt 선언
	   ResultSet rs0 = stmt.executeQuery("select count(b_id) from mboard"); 
	   if(rs0.next()){
		   datacount = rs0.getInt(1); 
		   rs0.close(); 
	   }
	   /* page 노출 수 지정 */
	   int pagesize = 4; 
	   pagecount = datacount/ pagesize + 1; 
	   int mypage = 1; 
	   int abpage = 1;  
	   if(request.getParameter("mypage") !=null){
		   mypage = Integer.parseInt(request.getParameter("mypage")); 
		   abpage = (mypage-1)*pagesize; 
		   if(abpage <=0) abpage=1; 
	   }
	   
	   ResultSet rs = stmt.executeQuery("select b_id, b_title, b_name, b_filename from mboard order by b_id desc"); 
	   if(!rs.next()){
		   pagesize = 0; 
	   } else {
		   rs.absolute(abpage); 
	   }
	    for(int k=1; k<=pagesize; k++){
	    	b_id = rs.getInt(1); 
	    	b_title = rs.getString(2); 
	    	b_name = rs.getString(3); 
	    	b_filename = rs.getString(4);
		   %> 
		<tr>  
			<td> <%=b_id %> </td>
			<td> <%=b_title %> </td> 
			<td> <%=b_name%> </td>
			<td> <img width="300px" height="300px" src="image/<%=b_filename %>"> </td>
		</tr>
		<%
		  if(rs.getRow()==datacount){
			   break; 
		   } else {
			   rs.next(); 
		   }   
	   }
	   rs.close();  /* select query 문 종료 */  
	   stmt.close();  /* query 문을 생성하기 위한 문 종료  */ 
	   con.close();   /*  작업 완료 후 데이터베이스 종료 문 */ 
		%> 
 <%
	if(pagecount !=1){
    for(int l=1; l<=pagecount; l++){
    	out.println("<a href=fsearch.jsp?mypage=" + l + ">" + l + "</a>|"); 
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