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
	<h3 class="alert alert-info">Ex1번 예제</h3>
	<br>
	<button type="button" id="btn1" class="btn btn-info">list1 Json 데이터 출력하기</button>
	<div id="out1"></div>
	
	<script type="text/javascript">
	$("#btn1").click(function(){
		
		$.ajax({
			type:"get",
			dataType:"json",
			url:"list1",
			success:function(res){
				$("#out1").empty();
				$("#out1").append("이름: "+res.name+"<br>");
				$("#out1").append("핸드폰: "+res.hp+"<br>");
				$("#out1").append("주소: "+res.addr+"<br>");
			}
		})
	})
	
	</script>
</body>
</html>

