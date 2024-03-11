package myworld.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;


import mysql.db.DbConnect;

public class WorldDao {

	//데이터베이스 연결을 담당하는 DbConnect 객체 생성
	DbConnect db=new DbConnect();
	
	 /**
     * 'myworld' 테이블에 레코드를 삽입하는 메서드
     * @param dto WorldDto 객체를 통해 전달된 정보를 사용하여 새로운 레코드를 추가합니다.
     */
	public void insertWorld(WorldDto dto)
	{
		// 데이터베이스 연결 객체 생성
		Connection conn=db.getConnection();
		// SQL 문을 실행할 PreparedStatement 객체
		PreparedStatement pstmt=null;
		// 쿼리 결과를 담을 ResultSet 객체
		ResultSet rs=null;
		
		// SQL 쿼리문
		String sql="insert into myworld values(null,?,?,?,now())";
		
		try {
			// SQL 문을 PreparedStatement에 설정
			pstmt=conn.prepareStatement(sql);
			
			 // WorldDto 객체에서 정보를 가져와 PreparedStatement에 설정
			  // PreparedStatement를 사용하여 SQL 쿼리의 파라미터 값을 설정
            // 1, 2, 3은 SQL 쿼리 안의 물음표(?)의 순서를 나타냄
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getAvata());
			
			// SQL 문 실행
			pstmt.execute();
		
		} catch (SQLException e) {
			// SQL 예외 처리
			e.printStackTrace();
		}finally {
			// 데이터베이스 연결 종료
			db.dbClose(pstmt, conn);
		}
		
				
	}
	
	/**
     * 'myworld' 테이블의 모든 레코드를 가져오는 메서드
     * @return 'myworld' 테이블의 모든 레코드를 담고 있는 WorldDto 객체 리스트
     */
	public List<WorldDto> getAllMyWorld()
	{
		// WorldDto 객체를 담을 리스트 생성
		List<WorldDto> list=new Vector<WorldDto>();
		// 데이터베이스 연결 객체 생성
		Connection conn=db.getConnection();
		// SQL 문을 실행할 PreparedStatement 객체
		PreparedStatement pstmt=null;
		// 쿼리 결과를 담을 ResultSet 객체
		ResultSet rs=null;
		
		// SQL 쿼리문
		String sql="select * from myworld order by num desc";
		
		try {
			// SQL 문을 PreparedStatement에 설정
			pstmt=conn.prepareStatement(sql);
			// SQL 문 실행 및 결과를 ResultSet에 저장
			rs=pstmt.executeQuery();
			
			 // ResultSet에서 레코드를 읽어와서 WorldDto 객체에 저장하고 리스트에 추가
			while(rs.next())
			{
				WorldDto dto=new WorldDto();
				
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setAvata(rs.getString("avata"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// SQL 예외 처리
			e.printStackTrace();
		}finally {
			// 데이터베이스 연결 종료
			db.dbClose(rs, pstmt, conn);
		}
		
		
		return list;
	}
	
	/**
     * 특정 번호에 해당하는 'myworld' 테이블의 레코드를 삭제하는 메서드
     * @param num 삭제할 레코드의 번호
     */
	//삭제
	public void deleteWorld(String num) {
		// 데이터베이스 연결 객체 생성
		Connection conn=db.getConnection();
		// SQL 문을 실행할 PreparedStatement 객체
		PreparedStatement pstmt=null;
		
		// SQL 쿼리문
		String sql="delete from myworld where num=?";
		
		try {
			// SQL 문을 PreparedStatement에 설정
			pstmt=conn.prepareStatement(sql);
			// 삭제할 레코드의 번호를 설정
			// PreparedStatement를 사용하여 SQL 쿼리의 파라미터 값을 설정
            // 여기서 1은 SQL 쿼리 안의 물음표(?)의 순서를 나타냄
			pstmt.setString(1, num);
			// SQL 문 실행
			pstmt.execute();
		}catch(SQLException e) {
			// SQL 예외 처리
			e.printStackTrace();
		}finally {
			// 데이터베이스 연결 종료
			db.dbClose(pstmt, conn);
		}
	}
	
	//num에 해당하는 dto반환
	public WorldDto getData(String num) {
		WorldDto dto = new WorldDto();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="select * from myworld where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
			dto.setNum(rs.getString("num"));
			dto.setWriter(rs.getString("writer"));
			dto.setContent(rs.getString("content"));
			dto.setAvata(rs.getString("avata"));
			dto.setWriteday(rs.getTimestamp("writeday"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt,conn);
		}
		
		return dto;
	}
	
	//수정
	public void updateWorld(WorldDto dto) {
		Connection conn = db.getConnection();
		
		PreparedStatement pstmt = null;
		
		String sql = "update myworld set writer=?, content=?, avata=? where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getAvata());
			pstmt.setString(4, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
}