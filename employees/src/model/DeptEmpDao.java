package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import vo.Department;
import vo.DeptEmp;

public class DeptEmpDao {
	public int selectDeptEmpRowCount() {
		// 1.변수설정
		int count = 0;
		final String sql = "SELECT COUNT(*) FROM dept_emp"; // 쿼리가 변하면 안됨 final 로 고정
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) { // 이터레이터 구현 되어있는 객채 타입 다음 다음 방식으로 찾을수 있음
				count = rs.getInt("COUNT(*)");
			}
		} catch (Exception e) { // 자바의 변수 생명주기는 {} 안에서만 {} 앞에 만들어진 ()안의 내용또한 포함

		} finally {
			try {
				DBHelper.close(rs, stmt, conn);
			} catch (Exception e) { // 따라서 위의 catch 와 {} 가 다름으로 아무 이상없음
				e.printStackTrace();
			}
		}
		return count;
	}

	// deptEmp 부서별 인원수
	public List<DeptEmp> selectDeptEmp() {
		System.out.println("selectDeptEmp 실행 ");
		List<DeptEmp> list = new ArrayList<DeptEmp>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT d.dept_name, COUNT(de.emp_no) as count FROM dept_emp de INNER JOIN departments d ON d.dept_no = de.dept_no GROUP BY d.dept_no";
		// "SELECT dept_no, COUNT(emp_no) as count FROM dept_emp GROUP BY dept_no";

		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			System.out.println("rs" + rs);

			while (rs.next()) {
				DeptEmp deptEmp = new DeptEmp();
				deptEmp.setDepartment(new Department());
				// deptEmp.setDeptNo(rs.getString("dept_no"));
				deptEmp.getDepartment().setDeptName(rs.getString("d.dept_name"));
				deptEmp.setCount(rs.getInt("count"));
				list.add(deptEmp);
			}
			System.out.println("deptEmp list" + list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}
}
