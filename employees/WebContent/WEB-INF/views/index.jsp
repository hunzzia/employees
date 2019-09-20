<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index</h1>
	<!-- 사원의 총 인원 -->
	<div>
		사원 총 인원 : ${employeesRowCount}
	</div>
	<!-- WEB APP 네비게이션 -->
	<div>
		<ul>
			<li><a href="${pageContext.request.contextPath}/departments/getDepartmentsList">부서목록</a></li>
			<li><a href="${pageContext.request.contextPath}/employees/getEmployeesList">사원목록</a></li>	
			<!-- < % =request.getContextPath()%> 프로잭트 이름을 리턴 -->
		</ul>	
	</div>
</body>
</html>