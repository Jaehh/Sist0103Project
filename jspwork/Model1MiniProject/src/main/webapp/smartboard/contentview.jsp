<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.SmartDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
  span.aday{
    float: right;
    font-size: 0.8em;
    color: gray;
  }
  
  div.alist{
    margin-left: 20px;
    font-size: 0.8em;
    color: gray;
  }
  
  span.day{
    color: gray;
    font-size: 0.8em;
  }

span.icon{
   margin-left: 20px;
   color: green;
}
</style>
<script type="text/javascript">
   
   $(function(){
	   
	   //처을 시작시 댓글 호출
	   list();
	   
	   var num=$("#num").val();
	   //alert(num);
	   
	   $("#btnsend").click(function(){
		   
		   var nick=$("#nickname").val().trim();
		   var content=$("#content").val().trim();
		   
		   
		   if(nickname.length==0){
			   alert("닉네임 입력후 저장해주세요");
			   return;
		   }
		   if(content==''){
			   alert("댓글입력후 저장해주세요");
			   return;
		   }
		   
		   $.ajax({
			   
			   type:"get",
			   url:"smartanswer/insertanswer.jsp",
			   dataType:"html",
			   data:{"num":num,"nickname":nick,"content":content},
			   success:function(){
				   
				   //alert("success!!");
				   //초기화
				   $("#nickname").val('');
				   $("#content").val('');
				   
				   //댓글추가후 댓글목록 다시 출력
				   list();
			   }
		   });
	   });
	   
	   
	   //삭제
	   $(document).on("click","i.adel",function(){
		   
		   var idx=$(this).attr("idx");
		   //alert(idx);
		   
		   var ans=confirm("댓글을 삭제하려면 [확인]을 눌러주새요");
		   
		   if(ans){
			   $.ajax({
				   
				   type:"get",
				   url:"smartanswer/deleteanswer.jsp",
				   dataType:"html",
				   data:{"idx":idx},
				   success:function(){
					   swal("삭제성공!", "삭제가 성공했어요", "success");
					   list();
				   }
			   });
		   }
	   });
	   
	   
	   
	   
	   //수정폼에 데이타 띠우기
	   $(document).on("click","i.amod",function(){
		   
		  idx=$(this).attr("idx");
		   //alert(idx);
		   
		   $.ajax({
			   type:"get",
			   url:"smartanswer/jsonupdateform.jsp",
			   dataType:"json",
			   data:{"idx":idx},
			   success:function(res){
				   
				   $("#unickname").val(res.nickname);
				   $("#ucontent").val(res.content);
			   }
		   });
		   
		   $("#myModal").modal("show");
	   });
	   
	   
	   //수정
	   $(document).on("click","#btnupdate",function(){
		  
		   var nickname=$("#unickname").val();
		   var content=$("#ucontent").val();
		   //alert(nickname+","+content);
		   
		   $.ajax({
			   type:"get",
			   url:"smartanswer/updateanswer.jsp",
			   dataType:"html",
			   data:{"idx":idx,"nickname":nickname,"content":content},
			   success:function(){
				   
				   list();
			   }
		   })
		   
		   
	   });
	   
	   
	   
	   
	   
   });
   
   
   
   function funcdel(num,currentPage){
	   
	   //alert(num+","+currentPage);
	   
	   var ans=confirm("삭제하려면 [확인]을 눌러주세요");
	   
	   if(ans){
		   location.href='smartboard/delete.jsp?num='+num+"&currentPage="+currentPage;
	   }
   }
   
   
   
   
   function list()
   {
	   console.log("list num="+$("#num").val());
	   //alert($("#num").val());
	   
	   $.ajax({
		   type:"get",
		   url:"smartanswer/listanswer.jsp",
		   dataType:"json",
		   data:{"num":$("#num").val()},
		   success:function(res){
			   
			   //댓글개수출ㄹ겨
			   $("b.acount>span").text(res.length);
			   
			   var s="";
			   $.each(res,function(idx,item){
				   s+="<div>"+item.nick+": "+item.content;
				   s+="<span class='aday'>"+item.writeday+"</span>";
				   s+="<span class='icon'><i class='bi bi-trash adel' idx="+item.idx+"></i>";
				   s+="<i class='bi bi-pencil-square amod' idx="+item.idx+"></i></span>";
				   s+="</div>";
			   });
			   
			   $("div.alist").html(s);
		   }
	   })
   }
</script>
</head>
<body>
  <!-- 상세페이지 적당히 만들어볼것!
   작성자,글제목,날짜,내용등등..조회수 증가도 포함
   맨아래에는 목록,글쓰기,수정,삭제 버튼 만들기 -->
   <jsp:useBean id="dao" class="data.dao.SmartDao"/>
   <%
      String num=request.getParameter("num");
      String currentPage=request.getParameter("currentPage");
      
      //조회수1증가
      dao.updateReadcount(num);
      //dto가져오기
      SmartDto dto=dao.getData(num);
      
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
   %>
   
   <div  style="margin: 50px 100px; width: 500px;">
   
   <input type="hidden" id="num" value="<%=num%>">
   
      <table class="table table-bordered">
         <caption align="top"><h3><b>
             <%=dto.getSubject() %>
         </b></h3></caption>
         
         <tr>
           <td>
              <b>작성자:  <%=dto.getWriter() %></b><br>
              <span class="day"><%=sdf.format(dto.getWriteday()) %></span>
              &nbsp;&nbsp;조회  <%=dto.getReadcount() %>
           </td>
         </tr>
         
         <tr height="150">
            <td>
              <%=dto.getContent().replace("\n", "<br>") %>
            </td>
         </tr>
         
         <!-- 댓글 -->
         <tr>
           <td>
               <b class="acount" >댓글<span>0</span></b>
               
               <div class="alist">
                  댓글목록
               </div>
               
               <div class="aform d-inline-flex">
                  <input type="text" id="nickname" class="form-control" style="width: 100px;"
                  placeholder="닉네임">
                  <input type="text" id="content" class="form-control" style="width: 300px;"
                  placeholder="댓글메세지">
                  <button type="button" id="btnsend" class="btn btn-info">저장</button>
               </div>
           </td>
         </tr>
         
         
         
         <tr>
            <td style="float: right;">
              <button type="button" class="btn btn-info btn-sm" 
              onclick="location.href='index.jsp?main=smartboard/smartform.jsp'"><i class="bi bi-pencil-fill"></i>글쓰기</button>
              <button type="button" class="btn btn-success btn-sm" 
              onclick="location.href='index.jsp?main=smartboard/boardlist.jsp'"><i class="bi bi-card-list"></i>목록</button>
              <button type="button" class="btn btn-warning btn-sm" 
              onclick="location.href='index.jsp?main=smartboard/updateform.jsp?num=<%=num%>&currentPage=<%=currentPage%>'"><i class="bi bi-pencil-square"></i>수정</button>
              <button type="button" class="btn btn-danger btn-sm" 
              onclick="funcdel(<%=num%>,<%=currentPage%>)"><i class="bi bi-trash"></i>삭제</button>
            </td>
         </tr>
      </table>
   </div>
   
   
   
   <!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">댓글수정</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <input type="text" id="unickname" style="width: 100px;" placeholder="닉네임">
        <input type="text" id="ucontent" style="width: 300px;" placeholder="댓글내용">
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" data-bs-dismiss="modal"
        id="btnupdate">댓글수정</button>
      </div>

    </div>
  </div>
</div>
</body>
</html>