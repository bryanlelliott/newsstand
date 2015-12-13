<%-- 
    Document   : article
    Created on : Dec 9, 2015, 9:22:12 PM
    Author     : francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set name="theme" value="'simple'" scope="page" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <link rel="icon" type="image/png" href="assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Article</title>

<!-- Bootstrap CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css" media="screen">

<!-- Cutstom CSS -->
<link href="assets/css/custom.css" rel="stylesheet" type="text/css" media="screen">

<!-- Font Awesome -->
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

<style>
hr {
  border-color: black;
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
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="background-color:black; color:white">
              <h5>
                  <%
            try {
               String realName = (String)session.getAttribute("realName");
               out.println(realName);
             } catch (Exception jsp){
                out.println("NULL");
            }
    %><span class="caret"></span>
              </h5></a>
          <ul class="dropdown-menu">
            <li><a href="profile.jsp">Profile</a></li>
            <%
            try {
               String userType = (String) session.getAttribute("userType");
               if (userType.equals("admin"))
                  out.println("<li><a href=\"admin.jsp\">Admin Panel</a></li>");
             } catch (Exception jsp){
                out.println("User is not logged in");
            }
            %>
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
  <div class="row" style="margin:0;background-color:black">
    <div class="col-md-10" style="padding: 0 15px 0 15px;background-color:white">
      <div class="text-left">
        <div class="pull-right" style="margin-top:18px">
          <span style="color:gray"><i class="fa fa-star"></i> 3.4 | 
            <i class="fa fa-eye"></i> 131 | 
            <i class="fa fa-user"></i> CNN | 
            <i class="fa fa-book"></i> tech | 
            <i class="fa fa-calendar"></i> 11/8/2015</span>
        </div>
        <h1><i class="fa fa-laptop" style="color:#54b2ba;margin: 0 0.5em"></i> Facebook can now hide your exes</h1>
      </div>
      <hr>
      <div class="row" style="">
        
        <blockquote style="margin-bottom:0">
            <p>"You just broke up with your girlfriend of a year. You've spent the last three days sulking on your sofa, too devastated to shower or eat anything but string cheese..."</p>
            <footer><cite title="Source Title">CNN</cite></footer>
        </blockquote>
        <div class="text-center" style="color:black">
          <a href="http://money.cnn.com/2015/11/19/technology/facebook-broken-heart/"><span style="border: solid black 1px; padding:4px">Read Article</span></a>
        </div>
        <br>
        <div class="row" style="padding:2em 0;background-color:gray;color:white">
        <div class="col-md-6 text-center" style="padding: 1em 0">
            <h4>RATE THIS ARTICLE</h4>

                <div id="stars" class="starrr"></div>
                You gave a rating of <span id="count">0</span> star(s)
        </div>
        <div class="col-md-6 text-center">
            <h4>YOUR COMMENT</h4>
            <div class="input-group" style="padding: 0 2em">
              <textarea class="form-control custom-control" rows="3" style="resize:none;"></textarea> <span class="input-group-addon btn btn-primary">Submit 
              </span>
            </div>
          </div>
        </div>
      </div>
          <div class="row" style="background-color:black; color:white">
            <div class="col-md-4 col-md-offset-1" style="border: solid 1px black;overflow:hidden;padding: 1em 0">
              <h4 style="text-align:center">ARTICLE INFO</h4>
              <hr style="border-color:white">
              <p><em style="color:yellow">Article Name:</em> Facebook can now hide your exes</p>
              <p><em style="color:yellow">Source:</em> CNN</p>
              <p><em style="color:yellow">Publication:</em> 11/8/2015</p>
              <p><em style="color:yellow">Tags:</em> Tech, Living</p>
              <p><em style="color:yellow">Views:</em> 131</p>
              <p><em style="color:yellow">Average Rating:</em> 3.4/5</p>
              <hr>
              <!-- Bottom Rating Area
              <div class="text-center">
                <h4>RATE THIS ARTICLE</h4>
                  <div id="stars" class="starrr"></div>
                  You gave a rating of <span id="count">0</span> star(s)
              </div>
              -->
            </div>
            <div class="col-md-4 col-md-offset-2" style="border: solid 1px black;padding: 1em 0">
              <h4 style="text-align:center">RECENT COMMENTS</h4>
              <hr style="border-color:white">
              <p><em style="color:yellow">jeramypudding:</em> Great article</p>
              <p><em style="color:yellow">austinlee:</em> I don't like this article</p>
              <p><em style="color:yellow">thomasle:</em> How do you open this</p>
              <p><em style="color:yellow">bholmes:</em> I could really use this feature lol</p>
              <p><em style="color:yellow">helperhamburger:</em> How did I get here?</p>
              <p><em style="color:yellow">hamburgerhelper:</em> I'd like to read more articles like this one!</p>
              <hr>
              <!-- Bottom comment area
              <div class="text-center">
                <h4>YOUR COMMENT</h4>
                <div class="input-group">
                <textarea class="form-control custom-control" rows="3" style="resize:none"></textarea> <span class="input-group-addon btn btn-primary">Submit 
                </span>
                </div>
              </div> -->
            </div>
          </div>

          <!--
          <div class="text-center" style="">
          <a href="http://money.cnn.com/2015/11/19/technology/facebook-broken-heart/index.html"><span style="color:gray">read article</span></a>
          </div>-->
    </div>
    <div class="col-md-2" style="padding:0;background-color:black">
      <div class="list-group"; style="margin:0">
        <button type="button" class="list-group-item disabled" style="width:100%">MORE STORIES</button>
        <button type="button" class="list-group-item text-center" style="width:100%">Police worry protests may turn violent</button>
        <button type="button" class="list-group-item text-center" style="width:100%">Interim police chief in Ferguson resigning effective December 2</button>
        <button type="button" class="list-group-item text-center" style="width:100%">Little boy donates his piggy bank to vandalized mosque</button>
        <button type="button" class="list-group-item text-center" style="width:100%">NIH promises to retire all research chimps</button>
        <button type="button" class="list-group-item text-center" style="width:100%">Melbourne city workers save turtle stuck in plastic bag</button>
        <button type="button" class="list-group-item text-center" style="width:100%">Melbourne city workers save turtle stuck in plastic bag</button>
        <button type="button" class="list-group-item text-center" style="width:100%">Melbourne city workers save turtle stuck in plastic bag</button>
        <button type="button" class="list-group-item text-center" style="width:100%">Melbourne city workers save turtle stuck in plastic bag</button>
        <button type="button" class="list-group-item text-center" style="width:100%">Melbourne city workers save turtle stuck in plastic bag</button>
        <button type="button" class="list-group-item text-center" style="width:100%">Melbourne city workers save turtle stuck in plastic bag</button>
        <button type="button" class="list-group-item text-center" style="width:100%">Melbourne city workers save turtle stuck in plastic bag</button>
      </div>
    </div>

  </div>
</div>
<!-- End Main Body -->

<!-- jQuery and Bootstrap links - do not delete! -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script>
  var __slice = [].slice;

(function($, window) {
  var Starrr;

  Starrr = (function() {
    Starrr.prototype.defaults = {
      rating: void 0,
      numStars: 5,
      change: function(e, value) {}
    };

    function Starrr($el, options) {
      var i, _, _ref,
        _this = this;

      this.options = $.extend({}, this.defaults, options);
      this.$el = $el;
      _ref = this.defaults;
      for (i in _ref) {
        _ = _ref[i];
        if (this.$el.data(i) != null) {
          this.options[i] = this.$el.data(i);
        }
      }
      this.createStars();
      this.syncRating();
      this.$el.on('mouseover.starrr', 'span', function(e) {
        return _this.syncRating(_this.$el.find('span').index(e.currentTarget) + 1);
      });
      this.$el.on('mouseout.starrr', function() {
        return _this.syncRating();
      });
      this.$el.on('click.starrr', 'span', function(e) {
        return _this.setRating(_this.$el.find('span').index(e.currentTarget) + 1);
      });
      this.$el.on('starrr:change', this.options.change);
    }

    Starrr.prototype.createStars = function() {
      var _i, _ref, _results;

      _results = [];
      for (_i = 1, _ref = this.options.numStars; 1 <= _ref ? _i <= _ref : _i >= _ref; 1 <= _ref ? _i++ : _i--) {
        _results.push(this.$el.append("<span class='glyphicon .glyphicon-star-empty'></span>"));
      }
      return _results;
    };

    Starrr.prototype.setRating = function(rating) {
      if (this.options.rating === rating) {
        rating = void 0;
      }
      this.options.rating = rating;
      this.syncRating();
      return this.$el.trigger('starrr:change', rating);
    };

    Starrr.prototype.syncRating = function(rating) {
      var i, _i, _j, _ref;

      rating || (rating = this.options.rating);
      if (rating) {
        for (i = _i = 0, _ref = rating - 1; 0 <= _ref ? _i <= _ref : _i >= _ref; i = 0 <= _ref ? ++_i : --_i) {
          this.$el.find('span').eq(i).removeClass('glyphicon-star-empty').addClass('glyphicon-star');
        }
      }
      if (rating && rating < 5) {
        for (i = _j = rating; rating <= 4 ? _j <= 4 : _j >= 4; i = rating <= 4 ? ++_j : --_j) {
          this.$el.find('span').eq(i).removeClass('glyphicon-star').addClass('glyphicon-star-empty');
        }
      }
      if (!rating) {
        return this.$el.find('span').removeClass('glyphicon-star').addClass('glyphicon-star-empty');
      }
    };

    return Starrr;

  })();
  return $.fn.extend({
    starrr: function() {
      var args, option;

      option = arguments[0], args = 2 <= arguments.length ? __slice.call(arguments, 1) : [];
      return this.each(function() {
        var data;

        data = $(this).data('star-rating');
        if (!data) {
          $(this).data('star-rating', (data = new Starrr($(this), option)));
        }
        if (typeof option === 'string') {
          return data[option].apply(data, args);
        }
      });
    }
  });
})(window.jQuery, window);

$(function() {
  return $(".starrr").starrr();
});

$( document ).ready(function() {
      
  $('#stars').on('starrr:change', function(e, value){
    $('#count').html(value);
  });
});
</script>

</body>
</html>

