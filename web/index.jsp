<%-- 
    Document   : index
    Created on : Dec 9, 2015, 9:11:06 PM
    Author     : francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="icon" type="image/png" href="assets/img/favicon.ico">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>Welcome</title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />
        
        <link href="assets/css/bootstrap.css" rel="stylesheet" />
        <link href="assets/css/landing-page.css" rel="stylesheet"/>
        
        <!--     Fonts and icons     -->
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400,300' rel='stylesheet' type='text/css'>
        <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
        
    </head>
    <body class="landing-page landing-page1">
        <nav class="navbar navbar-transparent navbar-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button id="menu-toggle" type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar bar1"></span>
                    <span class="icon-bar bar2"></span>
                    <span class="icon-bar bar3"></span>
                    </button>
                    <a href="#">
                        <div class="logo-container">
                            <div class="logo">
                                <img src="assets/img/icon.jpg" alt="Newsstand Logo">
                            </div>
                            <div class="brand" style="color:black">
                                The Newsstand
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </nav>
        <div class="wrapper">
            <div class="parallax filter-gradient" data-color="blue">
                <div class="parallax-background">
                    <img class="parallax-background-image" src="assets/img/coffee2.jpeg">
                </div>
                <div class= "container">
                    <div class="row">
                        <div class="col-md-9">
                            <div class="description" style="color:black">
                                <h1>The Newsstand</h1>
                                <h4 style="text-shadow:none">A free online news-reading app. Get your favorite articles here.</h4>
                                <em><h5 style="text-shadow:none">Stories made fresh daily</h5></em>
                            </div>
                            <div class="buttons" style="margin-top:0;">
                                <a href="signup.jsp"><button class="btn btn-primary btn-fill">
                                Sign Up
                                </button></a>
                                <a href="login.jsp"><button class="btn btn-fill btn-info">
                                Login
                                </button></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="section section-gray section-clients">
                <div class="container text-center">
                    <h4 class="header-text">Read your favorites</h4>
                    <p>
                        We pull news articles from the most popular news organizations. Articles are always up-to-date and catered to your preferences. These are just several of our sources.<br>
                    </p>
                    <div class="logos">
                        <ul class="list-unstyled">
                            <li ><img src="assets/img/logos/cnn.png"/></li>
                            <li ><img src="assets/img/logos/nyt.png"/></li>
                            <li ><img src="assets/img/logos/fox.png"/></li>
                            <li ><img src="assets/img/logos/bbc.png"/></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="section section-presentation">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="description">
                                <h4 class="header-text">It's simple</h4>
                                <p>The Newsstand congregates articles from many popular news organizations like CNN, Fox News, or The Onion, and organizes them in a simple display. We use a sophisticated sorting algorithm that will help users always find the type of news they are looking for.</p>
                                <p>You can also rate and comment on the articles you read to help each other sift through the ocean of webpages to find the best content available.
                                </p>
                                <p>Truly a newsworthy app.</p>
                            </div>
                        </div>
                        <div class="col-md-5 col-md-offset-1 hidden-xs">
                            <img src="assets/img/iphone.png"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="section section-features">
                <div class="container">
                    <h4 class="header-text text-center">Features</h4>
                    <div class="row">
                        <div class="col-md-4">
                            <div class="card card-blue">
                                <div class="icon">
                                    <i class="pe-7s-way"></i>
                                </div>
                                <div class="text">
                                    <h4>Browse by Genre</h4>
                                    <p>Articles are sorted by genre tags so you can keep up with news in your field of interest. You will always find what you're looking for.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card card-blue">
                                <div class="icon">
                                    <i class="pe-7s-user"></i>
                                </div>
                                <h4>Rate and Review</h4>
                                <p>Voice your opinion! Rate articles and leave comments in our app. Read other user's take on what you've read.</p>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card card-blue">
                                <div class="icon">
                                    <i class="pe-7s-like2"></i>
                                </div>
                                <h4>Save Your Favorites</h4>
                                <p>"Favorite" an article so you can return to it later. It's as simple as a click of a button.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="section section-gray section-testimonial">
                <div class="container">
                    <h4 class="header-text text-center">What people think</h4>
                    <div id="carousel-example-generic" class="carousel fade" data-ride="carousel">
                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <div class="item">
                                <div class="mask">
                                    <img src="assets/img/faces/face-4.jpg">
                                </div>
                                <div class="carousel-testimonial-caption">
                                    <p>Jay Z, Producer</p>
                                    <h3>"I use this app all the time!"</h3>
                                </div>
                            </div>
                            <div class="item active">
                                <div class="mask">
                                    <img src="assets/img/faces/face-3.jpg">
                                </div>
                                <div class="carousel-testimonial-caption">
                                    <p>Drake, Artist</p>
                                    <h3>"Hotter than Hotline Bling."</h3>
                                </div>
                            </div>
                            <div class="item">
                                <div class="mask">
                                    <img src="assets/img/faces/face-2.jpg">
                                </div>
                                <div class="carousel-testimonial-caption">
                                    <p>Rick Ross, Musician</p>
                                    <h3>"This beats the competition."</h3>
                                </div>
                            </div>
                            <div class="item">
                                <div class="mask">
                                    <img src="assets/img/faces/face-3.jpg">
                                </div>
                                <div class="carousel-testimonial-caption">
                                    <p>Drake, Artist</p>
                                    <h3>"I want to reiterate how much I like this app."</h3>
                                </div>
                            </div>
                        </div>
                        <ol class="carousel-indicators carousel-indicators-blue">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                        </ol>
                    </div>
                </div>
            </div>
            <footer class="footer">
                <div class="container">
                    <div class="copyright">
                        &copy; 2015 <a href="#">Team Newsstand</a>
                    </div>
                </div>
            </footer>
        </div>
        
    </body>
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="assets/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
    <script src="assets/js/bootstrap.js" type="text/javascript"></script>
    <script src="assets/js/awesome-landing-page.js" type="text/javascript"></script>
</html>