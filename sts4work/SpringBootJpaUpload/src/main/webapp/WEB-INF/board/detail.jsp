<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div style="margin:100px 100px; width:500px;">
<table class="table table-bordered">
        <tr>
            <th>Number</th>
            <td colspan="2">${dto.num}</td>
        </tr>
        <tr>
    <td>${dto.writer}</td>
            <td>${dto.subject}</td>
            <td><fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/></td>
        </tr>
        <tr>
             <td colspan="3">
             ${dto.content}<br>
            <img src="/save/${dto.photo}" alt="Photo" /></td>
        </tr>
        <tr>
       <td colspan="3">
		<button type="button" class="btn btn-outline-info btn-sm" 
		onclick="location.href='updateform?num=${dto.num}'">수정</button>
		<button type="button" class="btn btn-outline-danger btn-sm" 
		onclick="location.href='delete?num=${dto.num}'">삭제</button>
		<button type="button" class="btn btn-outline-info btn-sm" 
		onclick="location.href='/board/list'">목록</button>
		</td>
		</tr>
    </table>
</div>
</body>
</html>
