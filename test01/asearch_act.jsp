<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.* " %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>검색 결과 처리 페이지 </title>
</head>
<body>
<% request.setCharacterEncoding("utf-8");  %>
<% 
   try{ /*  검색하는 항목  */ 
	   String searchk = request.getParameter("searchk");
        /*  검색하는 키워드  */ 
	   String searchw = request.getParameter("searchw");
        //System.out.println(searchk); 
        //System.out.println(searchw); 
        int id; 
        String name, address, birthym, dept;
        int datacount = 0; 
        int pagecount; /*  글목록 전체 페이지 수 저장 */ 
        /*  데이터베이스 연동   */
        /* 데이터베이스 드라이버 설정 */ 
        Class.forName("com.mysql.jdbc.Driver"); 
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addb?useUnicode=true&characterEncoding=utf8", "kim", "1234"); 
	    Statement stmt = con.createStatement(); 
	    ResultSet rs0 = stmt.executeQuery("select count(id) from test where "+searchk+" like '%" + searchw +"%' "); 
	    if (rs0.next()){
	    	datacount=rs0.getInt(1); 
	    	rs0.close(); 
	    }
	    int pagesize = 5; /* 한 페이지에 글 목록 수   */
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
	    String sql = "select id, name, dept, address, birthym from test where "+searchk+" like '%"+searchw+"%' order by id desc"; 
	    System.out.println(sql);  /* cosole 창에서 sql 문 확인 출력   */  
	    ResultSet rs = stmt.executeQuery(sql); 
	    if(!rs.next()){
	    	pagesize = 0; 
	    } else{
	    	rs.absolute(abpage); 
	    }
	    %> 
	    <div>  검색 결과 내용 </div>
	    <table border="1"> 
	      <tr> 
	        <th> 번호  </th> 
	        <th>  이름  </th>
	        <th>  주소  </th>  
	        <th>  입학년도   </th>
	       	<th> 학과  </th>
	     	</tr>
	    <%
	    for(int k=1; k<=pagesize; k++){
	    	id = rs.getInt(1); 
	      name = rs.getString(2); 
	      address = rs.getString(3); 
	      birthym = rs.getString(4); 
	      dept = rs.getString(5);     
	    %>
	    <tr> 
	    	<td> <%=id %>  </td>
	      <td> <%=name %> </td>
	      <td> <%=address %> </td> 
	      <td> <%=birthym %> </td> 
	      <td> <%=dept %> </td>  
	    </tr>
	    <%
	    if(rs.getRow()==datacount){
	      break; 
	    }	else{
	      	rs.next(); 
	    	}
	    }
	    %>
	  </table>
	<%
	if(pagecount !=1){
		for(int l=1; l<=pagecount; l++) {
			out.println("<a href=dbListSearch.jsp?mypage=" + l + ">" + l + " |</a>");
		}
	} else {
		out.println("1");
	}
		con.close(); 
	  stmt.close(); 
  } catch(Exception e) {
	  out.println(e); 
  }
	%>
<a href="dbListSearch.jsp">학생 정보 검색 페이지</a>
<a href="dbEx01.jsp">학생 정보 목록 페이지</a>
</body>
</html>