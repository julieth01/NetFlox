<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
          
          <c:choose>
          	<c:when test="${! empty client}"><button type="button" class="btn btn-danger"><a href="DeconnexionServlet" text-decoration="none" ><i class="fa fa-sign-out"></i> Deconnexion</a></button> </c:when>
          	<c:otherwise><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal"><i class="fa fa-user"></i> S'identifier</button></c:otherwise>
          </c:choose>

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
                <p><a class="btn btn-lg btn-outline-danger" href="#" role="button">Suivre</a></p>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <img class="second-slide" src="images/horreur2.jpg" alt="Second slide">
            <div class="container">
              <div class="carousel-caption">
               
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <img class="third-slide" src="images/image2.jpg" alt="Third slide">
            <div class="container">
              <div class="carousel-caption text-right">
                
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
           <a href="#"><img src="images/image1.jpg" /></a>
          </div><!-- /.col-lg-3 -->
          <div class="col-lg-3">
            <img src="images/mentaliste.jpg" />
          </div><!-- /.col-lg-3 -->
          <div class="col-lg-3">
            <img src="images/life_sentence_poster.jpg" />
          </div><!-- /.col-lg-4 -->
          
           <div class="col-lg-3">
            <img src="images/serie dynasty.jpg"/>
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
     
     <h5>Accès rapide à nos films</h5>
     <hr color="orange">
     
     <h5>Menu</h5>
     <hr/>
  	 <a href="#"> Films</a>
     <hr/>
     <a href="#"> Documentaires</a>
     <hr/>
    <a href="#"> Series</a>
     <hr/>
     <h4>Genres</h4>
     <hr/>

     
     
     </div>
     
     
     
          </div><!-- /.row -->
      
</div>


  
  <!-- Trigger the modal with a button -->
 

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <h5>Connexion à votre espace client </h3>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          
        </div>
        <div class="modal-body">
        
          <form method="POST" action="ConnexionServlet"> 
          	<input type="text" name="email" class="form-control" placeholder="Username" aria-describedby="basic-addon2">
          	<input type="password" name="password" class="form-control" placeholder="Password" aria-describedby="basic-addon2"><br/>
          		<button class="btn btn-lg btn-outline-danger"><i class="fa fa-lock"></i> Connexion</button> 
          		<button type="button" class="btn btn-lg btn-outline-danger" data-toggle="modal" data-target="#myModalInscription"> S'inscrire</button>
          </form>
          
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
        </div>
      </div>
      
    </div>
  </div>
  
  
    <!-- Modal -->
  <div class="modal fade" id="myModalInscription" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
        <h5>Inscription du client</h5>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
          
        </div>
        <div class="modal-body">

  		<form method="POST" action="InscriptionClientServlet"> 
          	<input type="text" class="form-control" name="nom" placeholder="Nom" aria-describedby="basic-addon2"><br/>
          	
          	<input type="text" class="form-control" name="prenom" placeholder="Prenom" aria-describedby="basic-addon2"><br/>
          	<input type="text" class="form-control" name="email" placeholder="Email" aria-describedby="basic-addon2"><br/>
          	<input type="password" class="form-control" name="password" placeholder="Mot de passe" aria-describedby="basic-addon2"><br/>
          	<input type="password" class="form-control" placeholder="Confirmation mot de passe" aria-describedby="basic-addon2"><br/>
          	<input type="text" class="form-control" name="tel" placeholder="Tel" aria-describedby="basic-addon2"><br/>
          	
          	
          	<button class="btn btn-lg btn-outline-danger"><i class="fa fa-save"></i> S'inscrire</button> 
          	<button type="button" class="btn btn-lg btn-outline-default" data-dismiss="modal"><i class="fa fa-close"></i> Annuler</button>
          	
          </form>   
                   
        </div>
        <div class="modal-footer">
          <center>...</center>
        </div>
      </div>
      
    </div>
  </div>
  

  







<script src="vendors/jquery/dist/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>