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
<div style="margin: 100px 100px; width:500px;">
	<form action="insert" method="post">
		<table class="table table-bordered">
			<caption align="top"><b>학생정보</b></caption>
			<tr>
				<th>학생명</th>
				<td>
					<input type="text" name="stuname" class="form-control"
					style="width:150px;" required="required">
				</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>
					<input type="text" name="stuhp" class="form-control"
					style="width:150px;" required="required">
				</td>
			</tr>
			<tr>
				<th>학생주소</th>
				<td>
					<input type="text" name="stuaddr" class="form-control"
					style="width:200px;" required="required">
				</td>
			</tr>
			<tr>
				<th>사진</th>
				<td>
					<select name="stuphoto">
						<option value="1.jpg" selected="selected">이미지1</option>
						<option value="2.jpg">이미지2</option>
						<option value="3.jpg">이미지3</option>
						<option value="4.jpg">이미지4</option>
						<option value="5.jpg">이미지5</option>
						<option value="6.jpg">이미지6</option>
						<option value="7.jpg">이미지7</option>
						<option value="8.jpg">이미지8</option>
						<option value="9.jpg">이미지9</option>
						<option value="10.jpg">이미지10</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" class="btn btn-info" value="저장">
					<input type="button" class="btn btn-info" value="목록"  onclick="location.href='list'">
				</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>
