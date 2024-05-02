<%@page import="java.text.SimpleDateFormat"%>
<%@page import="simpleboard.model.SimpleBoardDto"%>
<%@page import="simpleboard.model.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
  body *{
    font-family: 'Noto Serif KR';
    font-size: 11pt;
  }
  
  span.day{
    color: #ccc;
    font-size: 0.8em;
  }
  
  span.aday{
   float: right;
   font-size: 0.8em;
   color: #bbb;
  }
  
  div.alist{margin-left: 20px;}
  
  i.amod{
    margin-left: 20px;
    color: green;
    cursor:pointer;
  }
  
  i.adel{
    color: red;
    cursor:pointer;
  }


.star-rating {
  display: flex;
  flex-direction: row-reverse;
  font-size: 2.25rem;
  line-height: 2.5rem;
  justify-content: space-around;
  padding: 0 0.2em;
  text-align: center;
  width: 5em;
}
 
.star-rating input {
  display: none;
}
 
.star-rating label {
  -webkit-text-fill-color: transparent; /* Will override color (regardless of order) */
  -webkit-text-stroke-width: 2.3px;
  -webkit-text-stroke-color: #2b2a29;
  cursor: pointer;
}
 
.star-rating :checked ~ label {
  -webkit-text-fill-color: gold;
}
 
.star-rating label:hover,
.star-rating label:hover ~ label {
  -webkit-text-fill-color: #fff58c;
}



</style>

<script type="text/javascript">
  $(function(){
	  
	  list();
	  
	  //ajax insert
	  var num=$("#num").val();
	  alert(num);
	  
	  // 저장 버튼 클릭 시 실행되는 함수
	    $("#btnasend").click(function() {
	        // 입력된 닉네임과 선택된 별점을 가져옴
	        var nickname = $("#nickname").val().trim();
	        var content = $("input[name='content']:checked").val();
	        
	        // 닉네임이나 별점이 입력되지 않았을 경우 알림 후 함수 종료
	        if (nickname === '') {
	            alert("닉네임을 입력한 후 저장해주세요.");
	            return;
	        }
	        if (!content) {
	            alert("별점을 선택한 후 저장해주세요.");
	            return;
	        }
	        
	        // AJAX 요청을 통해 서버에 데이터 전송
	        $.ajax({
	            type: "get",
	            url: "../simpleboardanswer/insertAnswer.jsp",
	            dataType: "html",
	            data: { "num": $("#num").val(), "nickname": nickname, "content": content },
	            success: function() {
	                // 입력값 초기화
	                $("#nickname").val('');
	                $("input[name='content']").prop('checked', false);
	                
	                // 댓글 목록 다시 불러오기
	                list();
	            },
	            error: function(xhr, status, error) {
	                // AJAX 요청 실패 시 에러 메시지 출력
	                console.error("AJAX Error: " + error);
	            }
	        });
	    });
	  
	  /* // 리스트의 삭제 이모티콘 클릭 시 (이벤트로 생겨났기 때문에동적으로 처리) 
	 $(document).on("click", ".adel", function(){
		  
		  var idx = $(this).attr("idx");
		  //alert(idx);
		  // 사용자에게 확인 메시지 표시
		    var confirmDelete = confirm("댓글을 삭제하시겠습니까?");
		    
		    if (confirmDelete) {
		        $.ajax({
		            type: "get",
		            url: "../simpleboardanswer/deleteAnswer.jsp",
		            data: {"idx": idx},
		            success: function(){
		                alert("댓글이 삭제되었습니다.");
		                list();    
		            }
		        });
		    }
		});
	  
	  //댓글 글자 누르면 댓글창 나오게
	  $("b.acount").click(function(){
    $("div.aupdateform").hide();
    $("div.aform").toggle();
});

// 일단 수정창 안보이게
$("div.aupdateform").hide();

// 댓글리스트의 수정아이콘 누르면 수정댓글창에 해당 idx의 내용 띄우기
$(document).on("click", ".amod", function(){
    $("div.aform").hide();
    $("div.aupdateform").show();
    
    var idx = $(this).attr("idx");
    //alert(idx);
    $("#idx").val(idx);
    
    $.ajax({
        type: "get",
        dataType: "json",
        url: "../simpleboardanswer/oneDataAnswer.jsp",
        data: {"idx": idx},
        success: function(res){
            $("#idx").val(res.idx);
            $("#unickname").val(res.nick);
            $("#ucontent").val(res.content);
        }
    });
});
 */
	  
	  
  
  
function list() {
    console.log("list num=" + $("#num").val());
    
    $.ajax({
        type: "get",
        url: "../simpleboardanswer/listAnswer.jsp",
        dataType: "json",
        data: { "num": $("#num").val() },
        success: function(res) {
            // 댓글 갯수 출력
            $("b.acount>span").text(res.length);
            
            
            var s = ""; // 변수 s를 빈 문자열로 초기화
            $.each(res, function(idx, item) {
                s += "<div>" + item.nick + ": ";
                
                // 별점에 따라 별표시 추가
                var starsHTML = "";
                for (var i = 5; i > 0; i--) {
                    if (i <= item.content) {
                        starsHTML += "<span class='star'>★</span>";
                    } else {
                        starsHTML += "<span class='star-empty'>☆</span>";
                    }
                }
                s += "<div class='star-rating'>" + starsHTML + "</div>";
                
                s += "<span class='aday'>" + item.writeday + "</span>";
                s += "<i class='bi bi-pencil-square amod' idx=" + item.idx + "></i>";
                s += "<i class='bi bi-trash adel' idx=" + item.idx + "></i>";
                s += "</div>";
            });

            $("div.alist").html(s);
        },
        error: function(xhr, status, error) {
            // AJAX 요청 실패 시 에러 메시지 출력
            console.error("AJAX Error: " + error);
        }
    });
}

  });
