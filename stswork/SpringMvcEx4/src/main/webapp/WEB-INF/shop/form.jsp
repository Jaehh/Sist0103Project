<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="read">
		<table class="table table-bordered" style="width: 300px;">
		<tr>
		<th>아이디</th>
		<td>
			<input type="text" name="myid" class="form-control"
			style="width:130px;">
		</td>
		</tr>
		
		<tr>
		<th>비밀번호</th>
		<td>
			<input type="password" name="mypass" class="form-control"
			style="width:160px;">
		</td>
		</tr>
		
		<tr>
		<td colspan="2" align="center">
		<button type="submit" class="btn btn-info">데이터전송</button>
		</td>
		</tr>
		</table>
	</form>
</body>
</html>