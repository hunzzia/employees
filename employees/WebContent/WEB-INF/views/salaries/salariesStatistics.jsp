<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="jumbotron">
	<div class="container">
	  	<h1><i><p>employees 샘플 데이터베이스를 사용하여 구현한 웹 프로젝트의 메인 페이지입니다.</p></i></h1>
	  	<br>
	  	<h2>테이블 정보</h2>
	<!-- WEB APP 네비게이션 -->
		<br>
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
	</div>
	
</div>
	<h1 style="text-align: center;">연봉 통계값</h1>
	<br>
	<table class="container table table-hover">
		<thead>
			<tr>
				<th>연봉 지급 수</th>
				<th>연봉 지급 합</th>
				<th>연봉 평균</th>
				<th>연봉 최고</th>
				<th>연봉 최저</th>
				<th>표준 편차</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${map.count}</td>
				<td>${map.sum}</td>
				<td>${map.avg}</td>
				<td>${map.max}</td>
				<td>${map.min}</td>
				<td>${map.std}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>