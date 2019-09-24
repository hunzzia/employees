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
	<h1>성별에 따른 사원수</h1>
	<table border="1">
		<thead>
			<tr>
				<th>성별</th>
				<th>수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="map" items="${list}">
				<tr>
					<td>${map.gender}</td>
					<td>${map.cnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>