<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="mysql.db.DbConnect"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<% 
	DbConnect db = new DbConnect();
	Connection conn = db.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql="select * from student order by num";
	
	String s= "[";
	
	try{
	pstmt = conn.prepareStatement(sql);
	rs= pstmt.executeQuery();
	
	while(rs.next()){
		String num= rs.getString("num");
		String name = rs.getString("name");
		String photo = rs.getString("photo");
		String java = rs.getString("java");
		String spring = rs.getString("spring");
		
		
		//json파싱  "num":num
		s+="{";
		s+="\"num\":"+num+",\"name\":\""+name+"\",\"photo\":\""+photo;
		s+="\",\"java\":"+java+",\"spring\":\""+spring+"\"";
		s+="},";
	}
	
	//마지막 컴마제거
	s=s.substring(0, s.length()-1);
	
	}catch(SQLException e){
		  e.printStackTrace();
	}finally{
		db.dbClose(rs,pstmt,conn);
	}
	
	s+="]";
%>

<%=s %>
