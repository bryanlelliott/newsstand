<%-- 
    Document   : browse
    Created on : Dec 9, 2015, 9:25:44 PM
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
<title>Browse</title>

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
        <li class="active" style="background-color:#2B2B2A; color:black;padding-bottom:20px;"><a href="#" style="background-color:black;color:white">ALL <span class="sr-only">(current)</span></a></li>
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
        <!--
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
        -->
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
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="background-color:black; color:white"><h5><s:property value="userId"/><span class="caret"></span></h5></a>
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
<div id="main-body">
<div class="row" style="margin: 0;background-color:#2B2B2A;">
  <div class="col-sm-4" style="text-align:left;">
    <ol class="breadcrumb" style="margin: 20px 0 20px 0; width:50%">
      <li><a href="#">Browse</a></li>
      <li><a href="#">All</a></li>
      <li class="active">Page 2</li>
    </ol>
  </div>
  <div class="col-sm-4" style="text-align:center">
    <ul class="pagination" style="padding:0; border-color:white">
      <li>
        <a href="#" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
        </a>
      </li>
      <li><a href="#">1</a></li>
      <li class="active"><a href="#">2</a></li>
      <li><a href="#">3</a></li>
      <li>
        <a href="#" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
        </a>
      </li>
    </ul>
  </div>
  <div class="col-sm-4" style="padding:0">
    <div class="dropdown pull-right" style="margin-top:20px; margin-right:15px">
      <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
        Sort by
        <span class="caret"></span>
      </button>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
        <li class="active"><a href="#" style="background-color:gray">Date</a></li>
        <li><a href="#">Views</a></li>
        <li><a href="#">Ratings</a></li>
      </ul>
    </div>
  </div>
</div>
<div class="row" style="margin-left:0px !important;margin-right:0px !important;">
  <div class="col-md-4" style="height:350px;margin:0;background:url('assets/img/travel-balloon-tint.jpg') no-repeat;background-size:cover;color:white;">
    <a href="article.jsp"><div class="art-pane">
      <h2 style="text-transform:uppercase;">article title</h2>
      <p><small>from</small> SOURCE</p>
      <p>
        <i class="fa fa-star"></i> 3.7 | <i class="fa fa-comment"></i> 15 | <i class="fa fa-book"></i>
 travel
      </p>
      <p>
        "This is the first sentence of the article."
      </p>
    </div>
    </a>
  </div>

  <div class="col-md-4" style="height:350px;margin:0;background:url('assets/img/tech-tint.jpg') no-repeat;background-size:cover;color:white;">
    <a href="article.jsp"><div class="art-pane">
      <h2 style="text-transform:uppercase;">article title</h2>
      <p><small>from</small> SOURCE</p>
      <p>
        <i class="fa fa-star"></i> 4.2 | <i class="fa fa-comment"></i> 20 | <i class="fa fa-book"></i>
 tech
      </p>
      <p>
        "This is the first sentence of the article."
      </p>
    </div></a>
  </div>
 
  <div class="col-md-4" style="height:350px;margin:0;background:url('assets/img/entertain-music-tint.jpg') no-repeat;background-size:cover;color:white;">
    <a href="article.jsp"><div class="art-pane">
      <h2 style="text-transform:uppercase;">article title</h2>
      <p><small>from</small> SOURCE</p>
      <p>
        <i class="fa fa-star"></i> 3.1 | <i class="fa fa-comment"></i> 2 | <i class="fa fa-book"></i>
 entertainment
      </p>
      <p>
        "This is the first sentence of the article."
      </p>
    </div></a>
  </div>
</div>
<!-- End Row 1 -->
<div class="row" style="margin-left:0px !important;margin-right:0px !important;">
  <div class="col-md-4" style="height:350px;margin:0;background:url('assets/img/politics-building-tint.jpg') no-repeat;background-size:cover;color:white;">
    <a href="article.jsp"><div class="art-pane">
      <h2 style="text-transform:uppercase;">article title</h2>
      <p><small>from</small> SOURCE</p>
      <p>
        <i class="fa fa-star"></i> 2.7 | <i class="fa fa-comment"></i> 9 | <i class="fa fa-book"></i>
 politics
      </p>
      <p>
        "This is the first sentence of the article."
      </p>
    </div></a>
  </div>

  <div class="col-md-4" style="height:350px;margin:0;background:url('assets/img/living-chairs-tint.jpg') no-repeat;background-size:cover;color:white;">
    <a href="article.jsp"><div class="art-pane">
      <h2 style="text-transform:uppercase;">article title</h2>
      <p><small>from</small> SOURCE</p>
      <p>
        <i class="fa fa-star"></i> 3.5 | <i class="fa fa-comment"></i> 3 | <i class="fa fa-book"></i>
 living
      </p>
      <p>
        "This is the first sentence of the article."
      </p>
    </div></a>
  </div>
 
  <div class="col-md-4" style="height:350px;margin:0;background:url('assets/img/science-curiosity-tint.jpg') no-repeat;background-size:cover;color:white;">
    <a href="article.jsp"><div class="art-pane">
      <h2 style="text-transform:uppercase;">article title</h2>
      <p><small>from</small> SOURCE</p>
      <p>
        <i class="fa fa-star"></i> 4.0 | <i class="fa fa-comment"></i> 15 | <i class="fa fa-book"></i>
 science
      </p>
      <p>
        "This is the first sentence of the article."
      </p>
    </div></a>
  </div>
</div>
<!-- End Row 2 -->
<div class="row" style="margin-left:0px !important;margin-right:0px !important;">
  <div class="col-md-4" style="height:350px;margin:0;background:url('assets/img/money-buildings-tint.jpg') no-repeat;background-size:cover;color:white;">
    <a href="article.jsp"><div class="art-pane">
      <h2 style="text-transform:uppercase;">article title</h2>
      <p><small>from</small> SOURCE</p>
      <p>
        <i class="fa fa-star"></i> 3.7 | <i class="fa fa-comment"></i> 15 | <i class="fa fa-book"></i>
 money
      </p>
      <p>
        "This is the first sentence of the article."
      </p>
    </div></a>
  </div>

  <div class="col-md-4" style="height:350px;margin:0;background:url('assets/img/world-london-tint.jpg') no-repeat;background-size:cover;color:white;">
    <a href="article.jsp"><div class="art-pane">
      <h2 style="text-transform:uppercase;">article title</h2>
      <p><small>from</small> SOURCE</p>
      <p>
        <i class="fa fa-star"></i> 2.9 | <i class="fa fa-comment"></i> 2 | <i class="fa fa-book"></i>
 world
      </p>
      <p>
        "This is the first sentence of the article."
      </p>
    </div></a>
  </div>
 
  <div class="col-md-4" style="height:350px;margin:0;background:url('assets/img/travel-mountain-tint.jpg') no-repeat;background-size:cover;color:white;">
    <a href="article.jsp"><div class="art-pane">
      <h2 style="text-transform:uppercase;">article title</h2>
      <p><small>from</small> SOURCE</p>
      <p>
        <i class="fa fa-star"></i> 3.6 | <i class="fa fa-comment"></i> 14 | <i class="fa fa-book"></i>
 travel
      </p>
      <p>
        "This is the first sentence of the article."
      </p>
    </div></a>
  </div>
</div>
<!-- End Row 3 -->
</div>
<!-- End Main Body -->

<!-- jQuery and Bootstrap links - do not delete! -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->

</body>
</html>

