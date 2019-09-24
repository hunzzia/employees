<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>연봉 통계값</h1>
	<table border="1">
		<thead>
			<tr>
				<th>연봉 수</th>
				<th>연봉 합</th>
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