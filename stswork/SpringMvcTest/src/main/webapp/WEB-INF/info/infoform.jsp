<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
 <form action="result" method="post">
      <table class="table table-bordered" style="width: 300px;">
         <tr>
           <th>이름</th>
           <td>
             <input type="text" name="name" class="form-control"
             style="width: 130px;">
           </td>
         </tr>
         
         <tr>
           <th>좋아하는 색상</th>
          <td>
             <input type="color" name="color" class="form-control"
             style="width: 130px;">
           </td>
         </tr>
         
         <tr>
           <th>취미</th>
          <td>
       	<input type="checkbox"  name="hobby" value="그림그리기"> 그림그리기<br>
		<input type="checkbox"  name="hobby" value="음악감상"> 음악감상<br>
		<input type="checkbox"  name="hobby" value="영화감상"> 영화감상<br>
		<input type="checkbox" name="hobby" value="베이킹"> 베이킹<br>
		<input type="checkbox" name="hobby" value="요리"> 요리<br>
        </td>
         </tr>
         
         <tr>
           <th>가장 재미있는 언어</th>
          <td>
            <select name="lang" class="form-control" style="width: 130px;">
    		<option value="java">java</option>
    		<option value="html">html</option>
    		<option value="ajax">ajax</option>
    		<option value="spring">spring</option>
			</select>
           </td>
         </tr>
         <tr>
           <td colspan="2" align="center">
             <button type="submit" class="btn btn-info">데이타전송</button>
           </td>
         </tr>
      </table>
   </form>
</body>
</html>

