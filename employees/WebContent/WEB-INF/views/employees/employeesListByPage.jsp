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
<h1>회원 목록(10명식 페이징)</h1>
<h3>(SELECT * FROM employees limit ?,?)쿼리문 의 결과</h3>
<!-- 홈버튼 -->
	<div>
		<a href="${pageContext.request.contextPath}/">홈으로</a>
	</div>
<!-- 보고싶은 갯수를 선택하는 버튼 -->
	<form method ="get" action="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage">
		<select name ="rowPerPage">
			<option value="10">10</option>
			<option value="30">30</option>
			<option value="50">50</option>
			<option value="70">70</option>
			<option value="100">100</option>
		</select>
		<button type="submit">선택</button>
<!-- 사원정보를 출력하는 테이블 -->
	<table>
		<thead>
			<tr>
				<th>사원 번호</th>
				<th>사원 생일</th>
				<th>사원 성</th>
				<th>사원 이름</th>
				<th>사원 성별</th>
				<th>입사 날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employee" items="${list}">
				<tr>
					<td>${employee.empNo}</td>
					<td>${employee.birthDate}</td>
					<td>${employee.firstName}</td>
					<td>${employee.lastName}</td>
					<td>${employee.gender}</td>
					<td>${employee.hireDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</form>
<!-- 페이징 -->
	<c:if test="${currentPage > 100}">
		<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage-100}&rowPerPage=${rowPerPage}">(100)이전</a>
	</c:if>
	<c:if test="${currentPage > 1}">	<!--  if(currentPage>1) -->
		<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}">이전</a>
	</c:if>
	<c:forEach var="i" begin="${currentPage}" end="${currentPage+9}" step="1">
		<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${i}&rowPerPage=${rowPerPage}">${i}</a>
	</c:forEach>
	<c:if test="${currentPage < lastPage }">
		<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}">다음</a>
	</c:if>
	<c:if test="${currentPage < lastPage }">
		<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage+100}&rowPerPage=${rowPerPage}">(100)다음</a>
	</c:if>
</body>
</html>