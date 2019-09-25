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