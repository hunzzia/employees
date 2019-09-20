package model;
import java.sql.*;
import java.util.*;
import vo.*;
public class EmployeesDao {
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
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
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
				rs.close();
				stmt.close();
				conn.close();
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
	public int selectEmployeesCount() {
		int count =0;
		final String sql = "SELECT COUNT(*) FROM employees"; // 쿼리가 변하면 안됨 final 로 고정
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");// 드라이버 이름 적음
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) { // 이터레이터 구현 되어있는 객채 타입 다음 다음 방식으로 찾을수 있음
				count = rs.getInt("COUNT(*)");
			}
		}catch(Exception e) {	// 자바의 변수 생명주기는 {} 안에서만 {} 앞에 만들어진 ()안의 내용또한 포함 
			
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch (Exception e) {	// 따라서 위의 catch 와 {} 가 다름으로 아무 이상없음
				e.printStackTrace();
			}
		}
		return count;
	}
	// 총 사원수를 출력하는 메서드 끝
	
}