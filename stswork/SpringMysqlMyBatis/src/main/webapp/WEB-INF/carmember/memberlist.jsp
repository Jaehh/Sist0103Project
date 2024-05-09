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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<div style="margin: 50px 100px; width: 800px;" >
 <button type="button" style="width: 100px; display: inline-block; margin-right: 10px;
  border: none; background: none; padding: 0;" onclick="location.href='../'">
 <i class="bi bi-house-door-fill" style="color: green; font-size: 24px;"></i>
</button>
  
<div style="margin-left: 600px; display: flex; justify-content: center;">
    <button type="button" class="btn btn-danger" style="width: 100px; display: inline-block; margin-right: 10px;" 
    onclick="location.href='writeform'">고객등록</button>
    <button type="button" class="btn btn-danger" style="width: 100px; display: inline-block;" 
    onclick="location.href='../samsung/list'">차목록</button>
</div>

		<br><br>

  <c:if test="${totalCount==0 }">
    <h5 class="alert alert-danger">저장된 회원의 정보가 없습니다</h5>
  </c:if>
  <c:if test="${totalCount>0 }">
     <h5 class="alert alert-danger">총 ${totalCount }개의 회원정보가 있습니다</h5>
     
     <hr>
     <table class="table table-bordered">
        <tr class="table-success">
                     <th width="60">번호</th>
					<th width="100">고객명</th>
					<th width="120">핸드폰</th>
					<th width="150">주소</th>
					<th width="150">가입일</th>
					<th width="120">편집</th>	
        </tr>
        
        <c:forEach var="dto" items="${list }" varStatus="i">
           <tr>
             <td>${i.count }</td>
             <td>${dto.name }</td>
             <td>${dto.hp}</td>
              <td>${dto.addr}</td>
             <td>
			 <fmt:formatDate value="${dto.gaipday}" pattern="yyyy-MM-dd HH:mm:ss"/>
		    </td>
             <td>
               <button type="button" class="btn btn-outline-info btn-sm"
               onclick="location.href='updateform?num=${dto.num}'">수정</button>
               <button type="button" class="btn btn-outline-danger btn-sm"
               onclick="location.href='delete?num=${dto.num}'">삭제</button>
             </td>
           </tr>
        </c:forEach>
        
     </table>
  </c:if>
</div>
</body>
</html>