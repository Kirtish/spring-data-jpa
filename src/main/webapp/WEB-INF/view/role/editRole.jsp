<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<jsp:include page="../layout/includes.jsp"/>
<body>
<div class="container">
<jsp:include page="../layout/header.jsp"/>
<h2>Edit Role</h2>
	 <form:form modelAttribute="role" method="post">
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
	   <jsp:include page="../layout/footer.jsp"/>
	  </div>
</body>
</html>