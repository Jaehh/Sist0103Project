<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:set var="tot" value="${java+mysql } "/>
<c:set var="avg" value="${tot/2 } "/>
	<h2>점수 출력</h2>
	<pre>
	자바점수:${java }
	mysql점수:${mysql }
	
	총점:${tot}
	평균:${avg}
	</pre>
</body>
</html>