<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<h1>폼데이터 DTO 읽기</h1>
<form action="show2" method="post">
	<table class="table table-bordered" style="width:300px;">
	<tr>
		<th>이름</th>
		<td>
			<input type="text" name="name" class="form-control" required="required">
		</td>
	</tr>
	
	<tr>
		<th>연락처</th>
		<td>
			<input type="text" name="hp" class="form-control" required="required">
		</td>
	</tr>
	
	<tr>
		<th>주소</th>
		<td>
			<input type="text" name="addr" class="form-control" required="required">
		</td>
	</tr>
	
	<tr>
	<td colspan="2" align="center">
		<button type="submit" class="btn btn-success">서버에 전송</button>
	</td>
	</tr>
	</table>
</form>
</body>
</html>
