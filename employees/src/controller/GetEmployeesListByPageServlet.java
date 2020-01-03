package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmployeesDao;
import vo.Employee;

//1.웹서블릿 경로 설정
@WebServlet("/employees/getEmployeesListByPage")
public class GetEmployeesListByPageServlet extends HttpServlet {
//2.사용할 객체 선언
	private EmployeesDao employeesDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// 세션을 받음
		HttpSession session = request.getSession();

		// 처음 접속이거나, 로그인을 안했을 경우
		if (session.getAttribute("sessionEmpNo") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		System.out.println("GetEmployeesListByPageServlet 요청");
		// 3.사용할 변수 생성 후 받아온 값을 저장
		employeesDao = new EmployeesDao();
		int rowPerPage = 10;
		if (request.getParameter("rowPerPage") != null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage")); // 볼 갯수
			System.out.println("GetEmployeesListByPageServlet param rowPerPage :"+rowPerPage);
		} else {
			rowPerPage = 10; // 보고싶은 갯수를 기본 설정을 10으로 맞춤
		}

		int currentPage = 1; // 현재 페이지 1로 설정
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			System.out.println("GetEmployeesListByPageServlet param currentPage :"+currentPage);
		}
		List<Employee> list = employeesDao.selectEmployeesListByPage(currentPage, rowPerPage);
		System.out.println("GetEmployeesListByPageServlet param list :"+list);
		int totalRow = employeesDao.selectEmployeesRowCount();
		System.out.println("GetEmployeesListByPageServlet param totalRow :"+totalRow);
		int lastPage = employeesDao.selectLastPage(totalRow, rowPerPage);
		System.out.println("GetEmployeesListByPageServlet param lastPage :"+lastPage);


//4. 받아올 값을 저장한 변수를 리퀘스트에 저장한뒤 포워드 방식으로 views 에게 보낸다		
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("rowPerPage", rowPerPage);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListByPage.jsp").forward(request, response);

	}

}