</script>

</head>
<%
	String num=request.getParameter("num");
	SimpleBoardDao dao=new SimpleBoardDao();
	//dto
	SimpleBoardDto dto=dao.getContent(num);
	//조회수1증가
	dao.updateReadCount(num);
	//날짜
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

%>

<input type="hidden" id="num" value="<%=num%>">


<div style="margin: 50px 100px; width: 500px;">
  <table class="table table-bordered">
     <caption align="top"><b style="font-size: 15pt;"><%=dto.getSubject() %></b></caption>
     <tr>
       <td>
         <b>작성자: <%=dto.getWriter() %></b><br>
         <span class="day"><%=sdf.format(dto.getWriteday()) %></span>
         &nbsp;&nbsp;&nbsp;&nbsp;조회: <%=dto.getReadcount() %>
       </td>
     </tr>
     <tr height="250">
       <td>
         <%=dto.getContent().replace("\n", "<br>") %>
       </td>
     </tr>
     
     <!-- 댓글 -->
     <tr>
       <td>
         <b class="acount">댓글<span>0</span></b>
         <div class="alist" id="alist">
             댓글목록
         </div>
         <div class="aform input-group">
            <input type="text" id="nickname" class="form-control"
            style="width: 80px;" placeholder="닉네임">
         
            
            
    <div class="star-rating space-x-4 mx-auto" id="content">
	<input type="radio" id="5-stars" name="content" value="5" v-model="ratings" />
	<label for="5-stars" class="star pr-4">★</label>
	<input type="radio" id="4-stars" name="content" value="4" v-model="ratings" />
	<label for="4-stars" class="star">★</label>
	<input type="radio" id="3-stars" name="content" value="3" v-model="ratings" />
	<label for="3-stars" class="star">★</label>
	<input type="radio" id="2-stars" name="content" value="2" v-model="ratings" />
	<label for="2-stars" class="star">★</label>
	<input type="radio" id="1-star" name="content" value="1" v-model="ratings" />
	<label for="1-star" class="star">★</label>
    </div>
            
            
            
            
            <button type="button" id="btnasend"
            class="btn btn-info btn-sm" style="margin-left: 10px;">저장</button>
         </div>
         
         <!-- 수정창 -->
         <%--  <div class="aupdateform input-group">
          <input type="hidden" id="idx">
            <input type="text" id="unickname" class="form-control"
            style="width: 80px;" placeholder="닉네임">
            <input type="text" id="ucontent" class="form-control"
            style="width: 300px; margin-left: 10px;" placeholder="댓글메세지">
            
            
            
            
            
            <button type="button" id="btnaUsend"
            class="btn btn-warning btn-sm" style="margin-left: 10px;">수정</button>
         </div>
       </td>
     </tr>
     
     <tr>
       <td align="center">
         <button type="button" class="btn btn-outline-info btn-sm"
         onclick="location.href='addform.jsp'"><i class="bi bi-pencil"></i>글쓰기</button>
         <button type="button" class="btn btn-outline-success btn-sm"
         onclick="location.href='boardlist.jsp'"><i class="bi bi-list-check"></i>목록</button>
         <button type="button" class="btn btn-outline-primary btn-sm"
         onclick="location.href='updatepassform.jsp?num=<%=dto.getNum()%>'"><i class="bi bi-pencil-square"></i>수정</button>
         <button type="button" class="btn btn-outline-danger btn-sm"
         onclick="location.href='deletepassform.jsp?num=<%=dto.getNum()%>'"><i class="bi bi-trash"></i>삭제</button>
       </td>
     </tr> --%>
  </table>
</div>
<body>

</body>
</html>