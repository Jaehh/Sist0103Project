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
    <%-- <c:redirect url="board/form"/> 폼으로 바로가게 할 수 있음--%>
	
	<a href="board/form">폼 데이터 읽기_기본</a><br>
	<a href="board/result2">이미지,css페이지_result2.jsp</a><br>
	<a href="board/list">이미지.js테스트_list.jsp</a><br><br>
	
	<!-- ShopController에서 -->
	<a href="shop/dtoform">폼데이터 읽기_dto_shop/formdto.jsp</a><br>
	<a href="shop/mapform">폼데이터 읽기_map_shop/formmap.jsp</a>
</body>
</html>