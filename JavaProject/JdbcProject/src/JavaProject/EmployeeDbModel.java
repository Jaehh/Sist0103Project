package JavaProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import oracleDb.DbConnect;

public class EmployeeDbModel {
    DbConnect db = new DbConnect();
    Vector<EmployeeDto> list;

    // 사원 추가
    public void insertEmployee(EmployeeDto dto) {
        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;

        String sql = "insert into employee values(seq_emp.nextval, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getPhoto());
            pstmt.setString(3, dto.getGender());
            pstmt.setString(4, dto.getDept());
            pstmt.setString(5, dto.getPosition());
            pstmt.setString(6, dto.getAddr());
            pstmt.setInt(7, dto.getPay());
            pstmt.setString(8, dto.getEmail());

            pstmt.execute();	
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(pstmt, conn);
        }
    }

    // 사원 조회
    public Vector<EmployeeDto> getAllEmployees(){
        Vector<EmployeeDto> list = new Vector<EmployeeDto>();

        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from employee order by num";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                EmployeeDto dto = new EmployeeDto();

                dto.setNum(rs.getString("num"));
                dto.setName(rs.getString("name"));
                dto.setPhoto(rs.getString("photo"));
                dto.setGender(rs.getString("gender"));
                dto.setDept(rs.getString("dept"));
                dto.setPosition(rs.getString("position"));
                dto.setAddr(rs.getString("addr"));
                dto.setPay(rs.getInt("pay"));
                dto.setEmail(rs.getString("email"));
                dto.setIpsaday(rs.getDate("ipsaday"));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }		
        return list;
    }
    
    // 사원 삭제
    public void deleteEmployee(String num) {
        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;
        
        String sql = "delete from employee where num = ?";
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(pstmt, conn);
        }
    }
    
    // 사원 수정
    public void updateEmployee(String num, EmployeeDto dto) {

		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		try {
	        conn = db.getOracle();
	        String sql = "UPDATE employee SET name=?, gender=?, dept=?, position=?, addr=?, pay=?, email=? WHERE num=?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, dto.getName());
	        //pstmt.setString(2, dto.getPhoto());
	        pstmt.setString(2, dto.getGender());
	        pstmt.setString(3, dto.getDept());
	        pstmt.setString(4, dto.getPosition());
	        pstmt.setString(5, dto.getAddr());
	        pstmt.setInt(6, dto.getPay());
	        pstmt.setString(7, dto.getEmail());
	        pstmt.setString(8, num); // WHERE 조건에 해당하는 직원 번호 설정
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.dbClose(pstmt, conn);
	    }
		
		
    }

    public EmployeeDto getEmployeeByNum(String num) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        EmployeeDto employee = null;

        try {
            conn = db.getOracle();
            String sql = "SELECT * FROM employee WHERE num = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                employee = new EmployeeDto();
                employee.setNum(rs.getString("num"));
                employee.setName(rs.getString("name"));
                employee.setPhoto(rs.getString("photo"));
                employee.setGender(rs.getString("gender"));
                employee.setDept(rs.getString("dept"));
                employee.setPosition(rs.getString("position"));
                employee.setAddr(rs.getString("addr"));
                employee.setPay(rs.getInt("pay"));
                employee.setEmail(rs.getString("email"));
                employee.setIpsaday(rs.getDate("ipsaday"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }

        return employee;
    }

    
    
}