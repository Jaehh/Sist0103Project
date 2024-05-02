
<%@page import="data.dto.HugesoInfoDto"%>
<%@page import="data.dao.HugesoInfoDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>

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
<title>HUEAT</title>

<style>

.icon1 , .icon2{
width: 30px;
    height: 30px;
}


.btn{
	background-color:white;
	border:white;
}


table, th, td{
    text-align: center; /* 가운데 정렬 */
    vertical-align: middle; /* 수직 정렬 */
    border : 1px solid lightgray;
    border-collapse: collapse;
}

/* table tr:not(:first-child):not(:nth-child(2)):hover { /* <tr>의 첫번째,두번째 형제 요소 제외하고 나머지 영역에만 css 적용(헤더 제외) */
	 background-color: lightgray;
} */
 /* <tr>의 첫번째,두번째 형제 요소 제외하고 나머지 영역에만 css 적용(헤더 제외) */
tr:hover {
	 background-color: lightgray;
} 

</style>
</head>
<%	
    //UploadBoardDao 인스턴스 생성
	HugesoInfoDao dao = new HugesoInfoDao();
    //모든 게시글 데이터 가져오기
	List<HugesoInfoDto> list = dao.getAllDatas();
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
	List<HugesoInfoDto>list2=dao.getPagingList(startNum, perPage);

	
%>
<body>

<script>

function List(type){
		const icon1 = document.querySelector(".icon1");
		const icon2 = document.querySelector(".icon2");
		
		if(type==0){
		icon1.style.color="red";
		icon2.style.color="";
		window.location.href="boardlist.jsp?color=red";
		}else{
			icon2.style.color="red";
			icon1.style.color="";
			window.location.href="boardlist2.jsp?color=red";
		}
		
}


document.addEventListener("DOMContentLoaded", function() {
    const urlParams = new URLSearchParams(window.location.search);
    const color = urlParams.get('color');

        document.querySelector(".icon1").style.color = "red";
        document.querySelector(".icon2").style.color = "lightgray";
   
});



</script>


<div style="margin: 400px 200px; width:1500px;">

<div style=" width:1500px;   text-align: center;">
<img src="../image/Food/1.jpg" alt="수면실" width="50" height="50">수면실
<img src="../image/Food/2.jpg" alt="샤워실" width="50" height="50">샤워실
<img src="../image/Food/3.jpg" alt="세탁실" width="50" height="50">세탁실
<img src="../image/Food/4.jpg" alt="세차장" width="50" height="50">세차장
<img src="../image/Food/5.jpg" alt="경정비" width="50" height="50">경정비
<img src="../image/Food/6.jpg" alt="수유실" width="50" height="50">수유실
<img src="../image/Food/7.jpg" alt="쉼터" width="50" height="50">쉼터
<img src="../image/Food/8.jpg" alt="ATM" width="50" height="50">ATM
<img src="../image/Food/9.jpg" alt="매점" width="50" height="50">매점
<img src="../image/Food/10.jpg" alt="약국" width="50" height="50">약국
<img src="../image/Food/11.jpg" alt="약국" width="50" height="50">기타


</div>


<!-- 리스트형 목록 -->
<button type="button" class="btn"
onclick="List(0)" style=" float: right;">
<i class="bi bi-list icon1" style="font-size: 25px; font-weight: bold;"></i>
</button>

<!-- 앨범형 목록 -->
<button type="button" class="btn" 
onclick="List(1)" style=" float: right;">
<i class="bi bi-grid-fill icon2" style="font-size: 25px; font-weight: bold;"> </i>
</button>


<table class="table">
<tr>
<th rowspan="2" width="250">휴게소</th>
<th rowspan="2" width="400">이정</th>
<th rowspan="2" width="250">전화번호</th>
<th colspan="2" width="250">편의시설</th>
<th rowspan="2" width="250">브랜드매장</th>
</tr>

<%

%>

<tr>
<th width="250">휴게소</th>
<th width="250">주유소</th>
</tr>
<% 
for(int i=0;i<list.size();i++){
    //1번열에 출력할 번호
    int num = list.size()-i;
    
    //i번째 dto얻기
    HugesoInfoDto dto = list.get(i);
    %>
    <tr>
    <td align="center"><%=dto.getH_name() %></td>
    <td><%=dto.getH_addr() %> </td>
    <td><%=dto.getH_hp() %> </td>
    <td>
        <% 
        String pyeons = dto.getH_pyeon(); //dto에 있는 편의시설 문자열을 pyeons에 넣어줌
        String[] pyeonArray = pyeons.split(","); //콤마를 기준으로 편의시설 문자열을 분리하여 배열 pyeonArray에 넣어줌
        for(String pyeon : pyeonArray){
        	 switch(pyeon){
        	 case "수면실":{
        		 %><img src="../image/Food/1.jpg" alt="수면실" width="50" height="50"><%
        	 break;
        	 }
        	 case "샤워실":{
        		 %><img src="../image/Food/2.jpg" alt="샤워실" width="50" height="50"><%
        				 break;
        	 }
        	 case "세탁실":{
        		 %><img src="../image/Food/3.jpg" alt="세탁실" width="50" height="50"><%
        				 break;
        	 }
        	 case "세차장":{
        		 %><img src="../image/Food/4.jpg" alt="세차장" width="50" height="50"><%
        				 break;
        	 }
        	 case "경정비":{
        		 %><img src="../image/Food/5.jpg" alt="경정비" width="50" height="50"><%
        				 break;
        	 }
        	 case "수유실":{
        		 %><img src="../image/Food/6.jpg" alt="수유실" width="50" height="50"><%
        				 break;
        	 }
        	 case "쉼터":{
        		 %><img src="../image/Food/7.jpg" alt="쉼터" width="50" height="50"><%
        				 break;
        	 }
        	 case "ATM":{
        		 %><img src="../image/Food/8.jpg" alt="ATM" width="50" height="50"><%
        				 break;
        	 }
        	 case "매점":{
        		 %><img src="../image/Food/9.jpg" alt="매점" width="50" height="50"><%
        				 break;
        	 }
        	 case "약국":{
        		 %><img src="../image/Food/10.jpg" alt="약국" width="50" height="50"><%
        				 break;
        	 }
        	 default:{ /* 기타 */
        		 %><img src="../image/Food/11.jpg" alt="약국" width="50" height="50"><%
        		 break;
        	 }
        	 
        	 }
          /*   out.println(pyeon); */ // 각 편의시설 출력
        }
        %>
    </td>
    <td></td>
    <td><%=dto.getH_brand() %></td>
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

