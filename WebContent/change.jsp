<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<%
	String b_title = null, b_content = null, b_name = null; 
    int b_id = Integer.parseInt(request.getParameter("b_id")); 
    
    out.println("번호:" + b_id + "<br />"); 
    Class.forName("com.mysql.jdbc.Driver"); 
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kdb?useUnicode=true&charaterEncoding=utf8","hana","123");
    Statement stmt = con.createStatement(); 
    ResultSet rs = stmt.executeQuery("select b_title, b_content from mboard where b_id="+ b_id); 
    //mboard 테이블에서 선택된 번호의 제목과 내용의 값을 찾는 쿼리문
    
    if(rs.next()){
   	 b_title = rs.getString(1);
   	 b_content = rs.getString(2);
    }
    
    rs.close(); // select query 문 종료
	stmt.close(); // query 문을 생성하기 위한 문 종료
	con.close();  // 작업 완료 후 데이터베이스 종료 문

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 리스트 수정 페이지 </title>
<style> 

table th{
  background:#FFD6FF; 
  color:#D9418C; 
}
  table {
   width:400px; 
  }
</style>
</head>
<body bgcolor='#FFD9EC'>
<form action="change_act.jsp" method="post"> 
  <table border=1> 
    <tr> <th> 제목  </th>
          <td> <input type="text" name="b_title" value="<%=b_title %> ">   </td>
     </tr>
      <tr> <th>내용주소 </th>
          <td> <textarea name ="b_content" rows = "5" cols = "45" value="<%=b_content %>"></textarea>   </td>
     </tr>
       <td colspan="2">   
       <input type="hidden" name="b_id" value="<%=b_id %>">
        <input type="submit" value="수정"> 
       </td> 
     </tr>
     
  </table>
</form>
</body>
</html>