package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;
import vo.Employee;
//1.웹서블릿 경로 설정
@WebServlet("/employees/getEmployeesListByPage")
public class GetEmployeesListByPageServlet extends HttpServlet {
//2.사용할 객체 선언
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//3.사용할 변수 생성 후 받아온 값을 저장
		employeesDao = new EmployeesDao();
		int rowPerPage =0 ;
		if (request.getParameter("rowPerPage") != null ) {
			 rowPerPage = Integer.parseInt(request.getParameter("rowPerPage")); // 볼 갯수
		} else{
			 rowPerPage = 10; // 보고싶은 갯수를 기본 설정을 10으로 맞춤
		}
		
		int currentPage =1;	 // 현재 페이지 1로 설정
		if(request.getParameter("currentPage") !=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		List<Employee> list =employeesDao.selectEmployeesListByPage(currentPage, rowPerPage);
		int totalRow = employeesDao.selectEmployeesRowCount();
		int lastPage = employeesDao.selectLastPage(totalRow , rowPerPage);
		
		System.out.println("GetEmployeesListByPage param currentPage :"+ currentPage);
		System.out.println("GetEmployeesListByPage param rowPerPage :"+ rowPerPage);
		
//4. 받아올 값을 저장한 변수를 리퀘스트에 저장한뒤 포워드 방식으로 views 에게 보낸다		
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("rowPerPage", rowPerPage);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListByPage.jsp").forward(request, response);
		
	}

}
