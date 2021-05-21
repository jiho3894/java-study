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
<body>
검색 내용을 확인 해 주세요 <br /> 
<form name="search_form" action="asearch_act.jsp" method="post" > 
<select name="searchk" style="height:20px; width:20%; background-color:#ccdd00;"> 
  <option value=""> 검색할 항목을 선택하세요 </option>
  <option value="name"> 이름 </option>
  <option value="dept"> 학과 </option> 
  <option value="address"> 주소 </option>
</select>
<input type="text" name="searchw" value=""> 
<input type="submit" value="검색">
</form>
<p> 
<table border=1> 
 <caption>  데이터 목록    </caption>
 <tr>   <th> 번호 </th> <th> 이름 </th> <!--  <th> 주소 </th>   -->  
         <th> 입학년도 </th>  <!-- <th> 학과 </th>   -->  
 </tr>
<%

try{
	String name, address, birthym, dept;  /*  String 형 변수 선언  */  
	int id;  /* 정수형 변수 선언 */ 
	int datacount =0;  /*  학생 정보 등록 목록 수  */  
	int pagecount;  /* 페이지 저장 변수 */ 
	
 Class.forName("com.mysql.jdbc.Driver"); 
 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addb","kim","1234");
 /*  if(conn !=null){
	 out.println("데이터베이스 연동 성공 <br /> "); 
	 System.out.println("연결정보:" + conn); 
	 System.out.println("연결정보(toString): " + conn.toString()); 
	 conn.close(); 
	 out.println("데이터베이스 연결 종료 <br />"); 
 } else {
	 out.println("데이터베이스 연동 실패 <br />"); 
 }
*/
   Statement stmt = conn.createStatement();
/* 목록페이지에서 페이징 처리 하는 코드  */ 
   ResultSet rs0 = stmt.executeQuery("select count(id) from test"); 
   if(rs0.next()){
	   datacount = rs0.getInt(1); 
	   rs0.close(); 
   }
   int pagesize = 4; 
   pagecount = datacount/(pagesize+1)+2; 
   int mypage = 2; 
   int abpage = 1; 
   if(request.getParameter("mypage") !=null){
	   mypage = Integer.parseInt(request.getParameter("mypage")); 
	   abpage = (mypage-1)*pagesize; 
	   if(abpage <=0) abpage=1; 
   }
   
   ResultSet rs = stmt.executeQuery("select id, name, address, birthym, dept from test order by id desc"); 
   if(!rs.next()){
	   pagesize = 0; 
   } else {
	   rs.absolute(abpage); 
   }
    for(int k=1; k<=pagesize; k++){
    	id = rs.getInt(1); 
    	name = rs.getString(2); 
    	address = rs.getString(3); 
    	birthym = rs.getString(4); 
    	dept = rs.getString(5); 
       
   /*
   while(rs.next()){
	   id = rs.getInt(1); 
	   name = rs.getString(2); 
	   address = rs.getString(3); 
	   birthym = rs.getString(4); 
	   dept = rs.getString(5);   */ 
	   
	   %> 
	   <tr>  
	     <td> <%=id %> </td>
	     <td> <a href="view.jsp?id=<%=id %>">  <%=name %>  </a> </td>
	   <!--   <td> <%=address %> </td>   --> 
	     <td> <%=birthym %> </td>
	   <!--   <td> <%=dept %> </td>    -->  
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
   conn.close();   /*  작업 완료 후 데이터베이스 종료 문 */ 
 %> 
 </table> 
 <%
    if(pagecount !=1){
    	for(int l=1; l<=pagecount; l++){
    		out.println("<a href=dbListSearch.jsp?mypage=" + l + ">" + l + "| </a>"); 
    	} 
    } else {
    		out.println("1"); 
    	}
   
}  catch(Exception e){  /* 예외 처리문 - 오류 처리 문 */ 
	out.println(e); 
}
%>

</body>
</html>