package model;
import java.sql.*;
import java.util.*;

import db.DBHelper;
import vo.Department;
public class DepartmentsDao {
	// 부서번호와 부서이름 그리고 그부서의 소속된 수를 나타내는 메서드 시작 
	public List<Map<String , Object>> selectDepartmentsCountByDeptNo(){
		List<Map<String , Object>> list = new ArrayList<Map<String , Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="select d.dept_no deptNo , d.dept_name deptName, count(d.dept_no) cnt "
				+ "FROM departments d INNER JOIN dept_emp de "
				+ "ON de.dept_no = d.dept_no "
				+ "where de.to_date ='9999-01-01' "
				+ "group by d.dept_no order by count(d.dept_no) desc";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String , Object> map = new HashMap<String, Object>();
				map.put("deptNo", rs.getString("deptNo"));
				map.put("deptName", rs.getString("deptName"));
				map.put("cnt", rs.getString("cnt"));
				list.add(map);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBHelper.close(rs, stmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// 부서번호와 부서이름 그리고 그부서의 소속된 수를 나타내는 메서드 끝
	
	// 부서정보를 출력하는 메서드 시작
	public List<Department> selectDepartmentsList(){
		List<Department> list = new ArrayList<Department>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT dept_no , dept_name FROM departments";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Department department = new Department();
				department.setDeptNo(rs.getString("dept_no"));
				department.setDeptName(rs.getString("dept_name"));
				list.add(department);
				}		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBHelper.close(rs, stmt, conn);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	// 부서정보를 출력하는 메서드 끝
	
	// 부서 의 총갯수를 출력하는 메서드 시작
	public int selectDepartmentsRowCount() {
		// 1.변수설정 
		int count = 0;
		final String sql = "SELECT COUNT(*) FROM departments"; // 쿼리가 변하면 안됨 final 로 고정
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) { // 이터레이터 구현 되어있는 객채 타입 다음 다음 방식으로 찾을수 있음
				count = rs.getInt("COUNT(*)");
			}
		}catch(Exception e) {	// 자바의 변수 생명주기는 {} 안에서만 {} 앞에 만들어진 ()안의 내용또한 포함 
			
		}finally{
			try {
				DBHelper.close(rs, stmt, conn);
			}catch (Exception e) {	// 따라서 위의 catch 와 {} 가 다름으로 아무 이상없음
				e.printStackTrace();
			}
		}
		return count;
	}
	// 부서 의 총갯수를 출력하는 메서드 끝
}
