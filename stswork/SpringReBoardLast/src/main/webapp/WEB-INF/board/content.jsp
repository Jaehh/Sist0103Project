<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
 #answer{
 	margin-left: 20px;
 	padding: 10px 20px;
 	font-size:0.8em;
 }
</style>


<script type="text/javascript">
//trash 아이콘을 클릭하면 모달을 띄우고, 사용자가 입력한 비밀번호를 서버로 전송하는 함수
$(function(){
	$("i.adel").click(function(){
		var idx=$(this).attr("idx");
		var pass = prompt("비밀번호를 입력하세요:");

		if(pass == null){ //취소시 함수 종료
			return;
		}

        // AJAX를 사용하여 서버로 비밀번호와 함께 요청을 보냄
        $.ajax({
            url: "adelete", // 삭제를 처리할 컨트롤러의 엔드포인트 URL
            type: 'get',
            dataType: "json",
            data: { "idx": idx, "pass": pass }, // 삭제할 댓글의 ID와 입력된 비밀번호 전달
            success: function(res) {
                // 성공 또는 실패 여부에 따라 적절한 처리
                if(res.check == 0){
                	alert("비밀번호가 맞지 않습니다.");
                }else{
                	alert("댓글을 삭제합니다.");
                	location.reload();
                }
            },
            error: function(xhr, status, error) {
                console.error(error);
            }
        });
    });
});


</script>


</head>

<body>
<div style="margin: 100px 100px; width: 600px;">
   <table class="table table-bordered">
      <tr>
        <td>
          <h3><b>${dto.subject }</b></h3>
          <span style="float: right; margin-right: 20px;">조회  ${dto.readcount }&nbsp;&nbsp;&nbsp;&nbsp;
            <fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
          </span>
          <br>
          <h6><b>작성자  ${dto.writer }</b></h6>
        </td>
      </tr>
      
      <tr>
        <td>
          <pre>${dto.content }</pre>
          <br><br>
          <c:if test="${dto.photo!='no' }">
             <c:forTokens var="im" items="${dto.photo }" delims=",">
               <a href="../photo/${im }">
                 <img alt="" src="../photo/${im }" style="width: 100px;">
               </a>
             </c:forTokens>
          </c:if>
        </td>
      </tr>
      
      <tr>
      <td>
      	<div id="answer">
      	<b>댓글 ${acount}</b><br><br>
      	<c:forEach  var="a" items="${alist }">
      		${a.nickname}:${a.content}
      		&nbsp;&nbsp;
      		<span style="color:gray; font-size:0.8em;">
      		<fmt:formatDate value="${a.writeday }"/></span>
      	&nbsp;
      	<i class="bi bi-pencil-square" style="cursor:pointer;"></i>
      	<i class="adel bi bi-trash" idx="${a.idx}" onclick="deleteAnswer(${a.idx})" style="cursor:pointer;"></i>
      	</c:forEach>
      	
      	</div>
      	<form action="ainsert" method="post">
      		<input type="hidden" name="num" value="${dto.num}">
      		<input type="hidden" name="currentPage" value="${currentPage}">
      		<div class="d-inline-flex">
      			<b>닉네임: </b>
      			<input type="text" name="nickname" class="form-control"
      			style="width:100px;" required="required">
      			<b>비밀번호</b>
      			<input type="password" name="pass" class="form-control"
      			style="width:100px;" required="required"></div>
      			<br>
      			<div class="d-inline-flex">
      			<input type="text" name="content" class="form-control"
      			style="width:500px;" required="required" placeholder="댓글내용을 입력해주세요">
      			<button type="submit" class="btn btn-online-info">확인</button>
      		</div>
      	</form>
      </td>
      </tr>
      
      <tr>
        <td align="right">
          <button type="button" class="btn btn-outline-success"
          onclick="location.href='writeform'">글쓰기</button>
          <button type="button" class="btn btn-outline-success"
          onclick="location.href='writeform?num=${dto.num}&regroup=${dto.regroup }&restep=${dto.restep }&relevel=${dto.relevel }&currentPage=${currentPage }'">답글</button>
          <button type="button" class="btn btn-outline-success"
          onclick="location.href='updatepassform?num=${dto.num}&currentPage=${currentPage }'">수정</button>
           <button type="button" class="btn btn-outline-success"
          onclick="location.href='deletepassform?num=${dto.num}&currentPage=${currentPage }'">삭제</button>
           <button type="button" class="btn btn-outline-success"
          onclick="location.href='list?currentPage=${currentPage }'">목록</button>
        </td>
      </tr>
   </table>
</div>
</body>
</html>
