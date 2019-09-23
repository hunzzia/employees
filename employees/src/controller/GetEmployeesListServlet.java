package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;
import vo.Employee;
// 1.WebServlet경로 설정
@WebServlet("/employees/getEmployeesList")
public class GetEmployeesListServlet extends HttpServlet {
//2.사용할 클레스 타입의 객체 선언 => 캡슐화
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//3.limit 처리 밑 request limit 값 확인 
		int limit = 10;
		if(request.getParameter("limit") != null) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}
//4.사용할 클레스 타입의 객체 생성 employeesDao , List
		employeesDao = new EmployeesDao();
		List<Employee> list = null;
//5.값을 받을 필드 생성 후 저장
		list = employeesDao.selectEmployeesListByLimit(limit);
//6.리퀘스트에 값을 지정
		request.setAttribute("list", list);
//7.지정한 값을 서버체계 url 에 포워드 방식으로 request response views 에게 전달할 코드
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesList.jsp").forward(request, response);
	}
}
