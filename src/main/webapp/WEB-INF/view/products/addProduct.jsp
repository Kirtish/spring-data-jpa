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
		<h2>New Product</h2>
		<form:form modelAttribute="product" method="post">
			<table>
				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td><form:label path="descr">Description</form:label></td>
					<td><form:input path="descr" /></td>
				</tr>
				<tr>
					<td><form:label path="price">Unit price</form:label></td>
					<td><form:input path="price" /></td>
				</tr>
				<tr>
					<td><form:label path="instock">Available Stock</form:label></td>
					<td><form:input path="instock" /></td>
				</tr>
				
				<tr>
					<td><form:label path="minStock">Min Stock to be manintaned</form:label></td>
					<td><form:input path="minStock" /></td>
				</tr>
				<tr>
					<td><form:label path="maxStock">Allowed Max Stock</form:label></td>
					<td><form:input path="maxStock" /></td>
				</tr>
				<tr>
					<td><form:label path="company">Company</form:label></td>
					<td><form:select path="company">
							<form:options items="${companies}" itemLabel="name" itemValue="id"/>
						</form:select></td>
				</tr>
				<tr>
					<td></td>
					<td><form:checkbox path="topup"
							label="Is Topup?" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
		<jsp:include page="../layout/footer.jsp" />
	</div>
</body>
</html>