<%@page import="intro.model.IntroDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="intro.model.IntroDao"%>
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
<%
	IntroDao dao = new IntroDao();
	ArrayList<IntroDto>list = dao.getAllIntros();
%>
<body>
<div class="container">
<table class="table table-bordered" style="width: 500px;">
<tr class="table-primary">
<th width="60">이름</th>
<th width="60">나이</th>
<th width="60">생년월일</th>
<th width="60">거주지역</th>
<th width="60">취미</th>
<th width="60">성격</th>
</tr>

<%

	for(int i=0;i<list.size();i++){
		IntroDto dto= list.get(i);
		%>
		
		<tr>
		<td><%=dto.getName() %></td>
		<td><%=dto.getAge() %></td>
		<td><%=dto.getBirthday() %></td>
		<td><%=dto.getHometown() %></td>
		<td><%=dto.getHobby() %></td>
		<td><%=dto.getMemo() %></td>
		</tr>
	<%}

%>
</table>
</div>
</body>
</html>

