<%@page import="data.dto.ShopDto"%>
<%@page import="data.dao.ShopDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	//업로드할 경로
	String uploadPath=getServletContext().getRealPath("/shopsave");
    System.out.println(uploadPath);
    
    //업로드할사이즈
    int uploadSize=1024*1024*5;
    
    MultipartRequest multi=null;
    
    try{
    	multi=new MultipartRequest(request,uploadPath,uploadSize,"utf-8",new DefaultFileRenamePolicy());
    	
    	String sangpum=multi.getParameter("sangpum");
    	String category=multi.getParameter("category");
    	String ipgoday=multi.getParameter("ipgoday");
    	int price=Integer.parseInt(multi.getParameter("price"));
    	String photo=multi.getFilesystemName("photo");
    	
    	System.out.println(photo);
    	
    	//dao
    	ShopDao dao=new ShopDao();
    	
    	//dto에 데이타담기
    	ShopDto dto=new ShopDto();
    	dto.setSangpum(sangpum);
    	dto.setCategory(category);
    	dto.setIpgoday(ipgoday);
    	dto.setPrice(price);
    	dto.setPhoto(photo);
    	
    	//db에추가
    	dao.insertShop(dto);
    	
    	//다시 상품품으로 이동
    	response.sendRedirect("../index.jsp?main=shop/addform.jsp");
    
    }catch(Exception e){
    	
    }
%>
</body>
</html>