package Day0126;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import oracleDb.DbConnect;

public class QuizStuInfo {

	DbConnect db = new DbConnect();
	
	public void insert() {
		Scanner sc = new Scanner(System.in);
		String s_name,s_gender,s_hp;
		int s_age;
		String sql = "";
		System.out.println("학생명을 입력하시오");
		s_name = sc.nextLine();
		
		System.out.println("성별을 입력하시오");
		s_gender = sc.nextLine();
		
		System.out.println("나이를 입력하시오");
		s_age = Integer.parseInt(sc.nextLine());
		
		System.out.println("연락처를 입력하시오");
		s_hp = sc.nextLine();
		
		sql = "insert into stuinfo values (seq_info.nextval,'"+s_name+"','"+s_gender+"','"+s_age+"','"+s_hp+"',sysdate)";
		//System.out.println(sql);
		
		Connection conn = null;
		Statement stmt = null;
		
		conn = db.getOracle();
		
		try {
			stmt = conn.createStatement();
			
			stmt.execute(sql);
			System.out.println("데이터가 추가되었습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
	}
	
	public void select() {
		String sql = "SELECT * FROM stuinfo order by s_no";
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;
		
		conn = db.getOracle();
		
		System.out.println("시퀀스\t학생명\t성별\t나이\t연락처\t\t가입날짜");
		System.out.println("---------------------------------------------------------");
		
		try {
			stmt= conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int s_no = rs.getInt("s_no");
				String s_name = rs.getString("s_name");
				String s_gender = rs.getString("s_gender");
				String s_age = rs.getString("s_age");
				String s_hp = rs.getString("s_hp");
				Date gaipday = rs.getDate("gaipday");
				
				System.out.println(s_no+"\t"+s_name+"\t"+s_gender+"\t"+s_age+"\t"+s_hp+"\t"+gaipday);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt,conn);
		}
	}
	
	public void delete() {
		Scanner sc = new Scanner(System.in);
	    String s_no;
	    String sql ="";
	    
	    System.out.println("삭제할 시퀀스를 입력하시오");
	    s_no = sc.nextLine();
	    
	    sql ="delete from stuinfo where s_no="+s_no;
	    System.out.println(sql);
	    
	    Connection conn = null;
	    Statement stmt = null;
	    
	    conn = db.getOracle();
	    
	    try {
			stmt=conn.createStatement();
			int a = stmt.executeUpdate(sql);
			
			if(a==0) {
				System.out.println("없는 데이터 시퀀스입니다");
			}else {
				System.out.println("삭제되었습니다");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
	}
	
	public boolean getOneData(String s_no) {
		boolean flag = false;
		
		String sql = "select * from stuinfo where s_no="+s_no;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = db.getOracle();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			if(rs.next()) {
				flag=true;
			}else {
				flag=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt,conn);
		}
		return flag;
	}
	
	public void update() {
		Scanner sc = new Scanner(System.in);
		String s_no,s_name,s_gender,s_hp;
		int s_age;
		
		System.out.println("수정할 시퀀스를 입력해주세요");
		s_no =sc.nextLine();
		
		System.out.println("수정할 이름으로 변경해주세요");
		s_name = sc.nextLine();
		System.out.println("수정할 성별로 변경해주세요");
		s_gender = sc.nextLine();
		System.out.println("수정할 나이로 변경해주세요");
		s_age = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 연락처로 변경해주세요");
		s_hp = sc.nextLine();
		
		String sql ="update stuinfo set s_name='"+s_name+"',s_gender='"+s_gender+"',s_age='"+s_age+"',s_hp='"+s_hp+"' where s_no="+s_no;
		System.out.println(sql);
		
		Connection conn = null;
		Statement stmt = null;
		
		conn = db.getOracle();
		
		try {
			stmt = conn.createStatement();
			
			int a = stmt.executeUpdate(sql);
			
			if(a==0) {
				System.out.println("수정할 데이터가 존재하지 않습니다");
			}else {
				System.out.println("수정되었습니다");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.dbClose(stmt, conn);
		}
		
	}
	
	public void search() {
		Scanner sc = new Scanner(System.in);
		String word;
		
		System.out.println("검색할 학생 이름을 입력하시오");
		
		word = sc.nextLine();
		
		String sql = "SELECT * FROM stuinfo where s_name like '%"+word+"%' order by s_no";
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;
		
		conn = db.getOracle();
		
		System.out.println("시퀀스\t학생명\t성별\t나이\t연락처\t\t가입날짜");
		System.out.println("---------------------------------------------------------");
		try {
			stmt= conn.createStatement();
			rs = stmt.executeQuery(sql);
			//if (!rs.next()) {
				//System.out.println("검색할 데이터가 존재하지 않습니다");
			//}else {
				//rs.beforeFirst();
			while(rs.next()) {
				
				int s_no = rs.getInt("s_no");
				String s_name = rs.getString("s_name");
				String s_gender = rs.getString("s_gender");
				String s_age = rs.getString("s_age");
				String s_hp = rs.getString("s_hp");
				Date gaipday = rs.getDate("gaipday");
				
				System.out.println(s_no+"\t"+s_name+"\t"+s_gender+"\t"+s_age+"\t"+s_hp+"\t"+gaipday);
			//}
			
			
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt,conn);
		}
	}
		
	
	public static void main(String[] args) {
		QuizStuInfo info = new QuizStuInfo();
		
		Scanner sc = new Scanner(System.in);
		int n;
		
		while(true) {
			System.out.println();
			System.out.println("\t\t[학생 정보 시스템]");
			System.out.println("1.학생정보입력 2.정보출력 3.정보삭제 4.학생정보수정 5.학생검색 9.종료");
			
			n = Integer.parseInt(sc.nextLine());
			
			if(n==1) {
				info.insert();
			}else if(n==2){
				info.select();
			}else if(n==3){
				info.delete();
			}else if(n==4){
				info.update();
			}else if(n==5){
				info.search();
			}else {
				System.out.println("종료하겠습니다");
				break;
			}
		}
		

	}

}
