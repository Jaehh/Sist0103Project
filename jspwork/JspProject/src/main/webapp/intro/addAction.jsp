<%@page import="intro.model.IntroDao"%>
<%@ page import="intro.model.IntroDto" %>
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

	 String name = request.getParameter("name");
	 String age = request.getParameter("age");
	 String birthday = request.getParameter("birthday");
	 String hometown = request.getParameter("hometown");
	 String hobby = request.getParameter("hobby");
	 String memo = request.getParameter("memo");
	 
	 //system.out.println(driver); //체크안하면 null, 체크하면 on
	 
	 //dto선언
	 IntroDto dto = new IntroDto();
	 dto.setName(name);
	 dto.setAge(age);
	 dto.setBirthday(birthday);
	 dto.setHometown(hometown);
	 dto.setHobby(hobby);
	 dto.setMemo(memo);
	 
	 //dao선언
	 IntroDao dao = new IntroDao();
	 
	 //insert메서드 호출
	 dao.insertIntro(dto);
	 
	 //목록파일로 이동
	 response.sendRedirect("introList.jsp");
	 
%>
</body>
</html>

