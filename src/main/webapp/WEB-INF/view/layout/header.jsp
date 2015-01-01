<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
	               <a class="navbar-brand" href="${pageContext.request.contextPath}">Vendor Management</a>
                     
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.request.contextPath}">Dashboard</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Admin<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="${pageContext.request.contextPath}/roles/">Roles</a></li>
            <!--   <li><a href="${pageContext.request.contextPath}/users/">Users</a></li> -->
            <li><a href="${pageContext.request.contextPath}/company/">Companies</a></li>
            <li><a href="${pageContext.request.contextPath}/products/">Products</a></li>
          </ul>
        </li>
        <li><a href="${pageContext.request.contextPath}/sales/">Sales</a></li>
        <li><a href="${pageContext.request.contextPath}/purchases/">Purchases</a></li>
		<li><a href="${pageContext.request.contextPath}/reports/">Reports</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
	    <li><a href="#"><span class="glyphicon glyphicon-user"></span>Welcome <sec:authentication property="principal.firstName"/> <sec:authentication property="principal.lastName"/></a></li>
       <li><a href='<c:url value="/logout"/>'><span class="glyphicon glyphicon-off"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>