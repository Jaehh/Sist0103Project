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
<form action="shopwrite" method="post" enctype="multipart/form-data">
		
		<table class="table table-bordered" style="width: 400px;">
			<caption align="top"><b>0507_과제</b></caption>
			<tr>
			<th>상품명</th>
			<td>
			<input type="text" name="sang" class="form-control"
			style="width: 150px;">
			</td>
			</tr>
			
			<tr>
			<th>상품이미지</th>
			<td>
			<input type="file" name="photo" class="form-control"
			style="width: 250px;" multiple="multiple">
			</td>
			</tr>
			
			<tr>
			<th>가격</th>
			<td>
			<input type="text" name="price" class="form-control"
			style="width: 150px;">
			</td>
			</tr>
			
			<tr>
			<th>입고일</th>
			<td>
			<input type="date" name="ipgo" class="form-control"
			style="width: 150px;">
			</td>
			</tr>
			
			<tr>
			<td colspan="2" align="center">
			<button type="submit" class="btn btn-danger">업로드</button>
			</td>
			</tr>
		</table>
	
	</form>
</body>
</html>


