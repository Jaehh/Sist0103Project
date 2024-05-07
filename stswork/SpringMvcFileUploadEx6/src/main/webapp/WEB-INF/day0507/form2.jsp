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
	<form action="read2" method="post">
		<table class="table table-bordered" style="width: 300px;">
			<tr>
				<th class="table-light">상품명</th>
				<td>
					<input type="text" name="sang" class="form-control"
					style="width:120px;">
				</td>
			</tr>
			
			<tr>
				<th class="table-light">가격</th>
				<td>
					<input type="text" name="price" class="form-control"
					style="width:120px;">
				</td>
			</tr>
			
			<tr>
				<th class="table-light">색상</th>
				<td>
					<input type="color" name="color" class="form-control"
					style="width:120px;">
				</td>
			</tr>
			
			<tr>
				<th class="table-light">상품이미지</th>
				<td>
					<select name="image" class="form-control">
						<option value="1">사진1</option>
						<option value="2">사진2</option>
						<option value="3">사진3</option>
						<option value="4">사진4</option>
						<option value="5">사진5</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
				 <button type="submit" class="btn btn-info">데이타전송</button>
			</tr>
		</table>
	</form>
</body>
</html>

