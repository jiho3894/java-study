<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.* " %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>검색 결과 처리 페이지 </title>
</head>
<style>
	* {
		font-family: 'Noto+Sans+KR';
	}

	html {
		width: 100%;
		background: linear-gradient(#EECDA3, #EF629F);
    display: flex;
    align-items: center;
    justify-content: center;
	}

  body {
  	width: 50%;
    background: linear-gradient(#E0EAFC,#CFDEF3 );
    border-radius: 10px;
    box-shadow: 1px 1px 1px 1px black;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }

  h2 {
    text-align: center;
    color: hotpink;
  }

  form {
    width: 800px;
    display: flex;
    justify-content: center;
    align-items: center;
    margin: auto;
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
  
  tr th {
  	background-color: chartreuse;
  }
  
  td {
  	font-size: 20px;
  	font-weight: 500;
  	text-align:center;
  }
</style>
<body>
<% request.setCharacterEncoding("utf-8");  %>
<% 
   try{ 
	   String searchk = request.getParameter("searchk");
	   String searchw = request.getParameter("searchw");
	   /* table field 변수 설정 */
     String b_title, b_name, b_filename;
     int b_id = 0;
     int datacount = 0; 
     int pagecount; 
     Class.forName("com.mysql.jdbc.Driver"); 
	 		/* jdbc Driver 설정 */ 
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addb?useUnicode=true&charaterEncoding=utf8","kim","1234");
	 		/* 데이터베이스 연결   
	 		데이터 베이스에서 실행할 질의어(쿼리) 처리*/ 
		 Statement stmt = con.createStatement(); 
			// 쿼리문장을 쓰기위한 stmt 선언 
	   ResultSet rs0 = stmt.executeQuery("select count(b_id) from mboard where "+searchk+" like '%" + searchw +"%' "); 
	   if (rs0.next()){
	    	datacount=rs0.getInt(1); 
	    	rs0.close(); 
	    }
	   /* page 노출 수 지정 */
	   int pagesize = 10;
	   pagecount = datacount / pagesize; 
	   if(datacount % pagesize > 0){
	    	pagecount++; 
	   }
	   int mypage = 1; 
	   int abpage = 1; 
	   if(request.getParameter("mypage") !=null ){
	   		mypage = Integer.parseInt(request.getParameter("mypage")); 
	    	abpage = (mypage -1) * pagesize; 
	   if(abpage <=0 ) abpage =1; 
	   }
	   String sql = "select b_id, b_title, b_name, b_filename from mboard where "+searchk+" like '%"+searchw+"%' order by b_id desc"; 
	   ResultSet rs = stmt.executeQuery(sql); 
	   if(!rs.next()){
	    	pagesize = 0; 
	   } else {
	    	rs.absolute(abpage); 
	 }
%> 
  <h2>검색 결과 내용</h2>
		<header>
	 		<a href="fsearch.jsp">검색 페이지</a>
		    <span>||</span>
		  <a href="flist.jsp">리스트 페이지</a>
		</header>
	  <table border="1"> 
	    <tr>  
	      <th> 번호  </th>
	      <th> 제목  </th>
	      <th> 작성자 </th>  
	      <th> 이미지 </th>
	    </tr>
<%
	for(int k=1; k<=pagesize; k++){
	  b_id = rs.getInt(1);
	  b_title = rs.getString(2); 
	  b_name = rs.getString(3);    
	  b_filename = rs.getString(4);
%>
	    <tr> 
	      <td> <%=b_id %> </td>
	      <td> <%=b_title %> </td>
	      <td> <%=b_name %> </td> 
	      <td> <img width="300px" height="300px" src="image/<%=b_filename %>"> </td>
	    </tr>
<%
	if(rs.getRow()==datacount){
		break; 
	}	else {
		rs.next(); 
	}
}
	    %>
<%
  }
  catch(Exception e) {  /* 예외 처리문 - 오류 처리 문 */ 
		out.println(e); 
	}
%>
		</table>
	</body>
</html>