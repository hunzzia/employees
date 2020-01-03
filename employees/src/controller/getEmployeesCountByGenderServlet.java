package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmployeesDao;

@WebServlet("/employees/getEmployeesCountByGender")
public class getEmployeesCountByGenderServlet extends HttpServlet {
	EmployeesDao employeesDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션을 받음
		HttpSession session = request.getSession();

		// 처음 접속이거나, 로그인을 안했을 경우
		if (session.getAttribute("sessionEmpNo") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		employeesDao = new EmployeesDao();
		List<Map<String, Object>> list = employeesDao.selectEmployeesCountGroupByGender();
		System.out.println("getEmployeesCountByGender param list :" + list);

		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesCountByGender.jsp").forward(request, response);
	}

}
