<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employeesList</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>사원 정보</h1>
	<div class ="container">
	<form method ="get" action ="${pageContext.request.contextPath}/employees/getEmployeesList">
	<!-- limit 설정  -->	
		<select name ="limit">
			<option value="10">10</option>
			<option value="20">20</option>
			<option value="30">30</option>
			<option value="40">40</option>
			<option value="50">50</option>			
		</select> 
		<button type="submit" class="btn btn-info">선택</button>
	<table class="table table-hover">
	<div>
		<a href="${pageContext.request.contextPath}/">홈으로</a>
	</div>
	<!-- 사원 정보 제목 -->
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
	<!-- 사원 정보 출력 -->
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
	</div>
</body>
</html>