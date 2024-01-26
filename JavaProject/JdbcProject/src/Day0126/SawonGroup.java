package Day0126;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracleDb.DbConnect;

public class SawonGroup {

	DbConnect db = new DbConnect();
	
	
	public void connectSawonGroup() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select gender, count(buseo) count,to_char(round(avg(pay),0),'L999,999,999') avgpay,"
				+ "to_char(max(pay),'L999,999,999') maxpay, to_char(min(pay),'L999,999,999') minpay "
				+ "from sawon group by gender";
		
		
		conn = db.getOracle();
		System.out.println("오라클 계정 연결 성공");
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("\t***회사 남녀별 급여통계***");
			System.out.println();
			System.out.println("성별\t인원수\t평균급여\t최고급여\t최저급여");
			System.out.println("-----------------------------------------------------");
		
		while(rs.next()) {
			String gender = rs.getString("gender");
			int count = rs.getInt("count");
			String avgpay = rs.getString("avgpay");
			String maxpay = rs.getString("maxpay");
			String minpay = rs.getString("minpay");
			
			System.out.println(gender+"\t"+count+"\t"+avgpay+"\t"+maxpay+"\t"+minpay);
		}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
	}
	
	public void personGroup() {
		// job별 인원수와 평균나이를 구해라
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql ="select job,count(job) su,avg(age) age from person group by job";
		
		conn = db.getOracle();
		
		System.out.println("오라클 계정 연결 성공");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("job별 인원수와 평균나이");
			System.out.println();
			System.out.println("직업\t인원수\t평균나이");
			System.out.println("-------------------------");
			
			while(rs.next()) {
				String job = rs.getString("job");
				int su = rs.getInt("su");
				int age = rs.getInt("age");
				
				System.out.println(job+"\t"+su+"\t"+age);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs,stmt,conn);
		}
		
	}
	
	public static void main(String[] args) {
		SawonGroup sgroup = new SawonGroup();
		//sgroup.connectSawonGroup();
		sgroup.personGroup();
	}

}
