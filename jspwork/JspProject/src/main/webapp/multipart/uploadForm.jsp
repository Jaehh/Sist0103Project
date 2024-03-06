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
<!-- request로 못 받음 -->

<!-- action="uploadProc.jsp": 폼 데이터를 전송할 서버 측 스크립트 파일의 경로 또는 URL을 지정합니다. 여기서는 "uploadProc.jsp" 파일에 데이터를 전송
  method="post": 폼 데이터를 서버로 전송하는 HTTP 메서드를 지정합니다. "post" 메서드를 사용하면 데이터가 URL에 노출되지 않고 요청 본문에 포함
  enctype="multipart/form-data": 폼 데이터가 파일 업로드를 포함하고 있음을 서버에 알리는 속성/파일이나 이진 데이터를 전송할 때 사용-->
<form action="uploadProc.jsp" method="post" enctype="multipart/form-data"> 
	<table class="table table-bordered" style="width:500px;">
	<tr>
		<th width="100">이름</th>
		<td>
		<input type="text" name="name">
		</td>
	</tr>
	
	<tr>
		<th width="100">제목</th>
		<td>
		<input type="text" name="subject">
		</td>
	</tr>
	
	<tr>
		<th width="100">이미지</th>
		<td>
		<input type="file" name="uploadFile">
		</td>
	</tr>
	
	<tr>
	<td colspan="2" align="center">
	<input type="submit" value="업로드">
	</td>
	</tr>
	</table>
</form>
</body>
</html>

