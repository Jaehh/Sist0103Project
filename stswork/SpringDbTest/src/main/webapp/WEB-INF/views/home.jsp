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
<div style="margin: 30px 50px;">
	<h3 class="alert alert-danger">MyShop목록</h3>
	<br>
	<h3 class="alert alert-danger">총 ${totalCount}개</h3>
	<table class="table table-bordered" style="width: 800px;">
		<tr>
			<th width="100" align="center">상품번호</th>
			<th width="300" align="center">상품명</th>
			<th width="200" align="center">가격</th>
			<th width="180" align="center">입고일</th>
			<th width="180" align="center">비고</th>
		</tr>
		
		<c:if test="${totalCount==0}">
			<tr>
				<td colspan="5" align="center">
					<b>등록된 상품이 없습니다</b>
				</td>
			</tr>
		</c:if>
		
		<c:if test="${totalCount>0}">
			<c:forEach var="dto" items="${list}" varStatus="i">
				<tr>
					<td align="center">${i.count}</td>
					<td >
						<img alt="" src="res/image2/${dto.photo}.jpg" width="50" height="50">
						<b>${dto.sang_name}</b>
					</td>
					<td align="center">
					<fmt:formatNumber value="${dto.price}" type="currency"/>
					</td>
					<td align="center">${dto.ipgoday}
					</td>
					<td>
						<button class="btn btn-info btn-sm">수정</button>
						<button class="btn btn-danger btn-sm">삭제</button>
					</td>
				</tr>
			</c:forEach>
		</c:if>
		<tr>
	</table>
</div>

</body>
</html>


