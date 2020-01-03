package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmployeesDao;
import vo.Employee;
import java.util.*;

//1.WebServlet경로 설정
@WebServlet("/employees/getEmployeesListOrderBy")
public class GetEmployeesListOrderByServlet extends HttpServlet {
//2.사용할 클레스 타입의 객체 선언 => 캡슐화
	private EmployeesDao employeesDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션을 받음
		HttpSession session = request.getSession();

		// 처음 접속이거나, 로그인을 안했을 경우
		if (session.getAttribute("sessionEmpNo") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		// 3. 스트링 타입의 order 생성후 param 값 받아온뒤 확인
		String order = request.getParameter("order");
		System.out.println("GetEmployeesListOrderByServlet param order :" + order);
//4. 사용할 클레스 타입의 객체 생성
		employeesDao = new EmployeesDao();
		List<Employee> list = null;
//5. 값을 받을 필드 생성 후 저장
		if (order != null) { // order 이 들어왔는지 검사
			list = employeesDao.selectEmployeesListOrderby(order);
		}
//6. 리퀘스트에 값을 지정
		request.setAttribute("list", list);
//7. 지정한 값을 서버체계 url 에 포워드 방식으로 request response views 에게 전달할 코드
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListOrderBy.jsp").forward(request, response);
	}

}
