<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<jsp:include page="../layout/includes.jsp" />
<body>
	<div class="container">
		<jsp:include page="../layout/header.jsp" />
		<h2>New Purchase</h2>
		<form:form modelAttribute="purchase" method="post">
		<fieldset>
			<table>
				<tr>
					<td><form:label path="purchasedFrom">Purchased From</form:label></td>
					<td><form:input path="purchasedFrom" /></td>
				</tr>
				<tr>
					<td><form:label path="puchaseDate">Date (mm/dd/yyyy):</form:label></td>
					<td><form:input path="puchaseDate" /></td>
				</tr>
				<tr>
					<td><form:label path="comments">Comments</form:label></td>
					<td><form:textarea path="comments" rows="5" cols="30"/></td>
				</tr>
				<tr>
					<td><form:label path="purchaseValue">Amount</form:label></td>
					<td><form:input path="purchaseValue" /></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
			</fieldset>
			
			<table class="table table-striped table-bordered" cellspacing="0">
				<tr>
				<td>Product<td>
				<td>In Stock<td>
				<td>Required quantity</td>
				<td></td>
				</tr>
				<c:forEach items="${purchase.vochers}" var="vocherTransaction" varStatus="status">
				<tr>
				<td>
				<form:select path="vochers[${status.index}].vocher">
				   <form:options items="${products}" itemLabel="name" itemValue="id"/>
				</form:select>
				</td>
				<td>gjhgjhgj </td>						
				<td><form:input path="vochers[${status.index}].quantity"/></td>
				<td>
				   <a class="glyphicon glyphicon-plus" href='<c:out value="../purchases/addProduct/${id}"/>' role="button"></a> 
		          <a class="glyphicon glyphicon-trash" href='<c:out value="../purchases/removeProduct/${id}"/>' role="button">
		        </td>
				</tr>
			</c:forEach>
			 
                
			</table>
					</form:form>
		<jsp:include page="../layout/footer.jsp" />
	</div>
</body>
</html> 	