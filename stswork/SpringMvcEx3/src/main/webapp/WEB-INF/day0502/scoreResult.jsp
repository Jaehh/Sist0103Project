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
	<h2>���� ���</h2>
	<pre>
	�ڹ�����:${java }
	mysql����:${mysql }
	
	����:${tot}
	���:${avg}
	</pre>
</body>
</html>