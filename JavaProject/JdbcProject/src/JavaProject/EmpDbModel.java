package JavaProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import oracleDb.DbConnect;

public class EmpDbModel {
	DbConnect db = new DbConnect();
	
	//사원추가
	public void insertEmp(EmpDto dto) {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		String sql = "insert into employee values (seq_emp.nextval,?,?,?,?,?,?,?,?,sysdate)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1,dto.getName()); 
			pstmt.setString(2, dto.getPhoto());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getDept());
			pstmt.setString(5,dto.getPosition()); 
			pstmt.setString(6, dto.getAddr());
			pstmt.setString(7, dto.getPay());
			pstmt.setString(8, dto.getEmail());
			
			//업데이트
			pstmt.execute();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	
	//사원 전체조회
		public Vector<EmpDto> getAllEmp(){
			Vector<EmpDto> list = new Vector<EmpDto>();
			
			Connection conn = db.getOracle();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql ="select * from employee order by num";
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				rs= pstmt.executeQuery();
				
				while(rs.next()) {
					//db에서 하나의 레코드를 읽어서 dto에 넣는다
					EmpDto dto = new EmpDto();
					
					dto.setNum(rs.getString("num"));
					dto.setName(rs.getString("name"));
					dto.setPhoto(rs.getString("photo"));
					dto.setGender(rs.getString("gender"));
					dto.setDept(rs.getString("dept"));
					dto.setPosition(rs.getString("position"));
					dto.setAddr(rs.getString("addr"));
					dto.setPay(rs.getString("pay"));
					dto.setEmail(rs.getString("email"));
					dto.setIpsaday(rs.getString("ipsaday"));
					
					//list에 dto추가
					list.add(dto);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				db.dbClose(rs, pstmt,conn);
			}
			return list;
		}
		
		//사원 삭제
		public void deletEmp(EmpDto dto) {
			Connection conn = db.getOracle();
			PreparedStatement pstmt= null;
			
			String sql ="delete from employee where num=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getNum());
				
				pstmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				db.dbClose(pstmt, conn);
			}
			
		}
		
		// 사원 수정
		public EmpDto updateEmp(EmpDto dto) {
		    Connection conn = db.getOracle();
		    PreparedStatement pstmt = null;

		    String sql = "update employee set name=?, photo=?, gender=?, dept=?, position=?, addr=?, pay=?, email=?, ipsaday=? where num=?";

		    try {
		        pstmt = conn.prepareStatement(sql);

		        // 바인딩
		        pstmt.setString(1, dto.getName());
		        pstmt.setString(2, dto.getPhoto());
		        pstmt.setString(3, dto.getGender());
		        pstmt.setString(4, dto.getDept());
		        pstmt.setString(5, dto.getPosition());
		        pstmt.setString(6, dto.getAddr());
		        pstmt.setString(7, dto.getPay());
		        pstmt.setString(8, dto.getEmail());
		        pstmt.setString(9, dto.getIpsaday());
		        pstmt.setString(10, dto.getNum());

		        // 업데이트
		        pstmt.executeUpdate(); 
		        
		        // 업데이트 이후에 업데이트된 데이터를 검색하여 반환
		        //return updateEmp(empDto);
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		     
		    } finally {
		        db.dbClose(pstmt, conn);
		    }
			return dto;
		}
	    
	    //사원 이름 검색
	    public Vector<EmpDto> searchEmp(String name) {
	        Vector<EmpDto> list = new Vector<EmpDto>();

	        Connection conn = db.getOracle();
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;

	        String sql = "select * from employee where name like ? order by num";

	        try {
	            pstmt = conn.prepareStatement(sql);

	            // 바인딩
	            pstmt.setString(1, "%" + name + "%");

	            rs = pstmt.executeQuery();

	            while (rs.next()) {
	                // db에서 하나의 레코드를 읽어서 dto에 넣는다
	                EmpDto dto = new EmpDto();

	                dto.setNum(rs.getString("num"));
	                dto.setName(rs.getString("name"));
	                dto.setPhoto(rs.getString("photo"));
	                dto.setGender(rs.getString("gender"));
	                dto.setDept(rs.getString("dept"));
	                dto.setPosition(rs.getString("position"));
	                dto.setAddr(rs.getString("addr"));
	                dto.setPay(rs.getString("pay"));
	                dto.setEmail(rs.getString("email"));
	                dto.setIpsaday(rs.getString("ipsaday"));

	                // list에 dto추가
	                list.add(dto);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            db.dbClose(rs, pstmt, conn);
	        }
	        return list;
	    }
	public static void main(String[] args) {
		
	}

}
