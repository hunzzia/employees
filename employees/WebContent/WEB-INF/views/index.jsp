<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>index</h1>
	<h2>테이블 정보</h2>
	<div class="container">
	<!-- WEB APP 네비게이션 -->
	<div class="container">
		<ul class="nav flex-column">
			<li class="nav-item">
    			<a class="nav-link active" href="#">기능 목록</a>
  			</li>
			<li class="nav flex-column"><a href="${pageContext.request.contextPath}/departments/getDepartmentsList">부서목록</a></li>
			<li class="nav flex-column"><a href="${pageContext.request.contextPath}/employees/getEmployeesList">사원목록</a></li>	
			<!-- < % =request.getContextPath()%> 프로잭트 이름을 리턴 -->
			<li class="nav-item">
				사원 목록 ->
				<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc">[오름차순]</a>
				<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc">[내림차순]</a>
			</li>
			<li class="nav flex-column"><a href="${pageContext.request.contextPath}/titles/getTitlesListDistinct">업무 목록</a></li>
			<li class="nav flex-column"><a href="${pageContext.request.contextPath}/salaries/getSalariesStatistics">연봉 통계</a></li>
			<li class="nav flex-column">
				<a href="${pageContext.request.contextPath}/employees/getEmployeesCountByGender">성별 별 사원 수</a>
			</li>
			<li class="nav flex-column">
				<a href="${pageContext.request.contextPath}/departments/getDepartmentsCountByDeptNo">현재 부서별 사원수</a>
			</li>
			<!-- < % =request.getContextPath()%> 프로잭트 이름을 리턴 -->
		</ul>	
	</div>
	<!-- 테이블 이름과 전체 행의 수 -->
	<div class="container">
		<table class="table table-warning table-hover">
			<thead>
				<tr>
					<th>테이블이름</th>
					<th>전체 행의 수</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>departments</td>
					<td>${employeesRowCount}</td>
				</tr>
				<tr>
					<td>employees</td>
					<td>${departmentsRowCount}</td>
				</tr>
				<tr>
					<td>dept_manager</td>
					<td>${deptManagerRowCount}</td>
				</tr>
				<tr>
					<td>dept_emp</td>
					<td>${deptEmpRowCount}</td>
				</tr>
				<tr>
					<td>titles</td>
					<td>${titlesRowCount}</td>
				</tr>
				<tr>
					<td>salaries</td>
					<td>${salariesRowCount}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="container">
		<form method="post" action ="${pageContext.request.contextPath}/employees/getEmployeesListBetween">
			<input type="number" name="begin" value="${minEmpNo}">~<input type="number" name="end" value="${maxEmpNo}">
			(${minEmpNo}~${maxEmpNo})
			<button type="submit" class="btn btn-primary">사원 목록 검색</button>
		</form>
	</div>
			<!-- < % =request.getContextPath()%> 프로잭트 이름을 리턴 -->	
	</div>
</body>
</html>