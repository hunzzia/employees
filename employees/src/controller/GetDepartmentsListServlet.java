package controller;

import java.io.IOException; 
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DepartmentsDao;
import vo.Department;

// 서버가 요청한 것임으로 컨태스트 명이 필요하지 않음
//1.WebServlet경로 설정
@WebServlet("/departments/getDepartmentsList")
public class GetDepartmentsListServlet extends HttpServlet {
//2.사용할 클레스 타입의 객체 선언 => 캡슐화
	private DepartmentsDao departmentsDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//4.사용할 클레스 타입의 객체 생성 후 값을 받을 필드 생성 후 저장 
		departmentsDao = new DepartmentsDao();
		List<Department> list = departmentsDao.selectDepartmentsList();
//5.리퀘스트에 값을 지정
		request.setAttribute("list", list);
//6.지정한 값을 서버체계 url 에 포워드 방식으로 request response views 에게 전달할 코드
		request.getRequestDispatcher("/WEB-INF/views/departments/departmentsList.jsp").forward(request, response);
	}
	
}
