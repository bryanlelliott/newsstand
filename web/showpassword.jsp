<%-- 
    Document   : showpassword
    Created on : Dec 10, 2015, 8:01:34 PM
    Author     : francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <link rel="icon" type="image/png" href="assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Show Password</title>

<!-- Bootstrap CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css" media="screen">

<!-- Cutstom CSS -->
<link href="assets/css/custom.css" rel="stylesheet" type="text/css" media="screen">

<!-- Font Awesome -->
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">


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
					<div class="panel-heading" style="padding-top:0">
						<div class="row">
                                                    <h3>Your Login Credentials</h3>
						</div>
						
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form id="login-form" action="browse.jsp" method="post" role="form" style="display: block;">
                                                                        <table class="table table-user-information">
                                                                            <tbody>
                                                                              <tr>
                                                                                <td><strong>Username</strong></td>
                                                                                <td>madison2015</td>
                                                                              </tr>
                                                                              <tr>
                                                                                <td><strong>Password</strong></td>
                                                                                <td>*****</td>
                                                                              </tr>
                                                                            </tbody>
                                                                          </table>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->

</body>
</html>


