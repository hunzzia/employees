<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원목록 between</h1>
		<div>
			<a href="${pageContext.request.contextPath}/">홈으로</a>
		</div>
		<form method ="get" action="${pageContext.request.contextPath}/employees/getEmployeesList">
			<select name ="limit">
				<option value="10">10</option>
				<option value="20">20</option>
				<option value="30">30</option>
				<option value="40">40</option>
				<option value="50">50</option>
			</select>
			<button type="submit">선택</button>
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
</body>
</html>