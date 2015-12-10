<%-- 
    Document   : editprofile
    Created on : Dec 10, 2015, 4:06:49 PM
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
<title>Edit Profile</title>

<!-- Bootstrap CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css" media="screen">

<!-- Cutstom CSS -->
<link href="assets/css/custom.css" rel="stylesheet" type="text/css" media="screen">

<!-- Font Awesome -->
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

<style>
.user-row {
    margin-bottom: 14px;
}

.user-row:last-child {
    margin-bottom: 0;
}

.dropdown-user {
    margin: 13px 0;
    padding: 5px;
    height: 100%;
}

.dropdown-user:hover {
    cursor: pointer;
}

.table-user-information > tbody > tr {
    border-top: 1px solid rgb(221, 221, 221);
}

.table-user-information > tbody > tr:first-child {
    border-top: 0;
}


.table-user-information > tbody > tr > td {
    border-top: 0;
}
.toppad {
    margin-top:20px;
}
.panel-heading {
  text-align: center;
}

</style>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body style="background-color:black">

<!-- Nav Bar Begins -->
<nav class="navbar navbar-default" style="margin-bottom:0px;padding-bottom:0px">
  <div class="container-fluid" style="padding: 0 0 0 15px;">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false" style="vertical-align:middle">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.jsp" style="padding: 0 0 0 0 !important">
        <img src="assets/img/icon.jpg" style="max-height: 70px; " class="img-responsive" alt="Logo">
      </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="background-color:black">
      <ul class="nav navbar-nav">
        <li class="" style="background-color:black; color:white;border-style:solid;border-color:#2B2B2A;border-width: 0 0 7px 0"><a href="#" style="background-color:black;color:white">ALL <span class="sr-only">(current)</span></a></li>
        <li><a href="#" style="background-color:black; color:white;border-style:solid;border-color:#851a12;border-width: 0 0 7px 0">WORLD</a></li>
        <li><a href="#" style="background-color:black; color:white;border-style:solid;border-color:#e0471b;border-width: 0 0 7px 0">US</a></li>
        <li><a href="#" style="background-color:black; color:white;border-style:solid;border-color:#e89a14;border-width: 0 0 7px 0">POLITICS</a></li>
        <li><a href="#" style="background-color:black; color:white;border-style:solid;border-color:#f2d533;border-width: 0 0 7px 0">ENTERTAINMENT</a></li>
        <li><a href="#" style="background-color:black; color:white;border-style:solid;border-color:#84da7f;border-width: 0 0 7px 0">SPORTS</a></li>
        <li><a href="#" style="background-color:black; color:white;border-style:solid;border-color:#54b2ba;border-width: 0 0 7px 0">TECH</a></li>
        <li><a href="#" style="background-color:black; color:white;border-style:solid;border-color:#0980ff;border-width: 0 0 7px 0">MONEY</a></li>
        <li><a href="#" style="background-color:black; color:white;border-style:solid;border-color:#4e4fbb;border-width: 0 0 7px 0">SCIENCE</a></li>
        <li><a href="#" style="background-color:black; color:white;border-style:solid;border-color:#9218e7;border-width: 0 0 7px 0">TRAVEL</a></li>
        <li><a href="#" style="background-color:black; color:white;border-style:solid;border-color:#e23eaf;border-width: 0 0 7px 0">LIVING</a></li>
        <li><a href="#" style="background-color:black; color:white;border-style:solid;border-color:white;border-width: 0 0 7px 0">UNCATEGORIZED</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
          <li>
              <!-- Button trigger modal -->
              <i class="fa fa-plus fa-2x" style="margin: .7em 0 0 .7em;color:white" data-toggle="modal" data-target="#myModalNorm"></i>
            <!-- Modal -->
            <div class="modal fade" id="myModalNorm" tabindex="-1" role="dialog" 
                 aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <button type="button" class="close" 
                               data-dismiss="modal">
                                   <span aria-hidden="true">&times;</span>
                                   <span class="sr-only">Close</span>
                            </button>
                            <h4 class="modal-title text-center" id="myModalLabel">
                                Add Article
                            </h4>
                        </div>

                        <!-- Modal Body -->
                        <div class="modal-body">

                            <form role="form">
                              <div class="form-group">
                                <label for="addArticleUrl">URL</label>
                                  <input type="text" class="form-control"
                                  id="addArticleUrl" placeholder="Enter the Article URL"/>
                              </div>
                              <div class="form-group">
                                <label for="addArticleTitle">Title</label>
                                  <input type="text" class="form-control"
                                      id="addArticleTitle" placeholder="Article Title"/>
                              </div>
                              <div class="form-group">
                                <label for="addArticleAuthor">Author</label>
                                  <input type="text" class="form-control"
                                      id="addArticleAuthor" placeholder="Author, ex. John Smith"/>
                              </div>
                              <div class="form-group">
                                <label for="addArticleProvider">Provider</label>
                                  <input type="text" class="form-control"
                                      id="addArticleTitle" placeholder="Provider, ex. CNN"/>
                              </div>
                              <div class="form-group">
                                <label for="addArticleDate">Publication Date</label>
                                  <input type="date" class="form-control"
                                      id="addArticleDate" placeholder="Published Date"/>
                              </div>
                              <div class="form-group">
                                <label for="addArticleGenre">Article Genre</label>
                                <select class="form-control" id="addArticleGenre" name="genre">
                                  <option>World</option>
                                  <option>US</option>
                                  <option>Politics</option>
                                  <option>Entertainment</option>
                                  <option>Sports</option>
                                  <option>Tech</option>
                                  <option>Money</option>
                                  <option>Science</option>
                                  <option>Travel</option>
                                  <option>Living</option>
                                  <option>Other</option>
                                </select>
                              </div>
                              <div class="text-center">
                              <button type="submit" class="btn btn-success">Submit</button>
                              </div>
                            </form>


                        </div>

                    </div>
                </div>
            </div>

          </li>
          <!-- End modal code -->
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="background-color:black; color:white"><h5><span class="glyphicon glyphicon-user"></span> Madison <span class="badge">2</span><span class="caret"></span></h5></a>
          <ul class="dropdown-menu">
            <li><a href="profile.jsp">Profile</a></li>
            <li><a href="admin.jsp">Admin Panel</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="index.jsp">Logout</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<!-- Nav Bar Ends -->

