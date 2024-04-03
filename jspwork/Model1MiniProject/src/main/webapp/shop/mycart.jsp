<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.ShopDao"%>
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
<style type="text/css">
img.photo{
	width: 60px;
	height: 80px;
	border: 2px solid gray;
}

div.sangpum{
cursor:pointer;
}
</style>
</head>
<%
  String id=(String)session.getAttribute("myid");
  ShopDao dao=new ShopDao();
  List<HashMap<String,String>> list=dao.getCartList(id);
%>
<body>
<h4 class="alert alert-info" style="width:1000px;"><%=id %>님의 장바구니</h4>

<table class="table table-striped" style="width:1000px;">
	<tr>
	<th style="width:30px;"><input type="checkbox" id="allcheck"></th>
	<th style="width:200px;">상품정보</th>
	<th style="width:200px;">상품금액</th>
	</tr>
	
	<%
	for(int i=0;i<list.size();i++){
		HashMap<String,String> map = list.get(i);
		
		//사진얻기
		String photo = map.get("photo");
		%>
		
		<tr>
		<td>
			<input type="checkbox" name="idx" idx="<%=map.get("idx")%>">
		</td>
		<td>
			<div class="sangpum" shopnum="<%=map.get("shopnum")%>">
				<img alt="" src="shopsave/<%=photo%>" class="photo" align="left" hspace="20">
			</div>
		</td>
		</tr>
	<% }
	
	%>
	
</table>
</body>
</html>