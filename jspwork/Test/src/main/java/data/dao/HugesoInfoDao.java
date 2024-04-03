package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import data.dto.HugesoInfoDto;
import mysql.db.DbConnect;

public class HugesoInfoDao {
	
	DbConnect db=new DbConnect();
	
	
	//전체데이터 List에 담아서 리턴하는 메서드
		public List<HugesoInfoDto> getAllDatas(){
			List<HugesoInfoDto> list = new Vector<HugesoInfoDto>();
			
			Connection conn = db.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql ="select * from hugesoinfo order by h_num desc";
			
			try {
				pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					HugesoInfoDto dto = new HugesoInfoDto();
					
					dto.setH_num(rs.getString("h_num"));
					dto.setH_name(rs.getString("h_name"));
					dto.setH_xvalue(rs.getString("h_xvalue"));
					dto.setH_yvalue(rs.getString("h_yvalue"));
					dto.setH_sangphoto(rs.getString("h_sangphoto"));
					dto.setH_hp(rs.getString("h_hp"));
					dto.setH_addr(rs.getString("h_addr"));
					dto.setH_pyeon(rs.getString("h_pyeon"));
					dto.setH_brand(rs.getString("h_brand"));
					dto.setH_sangname(rs.getString("h_sangname"));
					dto.setH_sangprice(rs.getString("h_sangprice"));
					dto.setH_gasolin(rs.getString("h_gasolin"));
					dto.setH_disel(rs.getString("h_disel"));
					dto.setH_lpg(rs.getString("h_lpg"));
					
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
		
		//페이징..1.전체갯수반환   2.부분조회(startnum부터 perpage갯수만큼 반환)
				//1.전체갯수반환  
				
				public int getTotalCount()
				{
					
					int total=0;
					Connection conn=db.getConnection();
					PreparedStatement pstmt=null;
					ResultSet rs=null;
					
					String sql="select count(*) from hugesoinfo";
					
					try {
						pstmt=conn.prepareStatement(sql);
						rs=pstmt.executeQuery();
						
						if(rs.next())
							total=rs.getInt(1);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						db.dbClose(rs, pstmt, conn);
					}
					
					
					return total;
				}
				
				//2.부분조회(startnum부터 perpage갯수만큼 반환)
				public List<HugesoInfoDto> getPagingList(int startNum,int perPage)
				{
					List<HugesoInfoDto> list=new ArrayList<HugesoInfoDto>();
					
					Connection conn=db.getConnection();
					PreparedStatement pstmt=null;
					ResultSet rs=null;
					
					String sql="select * from hugesoinfo order by h_num desc limit ?,?";
					
					try {
						pstmt=conn.prepareStatement(sql);
						
						pstmt.setInt(1, startNum);
						pstmt.setInt(2, perPage);
						
						rs=pstmt.executeQuery();
						
						while(rs.next())
						{
							HugesoInfoDto dto=new HugesoInfoDto();
							
							dto.setH_num(rs.getString("h_num"));
							dto.setH_name(rs.getString("h_name"));
							dto.setH_xvalue(rs.getString("h_xvalue"));
							dto.setH_yvalue(rs.getString("h_yvalue"));
							dto.setH_sangphoto(rs.getString("h_sangphoto"));
							dto.setH_hp(rs.getString("h_hp"));
							dto.setH_addr(rs.getString("h_addr"));
							dto.setH_pyeon(rs.getString("h_pyeon"));
							dto.setH_brand(rs.getString("h_brand"));
							dto.setH_sangname(rs.getString("h_sangname"));
							dto.setH_sangprice(rs.getString("h_sangprice"));
							dto.setH_gasolin(rs.getString("h_gasolin"));
							dto.setH_disel(rs.getString("h_disel"));
							dto.setH_lpg(rs.getString("h_lpg"));
							
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

