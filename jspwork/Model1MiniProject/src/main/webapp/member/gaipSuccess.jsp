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
MemberDto dto = dao.getId(); // 회원가입 시 입력한 아이디를 기반으로 회원 정보를 가져옵니다.
%>

%>
<body>
    <div>
        <%-- 전달받은 회원의 이름을 출력합니다. --%>
        <h2>회원 가입을 축하합니다, <%= request.getParameter("name") %>님!</h2>
        <p>회원 가입이 성공적으로 완료되었습니다.</p>
    </div>
</body>
</html>
