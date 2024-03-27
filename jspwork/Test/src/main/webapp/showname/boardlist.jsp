<%@page import="uploadboard.data.UploadBoardDto"%>
<%@page import="java.text.SimpleDateFormat"%>
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
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
   <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>

<style>
.icon {
    font-size: 24px; /* 아이콘 크기 */
    color: white; /* 아이콘 색상 */

}
</style>
</head>
<%	
    //UploadBoardDao 인스턴스 생성
	UploadBoardDao dao = new UploadBoardDao();
    //모든 게시글 데이터 가져오기
	List<UploadBoardDto> list = dao.getAllDatas();
	 // 날짜 형식 지정을 위한 SimpleDateFormat 인스턴스 생성
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 
	//전체갯수
	int totalCount=dao.getTotalCount();
	int perPage=3; //한페이지당 보여질 글의 갯수
	int perBlock=5; //한블럭당 보여질 페이지 갯수
	int startNum; //db에서 가져올 글의 시작번호(mysql은 첫글이0번,오라클은 1번);
	int startPage; //각블럭당 보여질 시작페이지
	int endPage; //각블럭당 보여질 끝페이지
	int currentPage;  //현재페이지
	int totalPage; //총페이지수
	int no; //각페이지당 출력할 시작번호

	//현재페이지 읽는데 단 null일경우는 1페이지로 준다
	if(request.getParameter("currentPage")==null)
		currentPage=1;
	else
		currentPage=Integer.parseInt(request.getParameter("currentPage"));

	//총페이지수 구한다
	//총글갯수/한페이지당보여질갯수로 나눔(7/5=1)
	//나머지가 1이라도 있으면 무조건 1페이지 추가(1+1=2페이지가 필요)
	totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);

	//각블럭당 보여질 시작페이지
	//perBlock=5일경우 현재페이지가 1~5일경우 시작페이지가1,끝페이지가 5
	//현재가 13일경우 시작:11 끝:15
	startPage=(currentPage-1)/perBlock*perBlock+1;
	endPage=startPage+perBlock-1;

	//총페이지가 23일경우 마지막블럭은 끝페이지가 25가 아니라 23
	if(endPage>totalPage)
		endPage=totalPage;

	//각페이지에서 보여질 시작번호
	//1페이지:0, 2페이지:5 3페이지: 10.....
	startNum=(currentPage-1)*perPage;

	//각페이지당 출력할 시작번호 구하기
	//총글개수가 23  , 1페이지:23 2페이지:18  3페이지:13
	no=totalCount-(currentPage-1)*perPage;

	//각페이지당 출력할 시작번호 구하기
	//총글개수가 23  , 1페이지:23 2페이지:18  3페이지:13
	no=totalCount-(currentPage-1)*perPage;

	//페이지에서 보여질 글만 가져오기
	List<UploadBoardDto>list2=dao.getPagingList(startNum, perPage);

	
%>
<body>
<div style="margin: 50px 100px; width:1000px;">

<!-- 리스트형 목록 -->
<button type="button" class="btn btn-info"
onclick="location.href='boardlist.jsp'">
<i class="bi bi-list icon" ></i>
</button>


<!-- 앨범형 목록 -->
<button type="button" class="btn btn-warning" onclick="location.href='boardlist2.jsp'">
<i class="bi bi-grid-fill icon"></i>
</button>

<h6 class="alert alert-info">총 <%=list.size() %>개의 게시글이 있습니다</h6>

<table class="table table-hover">
<tr>
<th width="80">번호</th>
<th width="280">휴게소명</th>
<th width="160">평점</th>
<th width="250">영업시간</th>
<th width="250">조회</th>
</tr>

<%
for(int i=0;i<list.size();i++){
	//1번열에 출력할 번호
	int no = list.size()-i;
	
	//i번째 dto얻기
	UploadBoardDto dto = list.get(i);
	%>
	<tr>
	<td align="center"><%=no %></td>
	<td>
	<a href="content.jsp?num=<%=dto.getNum() %>" style="text-decoration: none;">
	<img alt="" src="../save/<%=dto.getImgname()%>" style="width: 30px;">
	<%=dto.getSubject() %></a>
	</td>
	<td><%=dto.getWriter() %></td>
	<td><%=sdf.format(dto.getWriteday()) %></td>
	<td><%=dto.getReadcount() %></td>
	</tr>
	
<%}
%>
</table>


  <!-- 페이지 번호 출력 -->
  <ul class="pagination justify-content-center">
  <%
  //이전
  if(startPage>1)
  {%>
	  <li class="page-item ">
	   <a class="page-link" href="boardlist.jsp?currentPage=<%=startPage-1%>" style="color: black;">이전</a>
	  </li>
  <%}
    for(int pp=startPage;pp<=endPage;pp++)
    {
    	if(pp==currentPage)
    	{%>
    		<li class="page-item active">
    		<a class="page-link" href="boardlist.jsp?currentPage=<%=pp%>"><%=pp %></a>
    		</li>
    	<%}else
    	{%>
    		<li class="page-item">
    		<a class="page-link" href="boardlist.jsp?currentPage=<%=pp%>"><%=pp %></a>
    		</li>
    	<%}
    }
    
    //다음
    if(endPage<totalPage)
    {%>
    	<li class="page-item">
    		<a  class="page-link" href="boardlist.jsp?currentPage=<%=endPage+1%>"
    		style="color: black;">다음</a>
    	</li>
    <%}
  %>
  
  </ul>
  

</div>
</body>
</html>

