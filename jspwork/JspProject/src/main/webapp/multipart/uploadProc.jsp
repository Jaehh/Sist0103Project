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
	    //getServletContext()를 사용하여 Servlet Context를 가져옵니다.
		ServletContext context = getServletContext(); 
	
	    //getRealPath()를 사용하여 "save"라는 폴더의 실제 경로를 가져옵니다.
		String realFolder = context.getRealPath("save");
		
		System.out.println(realFolder);
		
		int fileSize=1024*1024*5;//파일 크기 제한을 설정 ,5MB로 설정
		
		MultipartRequest multi=null;
		
		try{
		//MultipartRequest 객체를 생성하여 파일 업로드를 처리
		multi=new MultipartRequest(request,realFolder,fileSize,"utf-8",
				new DefaultFileRenamePolicy()); //파일 이름의 충돌을 해결하기 위해 사용되는 파일 이름 정책,중복된 파일이름에 번호를 붙여 유일한 이름으로 변경
		
		//파일 업로드가 성공하면 해당 정보를 변수에 저장
		String name=multi.getParameter("name");
		String subject=multi.getParameter("subject");
		String uploadFileName=multi.getFilesystemName("uploadFile");
		String originalFileName = multi.getOriginalFileName("uploadFile");
		%>
		
		<table class="table" style="width:300px;">
		<tr>
			<th>이름</th>
			<td><%=name %></td>
		</tr>
		
		<tr>
			<th>제목</th>
			<td><%=subject %></td>
		</tr>
		
		<tr>
			<th>업로드 파일명</th>
			<td>
			<!-- 업로드된 이미지를 화면에 표시 -->
				<img src="../save/<%=uploadFileName%>"> 
			</td>
		</tr>
		
		<tr>
		<th>원래파일명</th>
		<td><%=originalFileName %></td>
		</tr>
		
		<tr>
		<!-- "다시 업로드 하기" 버튼을 클릭하면 업로드 폼인 "uploadForm.jsp"로 이동 -->
		<td colspan="2" align="center">
			<input type="button" value="다시 업로드 하기"
			 onclick="location.href='uploadForm.jsp';">
		</td>
		</tr>
		
		</table>
		
		<%}catch(Exception e){
			
		}
	%>
</body>
</html>

