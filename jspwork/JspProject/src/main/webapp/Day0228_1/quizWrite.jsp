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
 	request.setCharacterEncoding("utf-8");

	String name=request.getParameter("name");
	String ipsa=request.getParameter("ipsa");
	String lunch=request.getParameter("lunch");
	String []menu=request.getParameterValues("menu");
	
	
%>

<h4 class="alert alert-info">
사원명: <%=name %><br><br>
입사일자:<%=ipsa %><br><br>
오늘 선택 점심메뉴: <img alt="" src="<%=lunch %>" style="width:100px; height:100px;"><br><br>
건의하는 메뉴: 
<%
	if(menu==null){%>
	<font color="red">건의하는 메뉴가 없음</font>	
	<%}else{
		for(int i=0;i<menu.length;i++){%>
		[<%=menu[i] %>]&nbsp;
	   <%}%>
	<%}
%>
</body>
</html>

