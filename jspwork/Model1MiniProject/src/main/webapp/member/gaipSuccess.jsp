<%@page import="data.dto.MemberDto"%>
<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 성공 페이지</title>
</head>
<%
String id = request.getParameter("id"); // 회원가입 시 입력한 아이디를 가져옵니다.
MemberDao dao = new MemberDao();
String name = dao.getName(id); // 회원가입 시 입력한 아이디를 기반으로 회원 정보를 가져옵니다.
%>


<body>
    <div style="margin: 0 atuo; width: 100%">
    <img alt="" src="image/11.png">
    <h2>회원 가입을 축하합니다, <%=name %>님!</h2>
        <p>회원 가입이 성공적으로 완료되었습니다.</p>
       <br><br>
       <button type="button" class="btn btn-info"
        onclick="location.href='index.jsp?main=login/loginmain.jsp'">로그인</button>
         <button type="button" class="btn btn-info"
         onclick="location.href='index.jsp'">마이페이지</button>
    </div>
</body>
</html>
