<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<jsp:include page="../layout/includes.jsp"/>
<body>
<div class="container">
<jsp:include page="../layout/header.jsp"/>
	<table class="table table-striped table-bordered" cellspacing="0" >
	<tr>
		<a class="btn btn-default" href="${pageContext.request.contextPath}/products/new" role="button">Add Product</a>		 
	</tr>
	<tr>
		<td>#</td>
		<td>name</td>
		<td>Description</td>
		<td>Unit Price</td>
		<td>In stock</td>
		<td>is Topup?</td>
		<td>Company</td>		
		<td></td>
	</tr>
	<c:forEach items="${products}" var="product">
	   <tr>
	    <td>  <c:url var="editUrl" value="../products/edit/${product.id}"/>
		   ${product.id}</td>
	   	<td>${product.name}</td>
	   	<td>${product.descr}</td>
	   	<td>${product.price}</td>
	   	<td>${product.instock}</td>
	   	<td>${product.topup}</td>
	   	<td>${product.company.descr}</td>
	   	<td><a class="glyphicon glyphicon-pencil" href='<c:out value="${editUrl}"/>' role="button"></a> 
		<a class="glyphicon glyphicon-trash" href='<c:out value="../products/delete/${product.id}"/>' role="button"></a></td>
	   </tr>
	</c:forEach>
	</table>
	
	   <jsp:include page="../layout/footer.jsp"/>
	  </div>
</body>
</html>