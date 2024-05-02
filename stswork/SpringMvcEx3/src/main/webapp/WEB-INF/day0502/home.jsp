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
   <h3>${msg }</h3>
   <h3><fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm"/></h3>

<h2>매핑연습</h2>
<ul>
<li><a href="apple/list">apple/list</a></li>
<li><a href="apple/list.do">apple/list.do</a></li>
<li><a href="apple/list.naver">apple/list.naver</a></li>
<li><a href="banana/insert">banana/insert</a></li>
</ul>

<h2>이미지 출력 연습</h2>
<ul>
<li><a href="shop/detail">resources의 이미지 출력</li>
</ul>

<h2>이미지 출력 문제</h2>
<ul>
	<li><a href="sist/java/four">이미지출력성공</li>

</ul>


</body>
</html>
