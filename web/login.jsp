<%-- 
    Document   : login
    Created on : Dec 9, 2015, 9:27:08 PM
    Author     : francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set name="theme" value="'css_xhtml'" scope="page" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <link rel="icon" type="image/png" href="assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Login</title>

<!-- Bootstrap CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css" media="screen">

<!-- Cutstom CSS -->
<link href="assets/css/custom.css" rel="stylesheet" type="text/css" media="screen">

<!-- Font Awesome -->
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

<style>
        #register-form > div, #login-form > div {
            margin-bottom:15px;
            text-align:center;
        }
        .panel-login > input[type="text"] {
            width:100%
        }
</style>  

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body id="signup">
<div class="container">
    	<div class="row">
			<div class="col-md-6 col-md-offset-3">

				<div class="panel panel-login">
					<div class="row" style="text-align:center">
							<a href="index.jsp"><h1>THE NEWSSTAND</h1></a>
							<hr style="width:80%">
					</div>
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Login</a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="register-form-link">Register</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<s:form id="login-form" action="signin" method="post" role="form" style="display: block;">
                                                                        <s:textfield name="userId" placeholder="Username" class="form-group"/>
                                                                        <s:password name="password" placeholder="Password"/>
                                                                        <s:submit value="submit" />
								</s:form>
								<s:bean name="model.QuestionList">
								<s:form id="register-form" action="signup" method="post" role="form" style="display: none;">
                                                                        <s:textfield name="realName" placeholder="Your name" class="form-group" validate="true"/>
                                                                        <s:textfield name="email" placeholder="Your email" class="form-group"/>
                                                                        <s:textfield name="userId" placeholder="Username" validate="true"/>
                                                                        <s:password name="password" placeholder="Password" validate="true"/>
                                                                        <s:password name="confirmPassword" placeholder="Re-enter password"/>
                                                                        <s:textarea name="bio" placeholder="A sentence about yourself"/>
                                                                        <hr>
                                                                        <h5 style="text-align:center">Password Recovery Question</h5>
                                                                        <s:select name="secretQuestion" list="array" />
                                                                        <s:textfield name="secretAnswer" placeholder="Your answer" />
                                                                        <s:submit value="submit" />
								</s:form>
                                                                </s:bean>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script>
	$(function() {

    $('#login-form-link').click(function(e) {
    	$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

});
</script>

<!-- Include all compiled plugins (below), or include individual files as needed -->

</body>
</html>
