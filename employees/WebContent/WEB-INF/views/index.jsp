<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- Bootstrap icons -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<!-- charSet -->
<meta charset="UTF-8">
<title>Index - HOME</title>
</head>
<body>
<div class="jumbotron">
	<div class="container">
	  	<h1><i ><p>employees 샘플 데이터베이스를 사용하여 구현한 웹 프로젝트의 메인 페이지입니다.</p></i></h1>
	</div>
</div>

<div class="container">
	<h2>테이블 정보</h2>
	<!-- WEB APP 네비게이션 -->
		<ul class="nav">
			<li class="nav-item">
    			<a class="nav-link href="#">기능 목록</a>
  			</li>
			<li class="nav-item"><a class="text-primary nav-link" href="${pageContext.request.contextPath}/departments/getDepartmentsList">부서목록</a></li>
			<li class="nav-item"><a class="text-primary nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesList">사원목록</a></li>	
			<!-- < % =request.getContextPath()%> 프로잭트 이름을 리턴 -->
			<li class="nav-item">
				<a class="text-success nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc">사원 목록[오름차순]</a>
				<a class="text-success nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc">사원 목록[내림차순]</a>
			</li>
			<li class="nav-item"><a class="text-primary nav-link" href="${pageContext.request.contextPath}/titles/getTitlesListDistinct">업무 목록</a></li>
			<li class="nav-item"><a class="text-primary nav-link" href="${pageContext.request.contextPath}/salaries/getSalariesStatistics">연봉 통계</a></li>
			<li class="nav-item">
				<a class="text-primary nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesCountByGender">성별 별 사원 수</a>
			</li>
			<li class="nav-item">
				<a class="text-primary nav-link" href="${pageContext.request.contextPath}/departments/getDepartmentsCountByDeptNo">현재 부서별 사원수</a>
			</li>
			<li class="nav-item">
				<a class="text-primary nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesListByPage">페이지별 사원목록</a>
			</li>
			<!-- < % =request.getContextPath()%> 프로잭트 이름을 리턴 -->
		</ul>	
	<hr>
	<!-- 테이블 이름과 전체 행의 수 -->
	<div>
		<b>표현식 --></b> employees total row count: 300025<br>
		<b>EL표현식 --></b> employee table row count : 300025;
	</div>
	<div class="d-flex">
		<form method="post" action ="${pageContext.request.contextPath}/employees/getEmployeesListBetween">
			<input type="number" class="form-control" name="begin" value="${minEmpNo}">~<input type="number" class="form-control" name="end" value="${maxEmpNo}">
			<button type="submit" class="btn btn-primary">사원 목록 검색</button>
		</form>
	</div>

		<table table class="table table-bordered table-hover"  style="text-align:center;">
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
</div>	<!-- < % =request.getContextPath()%> 프로잭트 이름을 리턴 -->	
</body>
</html>