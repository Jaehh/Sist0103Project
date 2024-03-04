<?xml version="1.0" encoding="UTF-8"?>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="mysql.db.DbConnect"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <data>
   
   <%
   DbConnect db= new DbConnect();
  Connection conn = db.getConnection();
  PreparedStatement pstmt = null;
  ResultSet rs = null;
 
  String sql="select * from food order by num";
  
  try{
	  pstmt=conn.prepareStatement(sql);
	  rs= pstmt.executeQuery();
	  
	  while(rs.next()){
		  String num = rs.getString("num");
		  String foodname = rs.getString("foodname");
		  String foodphoto = rs.getString("foodphoto");
		  String price = rs.getString("price");
		  String cnt = rs.getString("cnt");
		  %>
		  
		  <food num="<%=num %>>">
		      <foodphoto><%=foodphoto %></foodphoto>
		      <foodname><%=foodname %></foodname>
		      <price><%=price %></price>
		      <cnt><%=cnt %></cnt>
		  </food>
	  <%}
  }catch(SQLException e){
	  
  }finally{
	  db.dbClose(rs,pstmt,conn);
  }
   
   %>
   </data>


