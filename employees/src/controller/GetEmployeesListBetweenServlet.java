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

@WebServlet("/employees/getEmployeesListBetween")
public class GetEmployeesListBetweenServlet extends HttpServlet {
	private EmployeesDao employeesDao;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션을 받음
		HttpSession session = request.getSession();

		// 처음 접속이거나, 로그인을 안했을 경우
		if (session.getAttribute("sessionEmpNo") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		int begin = Integer.parseInt(request.getParameter("begin"));
		int end = Integer.parseInt(request.getParameter("end"));
		employeesDao = new EmployeesDao();
		List<Employee> list = employeesDao.selectEmployeesListBetween(begin, end);

		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListBetween.jsp").forward(request, response);
	}

}
