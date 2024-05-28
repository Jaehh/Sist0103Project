<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<h3 class="alert alert-info">총 ${mcount}명의 회원이 있습니다</h3>

<br>
<table class="table table-bordered" style="width:1000px;">
	<caption align="top"><b>전체 회원 명단</b></caption>
	<tr class="table-secondary">
		<th width="60">번호</th>
		<th width="130">회원명</th>
		<th width="120">아이디</th>
		<th width="160">핸드폰</th>
		<th width="250">주소</th>
		<th width="60">
		<input type="checkbox" id="allcheck">&nbsp;삭제
		</th>
	</tr>
	<c:forEach var="dto" items="${list}" varStatus="i">
		<tr>
			<td>${i.count}</td>
			<td>
				<img alt="" src="../memberphoto/${dto.photo}" style="width:30px; height:30px;">
				&nbsp;&nbsp;
			${dto.name}</td>
			<td>${dto.id}</td>
			<td>${dto.hp}</td>
			<td>${dto.addr}</td>
			<td>${dto.email}</td>
			<td>
				<input type="checkbox" num="${dto.num}" class="del">
			</td>
		</tr>
	</c:forEach>
</table>

<button type="button" class="btn btn-danger btn-sm"
style="margin-left:650px;">Delete</button>

</body>
</html>