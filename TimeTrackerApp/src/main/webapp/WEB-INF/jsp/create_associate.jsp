<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
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
</head>

<body>

	<div class="login-page">
		<h1>
			<spring:message code="user.create" />
		</h1>
		<div class="form">
			<form:form method="POST" action="/create_associate.html"
				modelAttribute="form" class="login-form">
				<form:errors path="" element="div" />
				<div>
					<form:label path="employeeNo">
						<spring:message code="user.id" />
					</form:label>
					<form:input path="employeeNo" />
					<form:errors path="employeeNo" />
				</div>
				<div>
					<form:label path="name">
						<spring:message code="user.name" />
					</form:label>
					<form:input path="name" />
					<form:errors path="name" />
				</div>
				<div>
					<form:label path="team">
						<spring:message code="user.team" />
					</form:label>
					<form:input path="team" />
					<form:errors path="team" />
				</div>
				<div>
					<form:label path="emailId">
						<spring:message code="user.emailId" />
					</form:label>
					<form:input path="emailId" />
					<form:errors path="emailId" />
				</div>
				<div>
					<form:label path="phoneNo">
						<spring:message code="user.phoneNo" />
					</form:label>
					<form:input path="phoneNo" />
					<form:errors path="phoneNo" />
				</div>
				<div>
					<form:label path="role">
						<spring:message code="user.role" />
					</form:label>
					<form:input path="role" />
					<form:errors path="role" />
				</div>
				<div>
					<form:label path="password1">
						<spring:message code="user.password1" />
					</form:label>
					<form:password path="password1" />
					<form:errors path="password1" />
				</div>
				<div>
					<form:label path="password1">
						<spring:message code="user.password2" />
					</form:label>
					<form:password path="password2" />
					<form:errors path="password2" />
				</div>
				<div>
				<button>Create</button>
			<input type="button" value="Back"
						onclick="window.location.href='/login.html'" />		
				</div>
			</form:form>
			
		</div>
	</div>
</body>
</html>
