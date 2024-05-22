<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<div style="margin: 100px 100px;">
    <button type="button" class="btn btn-outline-info" onclick="location.href='addform'">도서등록</button>
    <br><br>

    <c:if test="${totalCount==0}">
        <div class="alert alert-info">
            <b>저장된 도서정보가 없습니다</b>
        </div>
    </c:if>

    <c:if test="${totalCount>0}">
        <div class="alert alert-danger">
            <b>${totalCount}개의 도서정보가 있습니다</b>
        </div>
    </c:if>
          
          <br>
          <c:forEach var="b" items="${bookList}">
            <table class="table table-bordered" style="width:500px;">
             <tr>
             <td>
                 <c:if test="${b.bookimage!=null}">
                   <img alt="" src="../bookphoto/${b.bookimage}" style="width:200px;" align="left" >
                  </c:if>
                    	
                  <c:if test="${a.bookimage==null}">
                   <img alt="" src="../bookphoto/noimage.jpg" style="width:200px;" align="left">
                   </c:if>
                    	
                       <h5>도서명: ${b.bookname}</h5>
                       <h5>저자: ${b.writer}</h5>
                        <h5>가격: <fmt:formatNumber value="${b.bookprice}" type="currency"/></h5>
                        <h5>출판사: ${b.bookcompany}</h5>
             <h5>입고일: <fmt:formatDate value="${b.ipgoday}" pattern="yyyy-MM-dd HH:mm"/></h5>
                <br><br>
                <h4>
                	<button type="button" class="btn btn-outline-primary"
                	onclick="location.href='updateform?num=${b.num}'">수정</button>
                	<button type="button" class="btn btn-outline-primary"
                	onclick="location.href='delete?num=${b.num}'">삭제</button>
                </h4>
                </td>
                </tr>
               
           </table>
       </c:forEach> 
      </div> 
</body>
</html>
