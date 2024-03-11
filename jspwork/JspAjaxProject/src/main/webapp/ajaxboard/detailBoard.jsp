<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="ajaxboard.AjaxBoardDto"%>
<%@page import="ajaxboard.AjaxBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%
String num = request.getParameter("num");

AjaxBoardDao dao = new AjaxBoardDao();

AjaxBoardDto dto = dao.getData(num);

JSONObject ob = new JSONObject();

//날짜타입 문자열 지정
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");

//json에 데이터 추가
ob.put("num",dto.getNum());
ob.put("writer",dto.getWriter());
ob.put("subject",dto.getSubject());
ob.put("content",dto.getContent());
ob.put("avata",dto.getAvata());
ob.put("writeday",sdf.format(dto.getWriteday()));

%>
<%=ob.toString()%>