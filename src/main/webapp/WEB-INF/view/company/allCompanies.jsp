<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<jsp:include page="../layout/includes.jsp"/>
<body>
<div class="container">
<jsp:include page="../layout/header.jsp"/>
	<table class="table table-striped table-bordered" cellspacing="0" >
	<tr>
		<a class="btn btn-default" href=" ${pageContext.request.contextPath}/company/new" role="button">Add Company</a>		 
	</tr>
	<tr>
		<td>#</td>
		<td>Name</td>
		<td>Description</td>
		<td></td>
	</tr>
	<c:forEach items="${companies}" var="company">
	   <tr>
	    <td>  <c:url var="editUrl" value="../company/edit/${company.id}"/>
		   ${company.id}</td>
	   	<td>${company.name}</td>
	   	<td>${company.descr}</td>
		<td><a class="glyphicon glyphicon-pencil" href='<c:out value="${editUrl}"/>' role="button"></a> 
		<a class="glyphicon glyphicon-trash" href='<c:out value="../company/delete/${company.id}"/>' role="button"></a></td>
	   </tr>
	</c:forEach>
	</table>
	
	   <jsp:include page="../layout/footer.jsp"/>
	  </div>
</body>
</html>