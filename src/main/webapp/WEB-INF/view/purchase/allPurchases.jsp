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
		<a class="btn btn-default" href=" ${pageContext.request.contextPath}/purchases/new" role="button">Add Purchase</a>		 
	</tr>
	<tr>
		<td>#</td>
		<td>Purchased From</td>
		<td>Purchase Date</td>
		<td>Purchase Amount</td>
		<td>Purchase Comments</td>
		<td></td>
	</tr>
	<c:forEach items="${purchases}" var="purchase">
	   <tr>
	    <td>  <c:url var="editUrl" value="../purchases/edit/${purchase.id}"/>
		   ${purchase.purchasedFrom}</td>
	   	<td>${purchase.purchaseDate}</td>
	   	<td>${purchase.purchaseValue}</td>
	   	<td>${purchase.comments}</td>
		<td><a class="glyphicon glyphicon-pencil" href='<c:out value="${editUrl}"/>' role="button"></a> 
		<a class="glyphicon glyphicon-trash" href='<c:out value="../purchases/delete/${purchase.id}"/>' role="button"></a></td>
	   </tr>
	</c:forEach>
	</table>
	
	   <jsp:include page="../layout/footer.jsp"/>
	  </div>
</body>
</html>