<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
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
	$('.message a').click(function() {
		$('form').animate({
			height : "toggle",
			opacity : "toggle"
		}, "slow");
	});
</script>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<body>

	<div class="login-page">
		<div class="form">
			<h1>
				<spring:message code="efforts.log" />
			</h1>
			<form:form method="POST" action="/logEfforts.html"
				modelAttribute="form">
				<form:errors path="" element="div" />
				<div hidden="true">
					<form:input path="employeeTaskId" />
				</div>
				<div>
					<form:label path="taskDescription">
						<spring:message code="TimeEffort.taskDescription" />
					</form:label>
					<form:input path="taskDescription" />
					<form:errors path="taskDescription" />
				</div>
				<div>
					<form:label path="effort">
						<spring:message code="TimeEffort.effort" />
					</form:label>
					<form:input path="effort" />
					<form:errors path="effort" />
				</div>
				<div>
					<form:label path="effortDate">
						<spring:message code="TimeEffort.effortDate" />
					</form:label>
					<form:input path="effortDate" id="datepicker" />
					<form:errors path="effortDate" />
				</div>

				<form:label path="effortSpentDuring">
					<spring:message code="TimeEffort.EffortSpentDuring" />
				</form:label>
				<form:select path="effortSpentDuring" items="${allEffortSpendList}"
					itemValue="effortSid" itemLabel="description" />
				<form:errors path="effortSpentDuring" />

				<div hidden="true">
					<form:label path="outofOffice">
						<spring:message code="TimeEffort.outofOffice" />
					</form:label>
					<form:radiobutton path="outofOffice" value="true" default="false" />
					Y
					<form:radiobutton path="outofOffice" value="false" />
					N
					<form:errors path="outofOffice" />
				</div>
				<div>
					<form:label path="jiraId">
						<spring:message code="TimeEffort.jiraId" />
					</form:label>
					<form:input path="jiraId" />
					<form:errors path="jiraId" />
				</div>
				<div>
					<form:label path="epicId">
						<spring:message code="TimeEffort.epicId" />
					</form:label>
					<form:input path="epicId" />
					<form:errors path="epicId" />
				</div>
				<div>
					<form:label path="projectId">
						<spring:message code="TimeEffort.projectId" />
					</form:label>
					<form:select path="projectId" items="${allProjects}"
						itemValue="projectId" itemLabel="description" />
					<form:errors path="projectId" />
				</div>
				<div hidden="true">
					<form:input path="employeeNo" value="${emp}" />
				</div>
				<div>
					<br/>
					 <button>Submit</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>
