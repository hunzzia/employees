package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TitlesDao;

//1. 웹서블릿 경로 설정
@WebServlet("/titles/getTitlesListDistinct")
public class GetTitlesListDistinctServlet extends HttpServlet {
//2. 타이틀dao 선언
	TitlesDao titlesDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션을 받음
		HttpSession session = request.getSession();

		// 처음 접속이거나, 로그인을 안했을 경우
		if (session.getAttribute("sessionEmpNo") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		// 3. 타이틀 dao 객체 생성
		titlesDao = new TitlesDao();
//4. 받아올값을 저장할 List 배열 생성 후 값저장
		List<String> list = titlesDao.selectTitlesListDistinct();
//5. 받아온 값을 저장한 배열을 request 에 저장
		request.setAttribute("list", list);
//6. list 를 저장한 request 를 포워드 형식으로 views 에게 전달
		request.getRequestDispatcher("/WEB-INF/views/titles/titlesListDistinct.jsp").forward(request, response);
	}
}
