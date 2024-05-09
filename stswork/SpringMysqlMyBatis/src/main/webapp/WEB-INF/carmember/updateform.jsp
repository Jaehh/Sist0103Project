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
   <form action="update" method="post">
   <input type="hidden" name="num" value="${dto.num}">
     <table class="table table-bordered" style="width: 400px;">
       <tr>
         <th class="table-light">회원명</th>
         <td>
           <input type="text" name="name" style="width: 120px;" required="required"
           class="form-control" value="${dto.name}">
         </td>
       </tr>
       <tr>
         <th class="table-light">전화번호</th>
         <td>
           <input type="text" name="hp" style="width: 150px;" required="required"
           class="form-control" value="${dto.hp}">
         </td>
       </tr>
       <tr>
         <th class="table-light">주소</th>
         <td>
           <input type="text" name="addr" style="width: 150px;" required="required"
           class="form-control" value="${dto.addr}">
         </td>
       </tr>
       
       <tr>
         <td colspan="2" align="center">
           <button type="submit" class="btn btn-outline-success">DB저장</button>
           <button type="button" class="btn btn-outline-success" onclick="location.href='list'">목록으로</button>
         </td>
       </tr>
     </table>
   </form>
</body>
</html>
