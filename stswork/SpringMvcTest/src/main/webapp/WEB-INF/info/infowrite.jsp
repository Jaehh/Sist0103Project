<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
<h2 class="alert alert-danger">결과출력</h2>
<h3 style="color:${dto.color}">
이름: ${dto.name}<br>
취미:
<%-- <c:choose>
    <c:when test="${empty dto.hobby}">
        없음<br>
    </c:when>
    <c:otherwise>
        <c:forEach var="hobby" items="${dto.hobby}">
            [${hobby}]&nbsp;
        </c:forEach><br>
    </c:otherwise>
</c:choose>  --%>

<c:if test="${empty dto.hobby }">없음</c:if>
<c:if test="${!empty dto.hobby }">
<c:forEach var="hobby" items="${dto.hobby}">
            [${hobby}]&nbsp;
        </c:forEach>
</c:if>
<br>

가장 재미있는 언어: ${dto.lang}
</h3>
</body>
</html>
