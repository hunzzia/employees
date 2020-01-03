package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.DeptEmpDao;
import vo.DeptEmp;

/**
 * Servlet implementation class GetDepartmentEmpServlet
 */
@WebServlet("/deptEmp/GetDepartmentEmpServlet")
public class GetDepartmentEmpServlet extends HttpServlet {
	private DeptEmpDao deptEmpDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetDepartmentEmpServlet 실행");
		
		deptEmpDao = new DeptEmpDao();
		
		List<DeptEmp> list = deptEmpDao.selectDeptEmp();
		System.out.println("list"+list);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(list);
		System.out.println(jsonStr);
		
		response.getWriter().write(jsonStr);
		
		
		
	}

}
