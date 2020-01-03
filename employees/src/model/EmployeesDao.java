package model;
import java.sql.*;
import java.util.*;

import db.DBHelper;
import vo.*;
public class EmployeesDao {
	// 사원정보를 페이징 작업을 통해 출력하는 메서드 시작
	public List<Employee> selectEmployeesListByPage(int rowPerPage , int currentPage){ // 보고싶은 갯수와 현제 페이지를 매개변수로 받아옴
		System.out.println("selectEmployeesListByPage param rowPerPage , currentPage :"+rowPerPage+","+currentPage);
		
		int startRow = (currentPage-1)*rowPerPage; // 시작갯수를 정한다 9
		
		System.out.println("EmpDao startRow :"+startRow);
		
		List<Employee> list = new ArrayList<Employee>();
		
		Connection conn = null;
		
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		String sql ="SELECT * FROM employees limit ?,?"; // 행과 열을 지정한다
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, startRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setEmpNo(rs.getInt("emp_no"));
				employee.setBirthDate(rs.getString("birth_date"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setGender(rs.getString("gender"));
				employee.setHireDate(rs.getString("hire_date"));
				list.add(employee);
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
		System.out.println("DAO list"+list.toString());
		return list;
	}
	// 사원정보를 페이징 작업을 통해 출력하는 메서드 끝
	
	// 페이징 작업에 필요한 마지막페이지를 구하는 메서드 시작
	public int selectLastPage( int totalRow ,int rowPerPage ) { // 총갯수와 보고싶은 갯수를 매개변수로 받아온다.
		System.out.println("selectLastPage param rowPerPage:"+ rowPerPage);
		int lastPage = 0;
		if(totalRow % rowPerPage ==0) {
			lastPage = rowPerPage /  rowPerPage;
		}else {
			lastPage = totalRow / rowPerPage +1;
		}
		return lastPage;
	}
	// 페이징 작업에 필요한 마지막페이지를 구하는 메서드 끝
	
	// 받아온 범위안 사원 정보를 오름차순으로 출력하는 메서드 시작
	public List<Employee> selectEmployeesListBetween(int begin , int end){
		List<Employee> list = new ArrayList<Employee>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT emp_no , birth_date , first_name , last_name , gender , hire_date FROM employees WHERE emp_no BETWEEN ? AND ? ORDER BY emp_no ASC";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, begin);
			stmt.setInt(2, end);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setEmpNo(rs.getInt("emp_no"));
				employee.setBirthDate(rs.getString("birth_date"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setGender(rs.getString("gender"));
				employee.setHireDate(rs.getString("hire_date"));
				list.add(employee);
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
	// 받아온 범위안 사원 정보를 오름차순으로 출력하는 메서드 끝
	
	// 가장 큰 사원번호 와 가장 작은 사원번호를 출력하는 메서드 시작
	public int selectEmpNo(String str) {
		int empNo =0;
		String sql = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		if(str.equals("max")){
			sql ="select max(emp_no) from employees";
		}else if (str.equals("min")){
			sql ="select min(emp_no) from employees";
		}
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				empNo = rs.getInt(1);
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
		return empNo;
	}
	// 가장 큰 사원번호 와 가장 작은 사원번호를 출력하는 메서드 시작
	
	// 성별 별 사원수 검색 메서드 시작
	public List<Map<String , Object>> selectEmployeesCountGroupByGender(){
		List<Map<String , Object>> list = new ArrayList<Map<String , Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT gender , COUNT(gender) cnt FROM employees GROUP BY gender";
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String , Object> map = new HashMap<String, Object>();
				map.put("gender", rs.getString("gender"));
				map.put("cnt", rs.getInt("cnt"));
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
	// 성별 별 사원수 검색 메서드 끝

	// first_name 오름차순 내림차순 별 사원 정보 출력 시작 
	public List<Employee> selectEmployeesListOrderby(String order){
		System.out.println("selectEmployeesListOrderby param limit : "+order);
		//동적 쿼리
		List<Employee> list = new ArrayList<Employee>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="";
		if(order.equals("asc")) {//오름차순
			sql = "select*from employees order by first_name asc limit 50";
		}else if(order.equals("desc")){//내림차순
			sql = "select*from employees order by first_name desc limit 50";
		}
		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setEmpNo(rs.getInt("emp_no"));
				employee.setBirthDate(rs.getString("birth_date"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setGender(rs.getString("gender"));
				employee.setHireDate(rs.getString("hire_date"));
				list.add(employee);
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
	// first_name 오름차순 내림차순 별 사원 정보 출력 시끝
	
	// limit 별로 사원 정보를 출력하는 메서드 시작
	public List<Employee> selectEmployeesListByLimit(int limit){
		System.out.println("selectEmployeesListByLimit param limit :"+ limit);
		// 1. 받아올 클레스 타입 변수 선언
		List<Employee> list = new ArrayList<Employee>();
		Connection conn =null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// 2. sql 설정 => select from employees 단 limit 제한 할것  => limit ?
		String sql ="SELECT emp_no , birth_date , first_name , last_name , gender , hire_date FROM employees LIMIT ?";
		// 3. try catch  설정후 각 변수에 마리아 db 설정 후  list 에 저장 finally 에 
		// 		try catch 설정후 모든 객체 종료
		try {
		// 3.1 생성한 변수에 각각 마리아 db 연결 코드와 셋팅 업데이트 코드 저장
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, limit);
			rs = stmt.executeQuery();
		//  employee  겟으로 불러온후 셋팅  그 값들을 리스트에 추가
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setEmpNo(rs.getInt("emp_no"));
				employee.setBirthDate(rs.getString("birth_date"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setGender(rs.getString("gender"));
				employee.setHireDate(rs.getString("hire_date"));
				list.add(employee);
			}
		}catch(Exception e) {
		// 3.2 예외가 나면 출력할수 있는 코드
			e.printStackTrace();
		}finally {
		// 3.3 모든 객체 종료
			try {
				DBHelper.close(rs, stmt, conn);
			}catch(Exception e) {
		// 3.4 객체 종료시 예외 발생하면 출력 코드 
				e.printStackTrace();
			}
		}
		// 4. employees 정보를 저장한  list 리턴 
		return list;
		
	}
	// limit 별로 사원 정보를 출력하는 메서드 끝
	
	// 총 사원수를 출력하는 메서드 시작
	public int selectEmployeesRowCount() {
		int count =0;
		final String sql = "SELECT COUNT(*) FROM employees"; // 쿼리가 변하면 안됨 final 로 고정
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
	// 총 사원수를 출력하는 메서드 끝
	
}
