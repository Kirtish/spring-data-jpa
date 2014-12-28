<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Roles</title>
</head>

<body>
	<table><caption>Roles </caption>
	<tr>
		<td>id</td>
		<td>Code</td>
		<td>Description</td>
	</tr>
	<c:forEach items="${roles}" var="role">
	   <tr>
	    <td>  <c:url var="editUrl" value="/roles/${role.id}/edit"/>
		  <a href='<c:out value="${editUrl}"/>'> ${role.id}</a></td>
	   	<td>${role.code}</td>
	   	<td>${role.descr}</td>
	   </tr>
	</c:forEach>
	</table>
	
	<table><tr>
		<td>
		   <a href='<spring:url value="/roles/new" htmlEscape="true"/>'>Add Role</a>
		</td>

	</tr></table>
</body>
</html>