<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table><caption>Users</caption>
	<tr>
		<td>First Name</td>
		<td>Middle Name</td>
		<td>Last Name</td>
		<td>Login Id</td>
	</tr>
	<c:forEach items="${users}" var="user">
	   <tr>
	   	<td>${user.firstName}</td>
	   	<td>${user.middleName}</td>
	   	<td>${user.lastName}</td>
	   	<td>${user.loginId}</td>
	   	
	   </tr>
	</c:forEach>
	</table>
	
	<table><tr>
		<td><button>Add</button></td>
		<td><button>Update</button></td>
		<td><button>Delete</button></td>
		
	</tr></table>
</body>
</html>