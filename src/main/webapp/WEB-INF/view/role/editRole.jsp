<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Role</title>
</head>
<body>
  <h2>Edit Role</h2>
<form:form modelAttribute="role" method="put">
   <table>
    <tr>
        <td><form:label path="code">Code</form:label></td>
        <td><form:input path="code" /></td>
    </tr>
    <tr>
        <td><form:label path="descr">Description</form:label></td>
        <td><form:input path="descr" /></td>
    </tr>
   
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>