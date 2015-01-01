<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<jsp:include page="../layout/includes.jsp"/>
<style>
.btn-twitter { background: #00acee; border-radius: 0; color: #fff } .btn-twitter:link, .btn-twitter:visited { color: #fff } .btn-twitter:active, .btn-twitter:hover { background: #0087bd; color: #fff } 
 .btn-facebook { background: #3b5998; border-radius: 0; color: #fff } .btn-facebook:link, .btn-facebook:visited { color: #fff } .btn-facebook:active, .btn-facebook:hover { background: #30477a; color: #fff } 
 .btn-googleplus { background: #e93f2e; border-radius: 0; color: #fff } .btn-googleplus:link, .btn-googleplus:visited { color: #fff } .btn-googleplus:active, .btn-googleplus:hover { background: #ba3225; color: #fff }
 .btn-stumbleupon { background: #f74425; border-radius: 0; color: #fff } .btn-stumbleupon:link, .btn-stumbleupon:visited { color: #fff } .btn-stumbleupon:active, .btn-stumbleupon:hover { background: #c7371e; color: #fff }
.btn-linkedin { background: #0e76a8; border-radius: 0; color: #fff } .btn-linkedin:link, .btn-linkedin:visited { color: #fff } .btn-linkedin:active, .btn-linkedin:hover { background: #0b6087; color: #fff } 
</style>
<body>
 
<!-- 
    If the user is anonymous (not logged in), show the login form
    and social sign in buttons.
-->
<sec:authorize access="isAnonymous()">
   <div class="container">    
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Sign In</div>
                        <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Forgot password?</a></div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                            
							<form action="${pageContext.request.contextPath}/login/authenticate" method="POST"  id="loginform" class="form-horizontal" role="form">
                			 <!-- Add CSRF token -->
                           <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                              
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                        <input id="login-username" type="text" class="form-control" name="username" value="" placeholder="username or email">                                        
                                    </div>                       
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                        <input id="login-password" type="password" class="form-control" name="password" placeholder="password">
                                    </div>
                            <div class="input-group">
                                      <div class="checkbox">
                                        <label>
                                          <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
                                        </label>
                                      </div>
									     <!-- <a id="btn-login" href="#" class="btn btn-success">Login  </a> -->
										 <button type="submit" class="btn btn-success"><spring:message code="label.user.login.submit.button"/></button>
                                  
                                    </div>
                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                      <a id="btn-fblogin" href="${pageContext.request.contextPath}/auth/facebook" class="btn btn-primary">Facebook</a>
								      <a id="btn-twlogin" href="${pageContext.request.contextPath}/auth/twitter" class="btn btn-twitter">Twitter</a>
     							      <a id="btn-lilogin" href="${pageContext.request.contextPath}/auth/linkedin" class="btn btn-linkedin">Linkedin</a>
									  <a id="btn-glogin" href="#" class="btn btn-googleplus">Google+</a>

                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-md-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                            Don't have an account! 
                                        <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                                            Sign Up Here
                                        </a>
                                        </div>
                                    </div>
                                </div>    
                            </form>     



                        </div>                     
                    </div>  
        </div>
        <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title">Sign Up</div>
                            <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a></div>
                        </div>  
                        <div class="panel-body" >
                            <form id="signupform" class="form-horizontal" role="form">
                                
                                <div id="signupalert" style="display:none" class="alert alert-danger">
                                    <p>Error:</p>
                                    <span></span>
                                </div>
                                    
                                
                                  
                                <div class="form-group">
                                    <label for="email" class="col-md-3 control-label">Email</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="email" placeholder="Email Address">
                                    </div>
                                </div>
                                    
                                <div class="form-group">
                                    <label for="firstname" class="col-md-3 control-label">First Name</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="firstname" placeholder="First Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="lastname" class="col-md-3 control-label">Last Name</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="lastname" placeholder="Last Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-md-3 control-label">Password</label>
                                    <div class="col-md-9">
                                        <input type="password" class="form-control" name="passwd" placeholder="Password">
                                    </div>
                                </div>
                                    
                                <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">Invitation Code</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="icode" placeholder="">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <!-- Button -->                                        
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-signup" type="button" class="btn btn-info"><i class="icon-hand-right"></i> &nbsp Sign Up</button>
                                        <span style="margin-left:8px;">or</span>  
                                    </div>
                                </div>
                                
                                <div style="border-top: 1px solid #999; padding-top:20px"  class="form-group">
                                    
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-fbsignup" type="button" class="btn btn-primary"><i class="icon-facebook"></i>   Sign Up with Facebook</button>
								
 </div>                                           
                                        
                                </div>
								
                                
                                
                            </form>
                         </div>
                    </div>

               
               
                
         </div> 
    </div>
    </sec:authorize>
<!-- 
    If the user is already authenticated, show a help message instead
    of the login form and social sign in buttons.
-->
<sec:authorize access="isAuthenticated()">
    <p><spring:message code="text.login.page.authenticated.user.help"/></p>
</sec:authorize>
</body>
</html>