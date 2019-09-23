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
	<h1>부서 목록</h1>
	<div>
		<a href="${pageContext.request.contextPath}/">홈으로</a>
	</div>
	<table border ="1">
		<thead>
			<tr>
				<th>부서 번호</th>
				<th>부서 이름</th>
			</tr>
		</thead>
		
		<tbody>
		<!-- jstl 표현 -->
			<c:forEach var="department" items="${list}"><!-- for(Department department : list) -->
				<tr>
					<td>${department.deptNo}</td>		<!-- department 안에는 겟터와 셋터가 무조건 있어야함 -->
					<td>${department.deptName}</td>		<!-- < % =department.getDeptName() %> -->
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>