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
   <h2>get방식폼</h2>
   <form action="read1" method="get">
      이름:<input type="text" name="name" size="6"><br>
      나이:<input type="text" name="age" size="5"><br>
      <button type="submit">get방식 전송</button>
   </form>
   
   <h2>post방식폼_dto</h2>
   <form action="read2" method="post">
      상품:<input type="text" name="sang" size="10"><br>
      가격:<input type="text" name="price" size="7"><br>
      색상:<input type="text" name="color" size="10"><br>
      구입일:<input type="date" name="guipday" size="7"><br>
      <button type="submit">post방식 전송</button>
   </form>
   
   <h2>post방식폼_map</h2>
   <form action="read3" method="post">
      상품:<input type="text" name="sang" size="10"><br>
      가격:<input type="text" name="price" size="7"><br>
      색상:<input type="text" name="color" size="10"><br>
      
      <button type="submit">post방식 전송</button>
   </form>
</body>
</html>