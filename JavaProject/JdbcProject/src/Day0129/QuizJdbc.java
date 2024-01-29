package Day0129;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import oracleDb.DbConnect;

public class QuizJdbc {

	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);
	
	
	public void insertMember() {
		System.out.print("사원명을 입력하세요 : ");
		String s_name= sc.nextLine();
		System.out.print("부서를 입력하세요 :");
		String buseo = sc.nextLine();
		System.out.print("직급을 입력하세요 :");
		String position = sc.nextLine();
		System.out.print("성별을 입력하세요 : ");
		String gender = sc.nextLine();
		System.out.print("월급여를 입력하세요 :");
		BigDecimal pay = new BigDecimal(sc.nextLine());
		System.out.print("보너스를 입력하세요 : ");
		 BigDecimal bonus = new BigDecimal(sc.nextLine());
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		String sql ="insert into sawonmember (s_no,s_name,buseo,position,gender,pay,bonus,ipsaday) values (seq_smem.nextval,?,?,?,?,?,?,sysdate)";

		try {
			pstmt = conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, s_name);
			pstmt.setString(2, buseo);
			pstmt.setString(3, position);
			pstmt.setString(4, gender);
			pstmt.setBigDecimal(5, pay);
			pstmt.setBigDecimal(6, bonus);
			
			pstmt.execute();
			System.out.println("["+s_name+"] 사원이 추가되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void writeMember() {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from sawonmember order by s_no asc";
		
		 NumberFormat currencyFormatter = new DecimalFormat("###,###,###");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("사원번호\t사원명\t부서\t직급\t성별\t월급여\t보너스\t입사날짜");
			System.out.println("-------------------------------------------------------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("s_no")+"\t"
						+rs.getString("s_name")+"\t"
						+rs.getString("buseo")+"\t"
						+rs.getString("position")+"\t"
						+rs.getString("gender")+"\t"
						+rs.getString("pay")+"\t"
						+rs.getString("bonus")+"\t"
						+rs.getDate("ipsaday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
	}
	
	public void deleteMember() {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		System.out.print("삭제할 사원번호를 입력하세요 ===> ");
		int s_no = Integer.parseInt(sc.nextLine());
		
		String sql = "delete from sawonmember where s_no=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, s_no);
			
			int n = pstmt.executeUpdate();
			
			if(n==1) {
				System.out.println(s_no+"번 사원정보가 삭제되었습니다");
			} else {
				System.out.println("삭제를 실패하였습니다");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	public boolean isOneData(String s_no) {
		boolean b = false;
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="select * from sawonmember where s_no=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, s_no);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				b=false;
			}else {
				b=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt,conn);
		}
		return b;
	}
	
	public void updateMember() {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		System.out.print("수정할 사원번호를 입력하세요 ===> ");
		int s_no = Integer.parseInt(sc.nextLine());
		
		System.out.print("수정할 부서를 입력하세요 : ");
		String buseo = sc.nextLine();
		System.out.print("수정할 직급을 입력하세요 : ");
		String position = sc.nextLine();
		System.out.print("수정할 월급여를 입력하세요 : ");
		String pay = sc.nextLine();
		System.out.print("수정할 보너스를 입력하세요 : ");
		String bonus = sc.nextLine();
		
		String sql ="update sawonmember set buseo=?, position=?, pay=?, bonus=? where s_no=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, buseo);
			pstmt.setString(2, position);
			pstmt.setString(3,pay);
			pstmt.setString(4, bonus);
			pstmt.setInt(5, s_no);
			
			pstmt.execute();
			System.out.println(s_no+"사원정보가 수정되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	public void searchMember() {
		System.out.print("검색할 사원의 이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		String sql ="select s_no,s_name,buseo,position,gender,pay,bonus,ipsaday from sawonmember where s_name like?";
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+name+"%");
			rs = pstmt.executeQuery();
			
			System.out.println("사원번호\t사원명\t부서\t직급\t성별\t월급여\t보너스\t입사날짜");
			System.out.println("-------------------------------------------------------------------");
			
			while(rs.next()) {
				System.out.println(rs.getInt("s_no")+"\t"
						+rs.getString("s_name")+"\t"
						+rs.getString("buseo")+"\t"
						+rs.getString("position")+"\t"
						+rs.getString("gender")+"\t"
						+rs.getString("pay")+"\t"
						+rs.getString("bonus")+"\t"
						+rs.getDate("ipsaday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs,pstmt,conn);
		}
		
	}
	
	
	public void process() {
		while(true) {
			System.out.println();
			System.out.println("1.사원정보입력 2.전체사원출력 3.사원삭제 4.사원수정 5.이름검색 9.시스템종료");
			System.out.print("메뉴를 선택하세요 ===> ");
			int n = Integer.parseInt(sc.nextLine());
			
			if(n==1) {
				this.insertMember();
			}else if(n==2) {
			    this.writeMember();
			}else if(n==3) {
			    this.deleteMember();
			}else if(n==4) {
			    this.updateMember();
			}else if(n==5) {
			    this.searchMember();
			}else if(n==9) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
	}
	}
	public static void main(String[] args) {
		QuizJdbc jdbc = new QuizJdbc();
		jdbc.process();

	}

}
