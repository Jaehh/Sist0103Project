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
<link rel ="stylesheet" href="../css/style.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h2 class="alert alert-warning">${title}</h2>
	<img alt="" src="${myimg1}">
	
	<hr>
	
	<table style="width:200px;">
	<tr>
	<th>이름</th>
	<th>연락처</th>
	</tr>
	<tr>
	<td>홍길순</td><td>010-1111-2222</td>
	<tr>
	<tr>
	<td>이승기</td><td>010-1111-5555</td>
	<tr>
	</table>
</body>
</html>
