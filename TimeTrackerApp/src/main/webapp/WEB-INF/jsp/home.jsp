<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>
	<h1 align="center">
		<spring:message code="user.list" />
	</h1>

	<table class="w3-table w3-striped">
		<tr>
			<th>Employee Number</th>
			<th>Employee Name</th>
			<th>Role</th>
			<th>Team</th>
			<th>Log Efforts</th>
		</tr>
		<%--@elvariable id="users" type="java.util.List"--%>
		<c:forEach items="${users}" var="user">
			<tr>
				<td><c:out value="${user.getEmployeeNo()}" /></td>
				<td><c:out value="${user.getName()}" /></td>
				<td><c:out value="${user.getRole()}" /></td>
				<td><c:out value="${user.getTeam()}" /></td>
				<td><a
					href="<spring:url value="/show_efforts.html?emp=${user.getEmployeeNo()}"/>">logEfforts</a></td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" value="Create Associate" onclick="window.location.href='/create_associate.html'" />
	<input type="button" value="Display Efforts" onclick="window.location.href='/show_efforts.html'" />	
</body>
</html>