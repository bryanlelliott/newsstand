<%-- 
    Document   : admin
    Created on : Dec 9, 2015, 9:27:33 PM
    Author     : francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set name="theme" value="'simple'" scope="page" />
<jsp:include page="loginTest.jsp"/>
<jsp:include page="adminTest.jsp"/>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <link rel="icon" type="image/png" href="assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Admin</title>

<!-- Bootstrap CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css" media="screen">

<!-- Cutstom CSS -->
<link href="assets/css/custom.css" rel="stylesheet" type="text/css" media="screen">

<!-- Font Awesome -->
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

<style>
.toppad {
    margin-top:20px;
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

                            <s:bean name="model.GenreList">
                            <s:form id="article-form" action="addArticle" method="post" role="form" style="display: block;">
                                <div class="form-group"><label for="addArticleUrl">URL</label><s:textfield name="addArticleUrl" placeholder="Username" cssClass="form-control"/></div>
                                <div class="form-group"><label for="addArticleTitle">Title</label><s:textfield name="addArticleTitle" placeholder="Password" cssClass="form-control"/></div>
                                <div class="form-group"><label for="addArticleAuthor">Author</label><s:textfield name="addArticleAuthor" placeholder="Author, ex. John Smith" cssClass="form-control"/></div>
                                <div class="form-group"><label for="addArticleProvider">Provider</label><s:textfield name="addArticleProvider" placeholder="Provider, ex. CNN" cssClass="form-control"/></div>
                                <div class="form-group"><label for="addArticleDate">Publication Date</label><s:textfield name="addArticleDate" placeholder="MM/DD/YYYY" cssClass="form-control"/></div>
                                <div class="form-group"><label for="addArticleGenre">Article Genre</label><s:select name="addGenre" list="array" cssClass="form-control"/></div>
                                <div class="text-center"><s:submit cssClass="btn btn-success" value="Submit" /></div>
                            </s:form>
                            </s:bean>


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
            <li><a href="logout.jsp">Logout</a></li>
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
    <h1 class="text-center" style="color:white">ADMIN PANELS</h1>
      <div class="row">
        <div class="col-md-7 toppad" >
          <ul class="list-group">
            <li class="list-group-item disabled text-center">ARTICLES</li>
            <li class="list-group-item">
              Article 1
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span>          
            </li>
            <li class="list-group-item">
              Article 2
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span> 
            </li>
            <li class="list-group-item">
              Article 3
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span> 
            </li>
            <li class="list-group-item">
              Article 4
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span> 
            </li>
            <li class="list-group-item">
              Article 5
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span> 
            </li>
            <li class="list-group-item">
              Article 6
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span> 
            </li>
            <li class="list-group-item">
              Article 7
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span> 
            </li>
            <li class="list-group-item">
              Article 8
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span> 
            </li>
            <li class="list-group-item">
              Article 9
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span> 
            </li>
            <li class="list-group-item">
              Article 10
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span> 
            </li>
          </ul>
        </div>

        <div class="col-md-5 toppad" >
          <ul class="list-group">
            <li class="list-group-item disabled text-center">USERS</li>
            <li class="list-group-item">
              Person 1
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span> 
            </li>
            <li class="list-group-item">
              Person 2
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span> 
            </li>
            <li class="list-group-item">
              Person 3
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span> 
            </li>
            <li class="list-group-item">
              Person 4
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span> 
            </li>
            <li class="list-group-item">
              Person 5
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span> 
            </li>
            <li class="list-group-item">
              Person 6
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span> 
            </li>
            <li class="list-group-item">
              Person 7
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span> 
            </li>
            <li class="list-group-item">
              Person 8
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span> 
            </li>
            <li class="list-group-item">
              Person 9
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span> 
            </li>
            <li class="list-group-item">
              Person 10
              <span class="pull-right">
                <a href="#"><i class="fa fa-trash-o" style="color:red"></i></a>
              </span> 
            </li>
          </ul>
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

