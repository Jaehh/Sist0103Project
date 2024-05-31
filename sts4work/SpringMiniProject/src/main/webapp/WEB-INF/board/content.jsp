<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div style="margin: 50px 100px;">
	<table class="table table-bordered" style="width: 600px;">
		<tr>
			<td>
				<h3><b>${dto.subject}</b>
				<span style="color:gray; float: right; font-size: 12pt;">
					<fmt:formatDate value="${dto.writeday}" pattern="yyy-MM-dd HH:mm"/>
				</span>
				</h3>
				<span>작성자: ${dto.name}(${dto.myid})</span>
				
				<c:if test="${dto.uploadfile!='no'}">
					<span style="float:right;">
					<a href="download?clip=${dto.uploadfile}">
					<i class="bi bi-box-arrow-down" style="font-size:18pt; color:gray;"></i>
					<b>${dto.uploadfile}</b>
					</a>
					</span>
				</c:if>
			</td>
		</tr>
		
		<tr>
			<td>
				<c:if test="${bupload==true}">
					<h5>업로드된 파일이 이미지입니다</h5>
					<img alt="" src="../boardphoto/${dto.uploadfile}" style="max-width: 400px;">
				</c:if>
				
				<br><br>
				<pre>
					${dto.content}
				</pre>
				<br>
				<b>조회: ${dto.readcount}</b>&nbsp;&nbsp;
				<b>댓글: <span class="acount"></span></b>
			</td>
		</tr>
		
		<tr>
			<div class="alist"></div>
			<c:if test="${sessionScope.loginok!=null }">
				<div class="aform">
					<div class="d-inline-flex">
						<input type="text" class="form-control" style="width: 500px;"
						placeholder="댓글을 입력하세요" id="content">
						<button type="button" class="btn btn-info" style="width:60px;"
						id="btnansweradd">등록</button> 
					</div>
				</div>
			</c:if>
		</tr>
		
		<!-- 버튼들 -->
		<tr>
			<td align="right">
			
			<c:if test="${sessionScope.loginok!=null }">
				<button type="button" class="btn btn-outline-success" style="width:80px;"
				onclick="location.href='form'">글쓰기</button>
			</c:if>
			
				<button type="button" class="btn btn-outline-success" style="width:80px;"
				onclick="location.href='form'">목록</button>
			
			<c:if test="${sessionScope.loginok!=null and sessionScope.myid==dto.myid}">
				<button type="button" class="btn btn-outline-success" style="width:80px;"
				onclick="location.href='updateform?num=${dto.num}&currentPage=${currentPage}'">글쓰기</button>
			</c:if>
			
			<c:if test="${sessionScope.loginok!=null and sessionScope.myid==dto.myid}">
				<button type="button" class="btn btn-outline-success" style="width:80px;"
				onclick="location.href='delete?num=${dto.num}&currentPage=${currentPage}'">삭제</button>
			</c:if>
			</td>
			</tr>
	</table>
</div>
</body>
</html>
