<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<head>
<style>
@import url(https://fonts.googleapis.com/css?family=Roboto:300);

.login-page {
	width: 360px;
	padding: 8% 0 0;
	margin: auto;
}

.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 360px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

.form input {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form button {
	font-family: "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: #4CAF50;
	width: 100%;
	border: 0;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
}

.form button:hover, .form button:active, .form button:focus {
	background: #43A047;
}

.form .message {
	margin: 15px 0 0;
	color: #b3b3b3;
	font-size: 12px;
}

.form .message a {
	color: #4CAF50;
	text-decoration: none;
}

.form .register-form {
	display: none;
}

.container {
	position: relative;
	z-index: 1;
	max-width: 300px;
	margin: 0 auto;
}

.container:before, .container:after {
	content: "";
	display: block;
	clear: both;
}

.container .info {
	margin: 50px auto;
	text-align: center;
}

.container .info h1 {
	margin: 0 0 15px;
	padding: 0;
	font-size: 36px;
	font-weight: 300;
	color: #1a1a1a;
}

.container .info span {
	color: #4d4d4d;
	font-size: 12px;
}

.container .info span a {
	color: #000000;
	text-decoration: none;
}

.container .info span .fa {
	color: #EF3B3A;
}

body {
	background: #76b852; /* fallback for old browsers */
	background: -webkit-linear-gradient(right, #76b852, #8DC26F);
	background: -moz-linear-gradient(right, #76b852, #8DC26F);
	background: -o-linear-gradient(right, #76b852, #8DC26F);
	background: linear-gradient(to left, #76b852, #8DC26F);
	font-family: "Roboto", sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
}
</style>
<script>
$('.message a').click(function(){
	   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
	});
</script>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		//var empNo = '${empNo}';
		//alert(empNo);
		var empNo = $("#empNo").html();

		if (empNo == undefined) {
			$("#edit").hide();
			$(".edit1").hide();
			$("#edit2").hide();
		} else {
			$("#edit").show();
			$(".edit1").show();
			$("#edit2").show();
		}
		$(".hide").hide();
		
	});
</script>
<body>
	<h1 align="center">
		<spring:message code="user.efforts" />
		of
		<c:choose>
			<c:when test="${empNo != null}">
				<h2 id="empNo" align="center">
					<c:out value="${empNo}" />
				</h2>
			</c:when>
			<c:otherwise>All Associates</c:otherwise>
		</c:choose>
	</h1>


	<input id="edit2" type="button" value="Add Effort"
		onclick="window.location.href='/logEfforts.html?emp=${empNo}'" />

	<table class="w3-table w3-striped w3-bordered">
		<tr>
			<th class="hide">Employee Taks Id</th>
			<th>Task Description</th>
			<th>Effort</th>
			<th>Effort Date</th>
			<th class="hide">Is OOO</th>
			<th>Effort Spent During</th>
			<th>Jira ID</th>
			<th>Epic ID</th>
			<th>Employee No</th>
			<th>Project ID</th>
			<th id="edit">Edit</th>
		</tr>

		<%--@elvariable id="efforts" type="java.util.List"--%>
		<c:forEach items="${efforts}" var="effort">
			<tr>
				<td class="hide"><c:out value="${effort.getEmployeeTaskId()}" /></td>
				<td><c:out value="${effort.getTaskDescription()}" /></td>
				<td><c:out value="${effort.getEffort()}" /></td>
				<td><c:out value="${effort.getEffortDate()}" /></td>
				<td class="hide"><c:out value="${effort.isOutofOffice()}" /></td>
				<c:choose>
					<c:when test="${effort.getEffortSpentDuring() == 1}">
						<td>NormalHours</td>
					</c:when>
					<c:when test="${effort.getEffortSpentDuring() == 2}">
						<td>OutOfOffice - Weekday</td>
					</c:when>
					<c:when test="${effort.getEffortSpentDuring() == 3}">
						<td>OutOfOffice - Weekend</td>
					</c:when>
					<c:otherwise>
						<td></td>
					</c:otherwise>
				</c:choose>
				<td><c:out value="${effort.getJiraId()}" /></td>
				<td><c:out value="${effort.getEpicId()}" /></td>
				<c:choose>
					<c:when test="${effort.getEmployeeNo() != null}">
						<td><c:out value="${effort.getEmployeeNo()}" /></td>
					</c:when>
					<c:otherwise>
						<td><c:out value="${empNo}" /></td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${effort.getProjectId() == 1}">
						<td>AIS</td>
					</c:when>
					<c:when test="${effort.getProjectId() == 2}">
						<td>API Garden</td>
					</c:when>
					<c:when test="${effort.getProjectId() == 3}">
						<td>API Multidevice</td>
					</c:when>
					<c:when test="${effort.getProjectId() == 4}">
						<td>AWS</td>
					</c:when>
					<c:when test="${effort.getProjectId() == 5}">
						<td>DevOps-Automation</td>
					</c:when>
					<c:when test="${effort.getProjectId() == 6}">
						<td>DevOps-GESB</td>
					</c:when>
					<c:when test="${effort.getProjectId() == 7}">
						<td>Finland Transformation Dev</td>
					</c:when>
					<c:when test="${effort.getProjectId() == 8}">
						<td>Finland Transformation Operation</td>
					</c:when>
					<c:when test="${effort.getProjectId() == 9}">
						<td>OWF</td>
					</c:when>
					<c:when test="${effort.getProjectId() == 10}">
						<td>Phoenix</td>
					</c:when>
					<c:otherwise>
						<td></td>
					</c:otherwise>
				</c:choose>



				<td class="edit1"><a
					href="<spring:url value="/edit_task.html?etaskId=${effort.getEmployeeTaskId()}"/>">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<!-- <input type="button" value="Back" onclick="window.location.href='/home.html'" /> -->
</body>
</html>