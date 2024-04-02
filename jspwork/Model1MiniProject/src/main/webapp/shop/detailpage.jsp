<%@page import="java.text.NumberFormat"%>
<%@page import="data.dto.ShopDto"%>
<%@page import="data.dao.ShopDao"%>
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
<title>Insert title here</title>
<style type="text/css">
   img.large{
      width: 400px;
      height: 480px;
   }
</style>

</head>
<%
   String shopnum=request.getParameter("shopnum");
   String loginok=(String)session.getAttribute("loginok");
   String myid=(String)session.getAttribute("myid");
   //아이디에 해당하는 멤버 시퀀스
   MemberDao mdao=new MemberDao();
   String num=mdao.getNum(myid);
   
   //해당상품에대한 데이타
   ShopDao sdao=new ShopDao();
   ShopDto dto=sdao.getData(shopnum);
   
   NumberFormat nf=NumberFormat.getCurrencyInstance();
%>
<body>
<div style="margin: 50px 100px; width: 800px;">
    <form id="frm">
        <!-- hidden: 장바구니 db에 넣어야 할것 -->
        <input type="hidden" name="shopnum" value="<%=shopnum%>">
        <input type="hidden" name="num" value="<%=num%>">
        
        <table class="table">
           <tr>
             <td style="width: 500px;">
                <img alt="" src="shopsave/<%=dto.getPhoto()%>"
                class="large img-thumbnail">
             </td>
             <td style="width: 300px; padding-top: 50px;">
                <h4>카테고리: <%=dto.getCategory() %></h4><br>
                <h4>상품명: <%=dto.getSangpum() %></h4><br>
                <h4>가격: <%=nf.format(dto.getPrice()) %></h4><br>
                <!-- 갯수 -->
                <h4>갯수: 
                   <input type="number" min="1" max="10" value="1"
                   step="1" name="cnt" >
                  
                </h4><br>
                
                
                <div style="margin-top: 100px; margin-left: 60px;">
                   <button type="button" class="btn btn-info"
                   id="btncart">장바구니</button>
                   <button type="button" class="btn btn-success"
                   onclick="location.href='index.jsp?main=shop/shoplist.jsp'">상품목록</button>
                </div>
                
                
             </td>
           </tr>
        </table>
    </form>
    
    <script type="text/javascript">
    $("#btncart").click(function(){
    	var login="<%=loginok%>";
    	
    	if(login=="null"){
    		alert("먼저 로그인을 해주세요");
    		return;
    	}
    	
    	
    	//form태그 가져오기
    	var cartdata=$("#frm").serialize();
    	//alert(cartdata);
    	
    	//insert
    	$.ajax({
    		type:"post",
    		dataType:"html",
    		data:cartdata,
    		url:"shop/detailprocess.jsp",
    		success:function(){
    			
    			//alert("success");
    			
    			var a=confirm("장바구니에 저장하였습니다\n장바구니로 이동하려면 [확인]을 눌러주세요");
    			
    			if(a){
    				location.href="index.jsp?main=shop/mycart.jsp";
    			}
    		}
    	})
    	
    	
    })
    
    </script>
    
    
    
</div>
</body>
</html>