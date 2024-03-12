<%@page import="java.text.SimpleDateFormat"%>
<%@page import="QuizShop.model.QuizShopDto"%>
<%@page import="QuizShop.model.QuizShopDao"%>
<%@page import="java.util.List"%>
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
QuizShopDao dao = new QuizShopDao();
List<QuizShopDto>list = dao.getAllInfos();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
%>

<body>
<div style="margin:50px 50px; width: 800px;">
<h3 class="alert laert-info">QuizShop 입고목록</h3>
<br>
<button type="button" class="btn btn-info" onclick="location.href='addform.jsp'">상품추가</button>
<br>
<table class="table table-bordered">
<tr class="table-info">
<th width="60">번호</th>
<th width="60">상품명</th>
<th width="50">상품이미지</th>
<th width="80">가격</th>
<th width="100">입고일</th>
<th width="100">등록일</th>
</tr>

<%
for(int i=0;i<list.size();i++){
	QuizShopDto dto = list.get(i);
	%>
	<tr onclick="location.href='detailpage.jsp?num=<%=dto.getNum()%>'" style="cursor:pointer;">
	<td align="center"><%=i+1 %></td>
	<td align="center"><%=dto.getSang_name() %></td>
	<td align="center"><img src="../image/쇼핑몰사진/<%=dto.getPhoto() %>.jpg" width="50"></td>
	<td align="center"><%=dto.getPrice() %>원</td>
	<td align="center"><%=dto.getIpgoday() %></td>
	<td align="center"><%=sdf.format(dto.getWriteday()) %></td>
	</tr>
<%}
%>

</table>
</div>
</body>
</html>

