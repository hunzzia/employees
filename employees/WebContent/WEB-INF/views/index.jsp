<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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
<!-- charSet -->
<meta charset="UTF-8">
<title>Index - HOME</title>
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

	<div class="container">
	<!-- 테이블 이름과 전체 행의 수 -->
		<h3 style="text-align: center;">번호 입력 검색</h3>
		<div class="container" style="width: 70%;">
			<form method="post" action ="${pageContext.request.contextPath}/employees/getEmployeesListBetween">
				<input type="number" class="form-control" name="begin" value="${minEmpNo}">~<input type="number" class="form-control" name="end" value="${maxEmpNo}">
				<br>
				<button type="submit" class="btn btn-primary" style="align-content: auto;">사원 목록 검색</button>
			</form>
		</div>
	<br>
		<table class="table table-bordered table-hover"  style="text-align:center;">
			<thead>
				<tr>
					<th>테이블이름</th>
					<th>departments</th>
					<th>employees</th>
					<th>dept_manager</th>
					<th>dept_emp</th>
					<th>titles</th>
					<th>salaries</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>전체 행의 수</td>
					<td>${employeesRowCount}</td>
					<td>${departmentsRowCount}</td>
					<td>${deptManagerRowCount}</td>
					<td>${deptEmpRowCount}</td>
					<td>${titlesRowCount}</td>
					<td>${salariesRowCount}</td>
				</tr>
			</tbody>
		</table>
		<div id="barchart_material" style="width: 900px; height: 500px;">
      	</div>
	</div>	<!-- < % =request.getContextPath()%> 프로잭트 이름을 리턴 -->	
</body>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawStuff);
	
      function drawStuff() {
    	  list2 = new Array;
    	  $.ajax({
              url:"${pageContext.request.contextPath}/index",
              method:"get",
              async:false,
              success:function(json){
            	  list2.push(['전체 행의수', 'count'])
            	  console.log("값"+json.list);
                  console.log("요청 성공");
                	  let count = [];
                	  count.push(json.list.chartdepartmentsRowCount)
                	  count.push(json.list.employeesRowCount)
                      count.push(json.list.deptManagerRowCount)
                      count.push(json.list.deptEmpRowCount)
                      count.push(json.list.salariesRowCount)
                      count.push(json.list.titlesRowCount)
                      list2.push(count)
               
                  console.log(list2);
              }
          });
        var data = new google.visualization.arrayToDataTable(
         	list2
        );

        var options = {
                chart: {
                  title: '테이블의 전체 행의 수',
                },
                bars: 'vertical' // Required for Material Bar Charts.
              };

              var chart = new google.charts.Bar(document.getElementById('barchart_material'));

              chart.draw(data, google.charts.Bar.convertOptions(options));
      };
  </script>
</html>