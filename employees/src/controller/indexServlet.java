package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.*;
import vo.Chart;


//1.WebServlet경로 설정
@WebServlet({"/","/index"})
//URL , CONTROLLER 확인
public class indexServlet extends HttpServlet {
//2.사용할 클레스 타입의 객체 선언 => 캡슐화
	private EmployeesDao employeesDao;
	private DepartmentsDao departmentsDao;
	private DeptManagerDao deptManagerDao;
	private DeptEmpDao deptEmpDao;
	private SalariesDao salariesDao;
	private TitlesDao titlesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8"); // gson 사용 선언
		System.out.println("index URL 요청");
		
		// 세션을 받음
		HttpSession session = request.getSession();
		// 처음 접속이거나, 로그인을 안했을 경우
		if (session.getAttribute("sessionEmpNo") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
//3.사용할 클레스 타입의 객체 생성 , 4.값을 받을 필드 생성 후 저장
		departmentsDao = new DepartmentsDao();
		int departmentsRowCount = departmentsDao.selectDepartmentsRowCount();
		employeesDao = new EmployeesDao();
		int maxEmpNo = employeesDao.selectEmpNo("max");
		int minEmpNo = employeesDao.selectEmpNo("min");
		// count 는 view 로 필요함으로 request 안에 포함시켜 넘긴다 => views 에 넘길수 있는건 request response 두개 밖에 없다
		int employeesRowCount = employeesDao.selectEmployeesRowCount();
		
		deptManagerDao = new DeptManagerDao();
		int deptManagerRowCount =deptManagerDao.selectDeptManagerRowCount();
		
		deptEmpDao = new DeptEmpDao();
		int deptEmpRowCount = deptEmpDao.selectDeptEmpRowCount();
		
		salariesDao = new SalariesDao();
		int salariesRowCount = salariesDao.selectSalariesRowCount();
		
		titlesDao = new TitlesDao();
		int titlesRowCount = titlesDao.selectTitlesRowCount();
//5.리퀘스트에 값을 지정
		request.setAttribute("departmentsRowCount", departmentsRowCount);
		request.setAttribute("employeesRowCount", employeesRowCount);
		request.setAttribute("deptManagerRowCount", deptManagerRowCount);
		request.setAttribute("deptEmpRowCount", deptEmpRowCount);
		request.setAttribute("salariesRowCount", salariesRowCount);
		request.setAttribute("titlesRowCount", titlesRowCount);
		request.setAttribute("maxEmpNo", maxEmpNo);
		request.setAttribute("minEmpNo", minEmpNo);

//6.지정한 값을 서버체계 url 에 포워드 방식으로 request response views 에게 전달할 코드
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}
}
