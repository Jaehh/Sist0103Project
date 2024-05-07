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
	<form action="read1" method="post">
		<table class="table table-bordered" style="width: 300px;">
			<tr>
				<th class="table-light">이름</th>
				<td>
					<input type="text" name="irum" class="form-control"
					style="width:120px;">
				</td>
			</tr>
			
			<tr>
				<th class="table-light">성별</th>
				<td>
					<input type="radio" name="gender" value="남자" checked="checked">남자 &nbsp;&nbsp;
					<input type="radio" name="gender" value="여자">여자
				</td>
			</tr>
			
			<tr>
				<th class="table-light">거주지역</th>
				<td>
					<select name="addr" class="form-control">
						<option value="서울">서울</option>
						<option value="인천">인천</option>
						<option value="경기">경기</option>
						<option value="대전">대전</option>
						<option value="세종">세종</option>
						<option value="제주">제주</option>
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