<!-- INSERT HTML PAGE CONTENT HERE -->
<div id="main-body" style="background-color:black">
  <div class="container">
      <div class="row">
        <div class="col-md-6 col-md-offset-3 toppad" >
   
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">Your Profile</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class=" col-md-12 col-lg-12 "> 
                  <form id="login-form" action="browse.jsp" method="post" role="form" style="display: block;">
                      <div class="form-group">
                          <label for="editName">Name</label>
			<input type="text" name="editName" id="editName" tabindex="1" class="form-control" placeholder="Madison" value="Madison">
                      </div>
                      <div class="form-group">
                          <label for="editName">Email</label>
			<input type="email" name="editEmail" id="editEmail" tabindex="1" class="form-control" placeholder="madison@dukes.jmu.edu" value="madison@dukes.jmu.edu">
                      </div>
                      <div class="form-group">
                          <label for="editBio">Bio</label>
			<input type="text-area" name="editBio" id="editBio" tabindex="1" class="form-control" placeholder="I am a student at JMU." value="I am a student at JMU.">
                      </div>
                      <div class="form-group">
                          <label for="oldPassword">Current Password</label>
			<input type="oldPassword" name="oldPassword" id="oldPassword" tabindex="1" class="form-control" placeholder="" value="">
                      </div>
                      <div class="form-group">
                          <label for="editPassword">New Password (not required)</label>
			<input type="password" name="editPassword" id="editPassword" tabindex="1" class="form-control" placeholder="" value="">
                      </div>
                      <div class="form-group">
                        <label for="editName">Confirm New Password (not required)</label>
			<input type="password" name="confirmPassword" id="confirmPassword" tabindex="1" class="form-control" placeholder="" value="">
                      </div>
                      <div class="form-group">
                      <input type="submit" class="btn btn-default"></input>
                      </div>
                  </form>
                  
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
</div>
<!-- End Main Body -->
<!-- jQuery and Bootstrap links - do not delete! -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->

</body>
</html>


