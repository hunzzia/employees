package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;


@WebServlet({"/","/index"})
//URL , CONTROLLER 확인
public class indexServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("index URL 요청");
		
		this.employeesDao = new EmployeesDao();
		int employeesRowCount = employeesDao.selectEmployeesCount();// 모델에서 데이터를 가져온다
		// /WEB-INF/views/index.jsp
		//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		//rd.forword(request , response);
		//인덱스를 요청하면 컨트롤러가 index.jsp 를 요청해준다
		
		request.setAttribute("employeesRowCount", employeesRowCount);// 오토 박싱 레퍼 타입이 자동으로 쓰임 원래는 Integer 타입으로 써야됨 자동으로 변환된다
		
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}
}
