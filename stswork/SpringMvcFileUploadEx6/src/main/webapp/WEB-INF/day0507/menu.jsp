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
	<div style="margin: 50px 50px;">
		<button class="btn btn-info btn-lg" style="width:250px;"
		onclick="location.href='shop/form1'">각각 읽기</button>
		<br><br>
		<button class="btn btn-info btn-lg" style="width:250px;"
		onclick="location.href='shop/form2'">DTO로 읽기</button>
		<br><br>
		<button class="btn btn-info btn-lg" style="width:250px;"
		onclick="location.href='shop/form3'">Map으로 읽기</button>
		<br><br>
		<button class="btn btn-success btn-lg" style="width:250px;"
		onclick="location.href='board/uploadform1'">이미지 1개 업로드</button>
		<br><br>
		<button class="btn btn-success btn-lg" style="width:250px;"
		onclick="location.href='board/uploadform2'">이미지 여러개 업로드</button>
		<br><br>
	</div>

</body>
</html>

