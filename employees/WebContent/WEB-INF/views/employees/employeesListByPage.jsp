<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
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
<!-- Bootstrap icons -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<div class = "container">
	<div style = float:right><button class = "btn btn-success" onclick= "location.href ='${pageContext.request.contextPath}/index'">메인화면</button></div>
	<form method = "get" action = "${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage}">
		<select name = "rowPerPage">
		<!-- 페이지당 보여줄 갯수 선택 -->
		<c:forEach var="i" begin = "10" end = "150" step = "10">
		<!-- 변수, 시작값, 끝값, 반복할크기 -->
			<option value = "${i}">${i}</option>
		</c:forEach>
		</select>개씩 보기
		<button type = "submit" class = "btn btn-info">확인!</button>
	</form>
	
	<table class = "table table-hover" style = "text-align : center">
		<thead>
			<tr>
				<th>사원 번호</th>
				<th>사원 생일</th>
				<th>사원 이름</th>
				<th>사원  이름(성)</th>
				<th>성별</th>
				<th>입사날짜 / 퇴사 날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var = "employees" items = "${list}">
				<tr>
					<td>${employees.empNo}</td>
					<td>${employees.birthDate}</td>
					<td>${employees.firstName}</td>
					<td>${employees.lastName}</td>
					<td>${employees.gender}</td>
					<td>${employees.hireDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 이전, 다음 페이지 설정 -->
	<br>
	<div class ="container">
		 <a href = "${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=1&rowPerPage=${rowPerPage}">첫 페이지로</a>
	<c:if test = "${currentPage > 1}"> <!-- ==if(currentPage > 1) -->
		<a href = "${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}">이전</a>
	</c:if>
	
	
		
	<c:forEach var= "i" begin = "${currentPage}" end ="${currentPage + 6}" step="1">
		<!-- 현재 페이지 앞에 출력될 숫자 -->
		<c:if test="${currentPage > 3}">
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${i-3}&rowPerPage=${rowPerPage}">${i-3}</a>
		</c:if>
	</c:forEach>
	<c:forEach var= "i" begin = "1" end ="7" step="1">
		<!-- 현재 페이지 뒤에 출력될 숫자 -->
		<c:if test="${currentPage <= 3}">
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${i}&rowPerPage=${rowPerPage}">${i}</a>
		</c:if>
	</c:forEach>

	<!-- 마지막 페이지설정 -->
	<c:if test= "${currentPage < lastPage }">
		<a href = "${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}">다음</a>
	</c:if>
	
	</div>
	</div>
</body>
</html>