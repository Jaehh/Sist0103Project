<%@page import="java.text.SimpleDateFormat"%>
<%@page import="uploadboard.data.UploadBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="uploadboard.data.UploadBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
   <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
   <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<title>Insert title here</title>

<style>
.icon {
    font-size: 24px; /* 아이콘 크기 */
     color: lightgray; /* 아이콘 색상 */
}

.btn{
	background-color:white;
	border:white;
}
</style>


</head>
<%
	UploadBoardDao dao = new UploadBoardDao();
	List<UploadBoardDto> list = dao.getAllDatas();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.");
	
%>


<body>
<div style="margin: 50px 100px; width:1000px;">

<!-- 리스트형 목록 -->
<button type="button" class="btn"
onclick="location.href='boardlist.jsp'">
<i class="bi bi-list icon" ></i>
</button>

<!-- 앨범형 목록 -->
<button type="button" class="btn" onclick="location.href='boardlist2.jsp'">
<i class="bi bi-grid-fill icon"></i>
</button>

<h6 class="alert alert-info">총 <%=list.size() %>개의 게시글이 있습니다</h6>

<table class="table table-hover">


<%
int count = 0; // 열의 카운터 변수
for (int i = 0; i < list.size(); i++) {
    if (count % 4 == 0) {
%>
    <div class="row">
<%
    }
%>
        <div class="col-md-3"><br>
<%
    // 각 게시물 정보를 가져오기
    UploadBoardDto dto = list.get(i);
%>
            <div style="width: 200px; height: 200px;  border: 1px solid lightgray;"><img alt="" src="../save/<%= dto.getImgname() %>" style="width: 200px; height: 200px;"></div><br>
            <a href="content.jsp?num=<%= dto.getNum() %>" style="text-decoration: none;"><%= dto.getSubject() %></a><br>
            <b style="color: gray; font-size: 9pt;"><%= dto.getWriter() %></b><br>
            <b style="color: lightgray; font-size: 9pt;"><%= sdf.format(dto.getWriteday()) %> </b>&nbsp;
            <b style="color: lightgray; font-size: 9pt;">조회&nbsp; <%= dto.getReadcount() %></b><br>
        </div>
<%
    count++;
    if (count % 4 == 0 || i == list.size() - 1) {
%>
    </div>
<%
    }
}
%>

</table>

</div>
</body>
</html>

