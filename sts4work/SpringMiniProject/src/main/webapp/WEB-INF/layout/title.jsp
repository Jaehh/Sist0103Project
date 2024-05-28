<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
	div.login{
		position:absolute;
		left:800px;
		top:40px;
		width: 350px;
	}
</style>
</head>
<body>
  <c:set var="root" value="<%=request.getContextPath() %>"/>
  <a href="/">
	  <img alt="" src="${root }/image/title.png">
	  <b>SpringBoot+Mybatis+Tiles3</b>
  </a>
  
  <div class="login">
  	<button type="button" class="btn btn-success" style="width:100px;"
  	onclick="location.href='${root}/login/form'">Login</button>
  </div>
</body>
</html>