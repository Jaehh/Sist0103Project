<%@page import="simpleboard.model.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
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
<%
String num = request.getParameter("num");
String pass = request.getParameter("pass");

	SimpleBoardDao dao = new SimpleBoardDao();
	
	boolean b = dao.isEqualPass(num, pass);

	if(b){
		dao.deleteBoard(num);
		response.sendRedirect("boardlist.jsp");
	}else{%>
		<script type="text/javascript">
		alert("비밀번호가 틀렸습니다");
		history.back();
		</script>
		<% }
	%>
</body>
</html>

