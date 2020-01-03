package model;
import java.sql.*;

import db.DBHelper;
import vo.Employee;
public class LoginDao {
	// 사원이 로그인 확인 메서드 시작
	   public String login(Employee employee) {
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   ResultSet rs = null;
		   String sessionEmpNo = null;
		   
		   System.out.println(employee.getEmpNo());
		   
		   String sql = "select emp_no from employees where emp_no = ? and first_name = ? and last_name = ?";
		   try {
			   conn = DBHelper.getConnection();
			   stmt = conn.prepareStatement(sql);
			   stmt.setInt(1, employee.getEmpNo());
			   stmt.setString(2, employee.getFirstName());
			   stmt.setString(3, employee.getLastName());
			   rs = stmt.executeQuery();
			   if(rs.next()) {
				   sessionEmpNo = rs.getString("emp_no");
			   }
		   } catch(Exception e) {
			   e.printStackTrace();
		   } finally {
			   DBHelper.close(rs, stmt, conn);
		   }
		   return sessionEmpNo;
	   }
	// 사원이 로그인 확인 메서드 끝
}
