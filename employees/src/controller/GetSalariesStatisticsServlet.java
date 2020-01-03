package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SalariesDao;

@WebServlet("/salaries/getSalariesStatistics")
public class GetSalariesStatisticsServlet extends HttpServlet {
	SalariesDao salariesDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션을 받음
		HttpSession session = request.getSession();

		// 처음 접속이거나, 로그인을 안했을 경우
		if (session.getAttribute("sessionEmpNo") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		salariesDao = new SalariesDao();
		Map<String, Long> map = new HashMap<String, Long>();
		map = salariesDao.selectSalariesStatistics();
		System.out.println("GetSalariesStatisticsServlet param map :" + map);

		request.setAttribute("map", map);
		request.getRequestDispatcher("/WEB-INF/views/salaries/salariesStatistics.jsp").forward(request, response);
	}

}