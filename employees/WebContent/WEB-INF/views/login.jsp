<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
div {
	text-align: center;
	vertical-align: middle;
}
</style>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>
				<i><p>employees 샘플 데이터베이스를 사용하여 구현한 웹 프로젝트 페이지입니다.</p></i>
			</h1>
			<br>
			<h2>테이블 정보</h2>
			<!-- WEB APP 네비게이션 -->
			<br>
			<ul class="nav">
				<li class="nav-item"><a class="nav-link href="#">기능 목록</a></li>
				<li class="nav-item"><a class="text-primary nav-link"
					href="${pageContext.request.contextPath}/departments/getDepartmentsList">부서목록</a></li>
				<li class="nav-item"><a class="text-primary nav-link"
					href="${pageContext.request.contextPath}/employees/getEmployeesList">사원목록</a></li>
				<!-- < % =request.getContextPath()%> 프로잭트 이름을 리턴 -->
				<li class="nav-item"><a class="text-success nav-link"
					href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc">사원
						목록[오름차순]</a> <a class="text-success nav-link"
					href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc">사원
						목록[내림차순]</a></li>
				<li class="nav-item"><a class="text-primary nav-link"
					href="${pageContext.request.contextPath}/titles/getTitlesListDistinct">업무
						목록</a></li>
				<li class="nav-item"><a class="text-primary nav-link"
					href="${pageContext.request.contextPath}/salaries/getSalariesStatistics">연봉
						통계</a></li>
				<li class="nav-item"><a class="text-primary nav-link"
					href="${pageContext.request.contextPath}/employees/getEmployeesCountByGender">성별
						별 사원 수</a></li>
				<li class="nav-item"><a class="text-primary nav-link"
					href="${pageContext.request.contextPath}/departments/getDepartmentsCountByDeptNo">현재
						부서별 사원수</a></li>
				<li class="nav-item"><a class="text-primary nav-link"
					href="${pageContext.request.contextPath}/employees/getEmployeesListByPage">페이지별
						사원목록</a></li>
				<!-- < % =request.getContextPath()%> 프로잭트 이름을 리턴 -->
			</ul>
		</div>
	</div>
	<div class="container">
		<h1>로그인</h1>
		<form method="post" action="${pageContext.request.contextPath}/login">
			<div>
				first_name : <input type="text" name="firstName" value="Georgi">
			</div>
			<div>
				last_name : <input type="text" name="lastName" value="Facello">
			</div>
			<div>
				emp_no : <input type="text" name="empNo" value="10001">
			</div>
			<div>
				<button type="submit">로그인</button>
			</div>
		</form>
	</div>
</body>
</html>




