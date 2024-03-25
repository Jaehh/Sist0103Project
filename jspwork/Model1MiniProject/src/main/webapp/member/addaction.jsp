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
  String email=request.getParameter("email1")+"@"+request.getParameter("email2");
 String id = request.getParameter("id");
 String name = request.getParameter("name");
%>
<jsp:useBean id="dao" class="data.dao.MemberDao"/>
<jsp:useBean id="dto" class="data.dto.MemberDto"/>
<jsp:setProperty property="*" name="dto"/>
<%
    dto.setEmail(email);
    dao.insertMember(dto);
    
   /*  String id  = request.getParameter("id"); */

  
    // 회원 가입 성공 페이지로 이동하며, 회원의 이름을 전달합니다.
    response.sendRedirect("../index.jsp?main=member/gaipSuccess.jsp?id="+id);
%>

</body>
</html>