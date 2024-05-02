<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    List<String> list=new ArrayList<>();
  
    list.add("red");
    list.add("green");
    list.add("gray");
    list.add("yellow");
    list.add("pink");
    list.add("orange");
    
    request.setAttribute("list", list);
    request.setAttribute("totalCount",list.size());
    
    //세션
    session.setAttribute("myid", "angel");
  %>
  
  <h3>1~10까지 출력</h3>
  <c:forEach var="a" begin="1" end="10">
    ${a }&nbsp;
  </c:forEach>
  
  <h3>0~30까지 3의배수출력</h3>
  <c:forEach var="a" begin="0" end="30" step="3">
     ${a }&nbsp;
  </c:forEach>
  <hr>
  <h3>list에는 총${totalCount }개의 색상이 있습니다</h3>
  
  <%--${변수명} requestScope가 생략되어있음 request에 저장된 데이타는 자바처럼 
  getAttribute로 얻지않아도 출력가능 --%>
  
  <h3>list에는 총${requestScope.totalCount }개의 색상이 있습니다</h3>  
   
    <%--세션아이디 출력 sessionScope는 생략하지 않는다--%>
   <h3>현재 로그인한 아이디는 ${sessionScope.myid } 입니다</h3>
   <h3>현재 로그인한 아이디는 ${myid } 입니다</h3> 
  
  
  <hr>
  <h3>list 테이블로 출력하기</h3>
  
  <table class="table table-bordered" style="width: 300px;">
     <tr>
        <th>번호</th><th>인덱스</th><th>색상</th>
     </tr>
     
     <c:forEach  var="s" items="${list }" varStatus="i">
       <tr>
         <td>${i.count }</td>
         <td>${i.index }</td>
         <td>
            <b style="color: ${s}">${s }</b>
         </td>
       </tr>
     </c:forEach>
  </table>
</body>
</html>