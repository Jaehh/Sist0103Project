<%@page import="data.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
   <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
   <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
 <style type="text/css">
  #mainimg{
  width:120px;
  height:120px;
  border-radius: 100px;
  margin-top: 25px;
  margin-left: 15px;
  
  }
  
</style>
<script type="text/javascript">
function delfunc(num){
	//alert(num);
	$("#delnum").val(num);
	$("#myModal").modal('show');
	
	//삭제버튼이벤트
	  $("button.btndel").click(function(){
		  
		  //num,pass읽기
		  var num=$("#delnum").val();
		  var pass=$("#delpass").val();
		  
		  //alert(num+","+pass);
		  //삭제파일 호출
		  location.href="member/deletemypage.jsp?num="+num+"&pass="+pass;
		  
	  })
}
</script>
</head>
<%
	MemberDao dao = new MemberDao();
	List<MemberDto> list = dao.getAllMembers();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	String loginok=(String)session.getAttribute("loginok");
	  String myid=(String)session.getAttribute("myid");

%>
<body>

	<div style="margin: 100px 200px; width: 800px;">
	<table class="table table-bordered">
		
			 <%
			 	for(MemberDto dto:list){
			 		  if(loginok!=null && myid.equals(dto.getId())){
			 	%>
			 		<tr>
			 		<td rowspan="6" align="center" valign="middle" style="width: 200px;">
			 			<img src="image/33.png" id="mainimg">
			 		</td>
			 		<td style="width:300px;">회원명: <%=dto.getName() %></td>
			 		<td rowspan="6" style="widith: 150px;" align="center" valign="middle" style="width: 200px;">
			 			<button type="button" class="btn btn-outline-info">수정</button>
			 			<button type="button" class="btn btn-outline-danger" onclick="delfunc('<%=dto.getNum()%>')">탈퇴</button>
			 		</td>
			 		</tr>
			 		<tr>
			 		<td>아이디: <%=dto.getId() %></td>
			 		</tr>
			 		
			 		<tr>
			 		<td>이메일: <%=dto.getEmail() %></td>
			 		</tr>
			 		
			 		<tr>
			 		<td>핸드폰: <%=dto.getHp() %></td>
			 		</tr>
			 		
			 		<tr>
			 		<td>주소: <%=dto.getAddr() %></td>
			 		</tr>
			 		
			 		<tr>
			 		<td>가입일: <%=sdf.format(dto.getGaipday()) %></td>
			 		</tr>
			 		
			 	<%}
			 
			 %>
			 <% }%>
	</table>
	
	</div>
	
	<!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content" >

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">삭제확인</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body d-inline-flex" >
      <input type="hidden" id="delnum">
        <b>삭제비밀번호: </b>
        <input type="password" id="delpass" class="form-control" style="width: 120px;">
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger btndel" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
	

</body>
</html>

