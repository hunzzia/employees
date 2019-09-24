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
	<h1>업무 목록</h1>
	<div>
		<a href="${pageContext.request.contextPath}/">홈으로</a>
	</div>
	<ol><!-- var 받아올 변수 items 값만큼 반복 -->
		<c:forEach var="row" items="${list}">
			<li>${row}</li>
		</c:forEach>
	</ol>
</body>
</html>