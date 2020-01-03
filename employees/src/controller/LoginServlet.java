package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginDao;
import vo.Employee;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	LoginDao loginDao;
	// LOGIN FORM 메서드
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
		
		// LOGIN ACTION 메서드
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 입력한 firstName, lastName, empNo 3개를 받음
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			int empNo = Integer.parseInt(request.getParameter("empNo"));
			
			System.out.println("로그인시 받은 입력 값 : " + firstName + " " + lastName + "사원 번호 : " + empNo);
			
			// doGet메서드랑은 다른 메서드기 때문에 doPost메서드 안에서 Employees클래스를 생성함
			Employee employees = new Employee();
			employees.setEmpNo(empNo);
			employees.setFirstName(firstName);
			employees.setLastName(lastName);
			
			loginDao = new LoginDao();	
			String sessionEmpNo = loginDao.login(employees);
			System.out.println(sessionEmpNo);
			HttpSession session = request.getSession();
			session.setAttribute("sessionEmpNo", sessionEmpNo);
			
			if(sessionEmpNo == null) {
				response.sendRedirect(request.getContextPath() + "/login");
				return;
			} else {
				response.sendRedirect(request.getContextPath() + "/");
			}
		}

}
