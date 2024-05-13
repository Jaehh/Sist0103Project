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
<div style="margin: 100px 100px; width: 500px;">
   <form action="insert" method="post" enctype="multipart/form-data">
      <!-- hidden 5개 넣어준다 -->
      <input type="hidden" name="num" value="${num }">
      <input type="hidden" name="currentPage" value="${currentPage }">
      <input type="hidden" name="regroup" value="${regroup }">
      <input type="hidden" name="restep" value="${restep }">
      <input type="hidden" name="relevel" value="${relevel }">
      
      <table class="table table-bordered">
        <caption align="top"><b>
          <c:if test="${num==0 }">새글쓰기</c:if>
          <c:if test="${num!=0 }">답글쓰기</c:if>
        </b></caption>
        
        <tr>
          <th class="table-warning" style="width: 100px;">작성자</th>
          <td>
            <input type="text" name="writer" class="form-control" required="required"
            style="width: 150px;">
          </td>
        </tr>
        
        <tr>
          <th class="table-warning" style="width: 100px;">비밀번호</th>
          <td>
            <input type="password" name="pass" class="form-control" required="required"
            style="width: 150px;">
          </td>
        </tr>
        <tr>
          <th class="table-warning" style="width: 100px;">제목</th>
          <td>
            <input type="text" name="subject" class="form-control" required="required"
            style="width: 350px;">
          </td>
        </tr>
        <tr>
          <th class="table-warning" style="width: 100px;">사진</th>
          <td>
            <input type="file" name="upload" class="form-control" 
            style="width: 250px;" multiple="multiple">
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <textarea style="width: 500px; height: 150px;"
            name="content" class="form-control"
            required="required"></textarea>
          </td>
        </tr>
        <tr>
          <td colspan="2" align="center">
            <input type="submit" class="btn btn-info" value="저장하기">
          </td>
        </tr>
      </table>
   </form>
</div>
</body>
</html>