<%@page import="ajaxboard.AjaxBoardDao"%>
<%@page import="ajaxboard.AjaxBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

/* insert와 다르게 hidden으로 처리된 num값도 받아서 처리해줘야 함 */
String num = request.getParameter("unum");
String writer=request.getParameter("uwriter");
String subject=request.getParameter("usubject");
String content=request.getParameter("ucontent");
String avata=request.getParameter("uavata");

//dto
//dto에 새로 수정된 값을 넣어줌
AjaxBoardDto dto=new AjaxBoardDto();
dto.setNum(num);
dto.setWriter(writer);
dto.setSubject(subject);
dto.setContent(content);
dto.setAvata(avata);

//dao 선언
//update에 수정된 dto를 넣어주기 위해서
AjaxBoardDao dao=new AjaxBoardDao();

//update
dao.updateBoard(dto);
%>


