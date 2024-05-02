<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<h2>forEach문,forTokens문</h2>

<!--[1] [2]..[10]  -->
<c:forEach var="a" begin="1" end="10">
  [${a }]&nbsp;
</c:forEach>
<br>
<c:forEach var="a" begin="1" end="10" step="2">
  [${a }]&nbsp;
</c:forEach>
<br>

<%
String [] mycolors={"red","yellow","gray","green","cyan","orange","magenta"};

%>

<c:set value="<%=mycolors %>" var="mycolors"/>

<table class="table table-bordered" style="width: 300px;">
   <caption align="top"><b>전체출력</b></caption>
   <tr>
     <th>index</th><th>count</th><th>color</th>
   </tr>
   
   <c:forEach var="a" items="${mycolors }" varStatus="i">
     <!--items (리스트가 받아올 배열명)  varStatus(상태변수)  -->
     <tr align="center">
       <td>${i.index }</td>
       <td>${i.count }</td>
       <td style="background-color: ${a}">${a }</td>
     </tr>
   </c:forEach>
</table>

<table class="table table-bordered" style="width: 300px;">
   <caption align="top"><b>일부출력</b></caption>
   <tr>
     <th>index</th><th>count</th><th>color</th>
   </tr>
   
   <c:forEach var="a" items="${mycolors }" varStatus="i" begin="2" end="5">
     <!--items (리스트가 받아올 배열명)  varStatus(상태변수)  -->
     <tr align="center">
       <td>${i.index }</td>
       <td>${i.count }</td>
       <td style="background-color: ${a}">${a }</td>
     </tr>
   </c:forEach>
</table>

<hr>
<c:set var="flowers" value="장미,수국,다알리아,후리지아,라일락"/>

<h3>${flowers }</h3>

<h3>flowers값을 컴마로 분리해서 출력하기</h3>
<c:forTokens items="${flowers }" delims="," varStatus="i" var="s">
  <h3>${i.count}:${s }</h3>
</c:forTokens>


</body>
</html>