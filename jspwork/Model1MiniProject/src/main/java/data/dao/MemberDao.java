package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.dto.MemberDto;
import mysql.db.DbConnect;

public class MemberDao {

	DbConnect db=new DbConnect();
	
	//아이디 체크
	public int isIdCheck(String id)
	{
		int isid=0;
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select count(*) from member where id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				
				 if(rs.getInt(1)==1) 
					 isid=1;
				 
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		return isid;
	}
	
	//insert
	public void insertMember(MemberDto dto)
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="insert into member values(null,?,?,?,?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPass());
			pstmt.setString(4, dto.getHp());
			pstmt.setString(5, dto.getAddr());
			pstmt.setString(6, dto.getEmail());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}

	

	//id에 대한 dto반환
	/*
	 * public MemberDto getOneData(String id) { MemberDto dto=new MemberDto();
	 * 
	 * Connection conn=db.getConnection(); PreparedStatement pstmt=null; ResultSet
	 * rs=null;
	 * 
	 * String sql="select * from myinfo where id=?";
	 * 
	 * try { pstmt=conn.prepareStatement(sql); pstmt.setString(1, id);
	 * rs=pstmt.executeQuery();
	 * 
	 * if(rs.next()) { dto.setId(rs.getString("id"));
	 * dto.setName(rs.getString("name")); dto.setNum(rs.getString("num"));
	 * dto.setPass(rs.getString("pass")); dto.setHp(rs.getString("hp"));
	 * dto.setAddr(rs.getString("addr")); dto.setEmail(rs.getString("email"));
	 * 
	 * } } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }finally { db.dbClose(rs, pstmt, conn); }
	 * 
	 * 
	 * return dto; }
	 */
	
	public String getId() {
	    String id = null;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = db.getConnection();
	        String sql = "SELECT MAX(id) AS id FROM myinfo"; // 가장 최근에 추가된 회원의 ID를 가져옵니다.
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            id = rs.getString("id");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.dbClose(rs, pstmt, conn);
	    }

	    return id;
	}

	}

