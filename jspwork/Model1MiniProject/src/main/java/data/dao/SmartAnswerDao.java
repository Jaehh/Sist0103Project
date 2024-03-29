package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dto.SmartAnswerDto;
import mysql.db.DbConnect;

public class SmartAnswerDao {
	
	DbConnect db = new DbConnect();
	
	public void insertAnswer(SmartAnswerDto dto) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql ="insert into smartanswer (num,nickname,content,writeday) values (?,?,?,now())";
		
		try {
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getNum());
			pstmt.setString(2, dto.getNickname());
			pstmt.setString(3, dto.getContent());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
				
	}
	
	//댓글출력
	public List<SmartAnswerDto> getAnswerList(String num){
		List<SmartAnswerDto> list = new ArrayList<SmartAnswerDto>();
	
		Connection conn = db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		String sql ="select * from smartanswer where num=? order by idx desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,num);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
			SmartAnswerDto dto = new SmartAnswerDto();
			
			dto.setIdx(rs.getString("idx"));
			dto.setNum(rs.getString("num"));
			dto.setNickname(rs.getString("nickname"));
			dto.setContent(rs.getString("content"));
			dto.setWirtetime(rs.getTimestamp("writeday"));
			
			list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
		
	}
}
