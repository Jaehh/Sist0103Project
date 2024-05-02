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
	<h2>퀴즈이미지출력_res2개 아무거나, WEB-INF의 image에서 아무거나 2개 출력할 것</h2>
	
	<h2>${quiz_title}</h2>
	
	<h2>리소스 폴더</h2>
	<img alt="" src="../../res/b5.png">
	<img alt="" src="../../res/image1/b7.png">
	
	<h2>WEB-INF</h2>
	<img alt="" src="../../image/01.png">
	<img alt=""src="../../image/shopimage/05.png">
</body>
</html>