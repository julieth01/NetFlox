<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NetFlox</title>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">
	<link href="css/carousel.css" rel="stylesheet">
    <title>Carousel Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="css/Template/bootstrap.min.css" rel="stylesheet">
     <link href="css/font-awesome/css/font-awesome.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="vendor/bootstrap/dist/carousel.css" rel="stylesheet">
    
    <style type="text/css">
    	.logo_netflox{
	color:#B22222;}

    
    </style>
    
    
</head>
<body>



    <header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="#"><span class="logo_netflox"> <i class="fa fa-video-camera"></i></span> NetFlox</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <a class="nav-link" href="#">Films<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Series</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Documentaires</a>
            </li>
          </ul>
          
          <div class="identifier">
          <button class="btn btn-danger" type="submit">S'identifier</button><br/>
          </div>
          <form class="form-inline mt-2 mt-md-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Rechercher" aria-label="Rechercher">
            <button class="btn btn-success my-2 my-sm-0" type="submit">Rechercher</button>
          </form>
        </div>
      </nav>
    </header>
     
      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img class="first-slide" src="images/Back2.jpg" alt="First slide">
            <div class="container">
              <div class="carousel-caption text-left">
                <h1>Film à la une</h1>
                <p>Test</p>
                <p><a class="btn btn-lg btn-outline-primary" href="#" role="button">Suivre</a></p>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <img class="second-slide" src="images/Back2.jpg" alt="Second slide">
            <div class="container">
              <div class="carousel-caption">
                <h1>Another example headline.</h1>
                <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <img class="third-slide" src="images/Back2.jpg" alt="Third slide">
            <div class="container">
              <div class="carousel-caption text-right">
                <h1>One more for good measure.</h1>
                <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
              </div>
            </div>
          </div>
        </div>
        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>	

	<div class="container marketing">
	<div><h3>Films en streaming</h3> </div> 
	<hr color="orange"/>
	
    <div class="row">
    <div class="col-lg-9">
    
    <div class="row">
          <div class="col-lg-3">
           <img src="images/image1.jpg" />
          </div><!-- /.col-lg-3 -->
          <div class="col-lg-3">
            <img src="images/mentaliste.jpg" />
          </div><!-- /.col-lg-3 -->
          <div class="col-lg-3">
            <img src="images/life_sentence_poster.jpg" />
          </div><!-- /.col-lg-4 -->
          
           <div class="col-lg-3">
            <img src="images/serie dynasty.jpg" />
          </div><!-- /.col-lg-3 -->
          </div><!-- /.col-lg-3 -->
 
   	
   	  <br/>
          <div class="row">
          <div class="col-lg-3" backgroud="">
           <img src="images/serie the magicians.jpg" />
          </div><!-- /.col-lg-3 -->
          <div class="col-lg-3">
            <img src="images/serie the exorcist.jpg" />
          </div><!-- /.col-lg-3 -->
          <div class="col-lg-3">
            <img src="images/serie blacklist.jpg" />
          </div><!-- /.col-lg-4 -->
          
           <div class="col-lg-3">
            <img src="images/super naturel serie.jpg" />
          </div><!-- /.col-lg-4 -->
          
          
          </div><!-- /.col-lg-3 -->

     </div>
     
     <div class="col-lg-3">
     
     Le dépliant
     
     
     </div>
     
     
     
          </div><!-- /.row -->
      
</div>




<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    
<script src="vendor/dist/js/bootstrap.min.js"></script>
</body>
</html>