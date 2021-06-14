<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 지호의 사진 업로드 블로그 </title>
</head>
<style>
	* {
		font-family: 'Noto+Sans+KR';
	}
	
	html {
		width: 100vw;
		height: 100vh;
		background: linear-gradient(#fd746c, #ff9068);
    display: flex;
    align-items: center;
    justify-content: center;
	}

  body {
  	width: 700px;
    height: 700px;
    background: linear-gradient(#E0EAFC,#CFDEF3 );
    opacity: 0.8;
    border-radius: 10px;
    box-shadow: 1px 1px 1px 1px black;
  }

  h1 {
    text-align: center;
    color: hotpink;
  }

  form {
    width: 550px;
    height: 500px;
    display: flex;
    justify-content: center;
    align-items: center;
    margin: auto;
    border: 3px solid blue;
    background-color: skyblue;
    border-radius: 10px;
    flex-direction: column;
  }

  table {
    font-size: 20px;
    margin-left: 100px;
  }

  table th {
    height: 40px;
  }

  td .section {
    text-align: center;
    display: flex;
    justify-content: space-around;
  }

  button {
    width: 200px;
    height: 50px;
    margin-top: 30px;
    margin-right: 30px;
    font-size: 20px;
    font-weight: 600;
    cursor: pointer;
    border-radius: 2px;
    outline: none;
  }
  
  button:hover {
    background-color: skyblue;
  }
  
  input {
    font-size: 20px;
    outline: none;
    background: none;
    border-radius: 1px;
    border:none;
    border-bottom: 1px gray solid;
    background-color: transparent;
    margin-top: 10px;
    font-size: 16px;
    font-weight: 500;
  }
  
  .under input {
  	border-bottom: none;
  }

  footer {
    text-align: center;
    font-size: 25px;
    margin-top: 30px;
  }

  a {
    text-decoration: none;
    color: blueviolet;
    border-radius: 10px;
  }

  a:hover {
    background-color: skyblue;
  }
  
  div {
  	display: flex;
    align-items: center;
    justify-content: center;
  }
</style>
<body>
	<!-- 파일 업로드를 위한 form 작성 -->
	<h1> 지호의 사진 업로드 블로그 </h1>
	<form name="myform" action="fwrite_act.jsp" method="post" enctype="multipart/form-data"> 
		<table> 
      <tr> 
        <th> 이미지 파일 : </th>
        <td class="under"> <input type="file" name="filename"> </td> 
      </tr>
      <tr> 
        <th> 작성자 : </th>
        <td> <input type="text" name="name" value=""> </td> 
      </tr>
      <tr> 
        <th> 이메일 : </th>
        <td> <input type="text" name="mail" value=""> </td> 
      </tr>
      <tr> 
        <th> 제목 : </th>
        <td> <input type="text" name="title" value=""> </td> 
      </tr>
      <tr> 
        <th> 내용 : </th>
        <td> <textarea name="content" rows="5" cols="30"></textarea> </td> 
      </tr>
      <tr> 
        <th> 비밀번호 : </th>
        <td> <input type="password" name="pwd" value=""> </td> 
      </tr> 
		</table>
		<div>
			<!-- 업로드 or 다시입력 버튼 생성 -->
      <button class="btn" type="submit">업로드 </button>
      <button class="btn" type="reset">다시입력 </button>
		</div>
	</form>
  <footer>
	  <a href="flist.jsp"> 페이지 리스트로 이동 </a>
  </footer>
</body>
</html>