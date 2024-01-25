package Day0125;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuizJdbcFoodOrder {
static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

public void foodOrder(){
	Connection conn = null;
	Statement stmt  = null;
	ResultSet rs = null;
	
	String sql ="select j.order_num , f.fno, j.order_name,f.foodname, f.price ,f.fshopname, f.shoploc, j.order_addr from foodshop f, jumun j where f.fno = j.fno";
	
	try {
		conn = DriverManager.getConnection(URL, "stu", "a1234");
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int num =rs.getInt("num");
			int fno =rs.getInt("fno");
			String ordername = rs.getString("ordername");
			String foodname = rs.getString("foodname");
			int price = rs.getInt("price");
			String fshopname = rs.getString("fshopname");
			String shoploc = rs.getString("shoploc");
			String order_addr = rs.getString("order_addr");
			
			System.out.println(num+"\t"+fno+"\t"+ordername+"\t"+foodname+"\t"+price+"\t"+fshopname+"\t"+shoploc+"\t"+order_addr);
		}
		System.out.println("오라클 드라이버 연결 성공!!");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("오라클 드라이버 연결 실패!!");
	}finally {
		 // 자원 해제
			try {
				if(rs!= null) {
				rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
}

public static void main(String[] args) {
	QuizJdbcFoodOrder ct = new QuizJdbcFoodOrder();
	ct.foodOrder();
}
}
