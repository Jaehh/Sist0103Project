<%@page import="QuizShop.model.QuizShopDto"%>
<%@page import="QuizShop.model.QuizShopDao"%>
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
<script type="text/javascript">
function funcDel(num)
{
	   var ans=confirm("정말 삭제하시겠습니까?");
	   if(ans){
		   location.href='deleteform.jsp?num='+num;
	   }
}
</script>

</head>
<%
  String num=request.getParameter("num");
  QuizShopDao dao=new QuizShopDao();
  QuizShopDto dto=dao.getData(num);
%>
<body>
<!-- 이미지가 크게 나오고 옆에 설명추가 
     상품명    가격     입고일
     
     맨아래   목록,수정,삭제    버튼3개추가-->

  <div style="margin: 50px 100px;">
   <form >
      <table class="table table-bordered" style="width: 600px;">
          <caption align="top"><b>상품 상세 정보</b></caption>
          <tr>
            <thead>
             <td rowspan="2" align="center">
             
         </td>
            <th width="100" >상품명</th>
            <th width="100"> 가격</th>
            <th width="100" >입고일</th>   
            </thead>
            
            <tbody>
            <td rowspan="2" align="center">
             <img src="../image/쇼핑몰사진/<%=dto.getPhoto()%>.jpg" style="width: 100px;">
         </td>
            <td>
            <input type="text" name="sang_name" required="required"
              class="form-control" style="width: 120px;" value="<%=dto.getSang_name()%>">
            </td>
            
            <td>
             <input type="text" name="price" required="required" 
             class="form-control" style="width: 120px; " value="<%=dto.getPrice()%>">
            </td>
           
              <td>
              <input type="text" name="ipgoday" required="required"
              class="form-control" style="width: 120px; " value="<%=dto.getIpgoday()%>">
            </td>
             </tbody>
          </tr>
          
          
          <tr>
            <td colspan="4" align="center">
            
            <input type="hidden" name="num" value="<%=num%>">
              <input type="button" value="목록" class="btn btn-outline-primary"
              onclick="location.href='shoplist.jsp'"
              style="width: 100px;">
              <input type="button" value="수정" onclick="location.href='updateform.jsp?num=<%=dto.getNum() %>'"
              class="btn btn-outline-success"
              style="width: 100px;">
              <input type="button" value="삭제" onclick="funcDel(<%=dto.getNum() %>)"
              class="btn btn-outline-warning"
              style="width: 100px;">
            </td>
          </tr>
          
      </table>
   </form>
</div>
     
</body>
</html>

