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
   
	  

    <!-- Bootstrap core CSS -->
    <link href="css/Template/bootstrap.min.css" rel="stylesheet">
     <link href="css/font-awesome/css/font-awesome.css" rel="stylesheet">
    <!-- Custom styles for this template -->
   
    
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


	<br><br><br>
	<div class="container marketing">
	<div><h3><i class="fa fa-users"></i> Espace client</h3> </div> 
	<hr color="orange"/>
	
    <div class="row">
    <div class="col-lg-9">



<nav>
  <div class="nav nav-tabs" id="nav-tab" role="tablist">
    <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Achats</a>
    <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Locations</a>
    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">Profil</a>
  </div>
</nav>

<div class="tab-content" id="nav-tabContent">
  <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab"> 
  
  <br> <h6>La liste de mes videos achet�es</h6><br>
   <div class="row">
          <div class="col-lg-3" backgroud="">
           <a href="VisualisationServlet?videoId=0"><img src="images/serie the magicians.jpg" /></a>
          </div><!-- /.col-lg-3 -->
          <div class="col-lg-3">
          <a href="VisualisationServlet?videoId=0"> <img src="images/serie the exorcist.jpg" /></a>
          </div><!-- /.col-lg-3 -->
          <div class="col-lg-3">
           <a href="VisualisationServlet?videoId=0"> <img src="images/serie blacklist.jpg" /></a>
          </div><!-- /.col-lg-4 -->
          
           <div class="col-lg-3">
           <a href="VisualisationServlet?videoId=0"> <img src="images/super naturel serie.jpg" /> <a href="VisualisationServlet?videoId=0">
          </div><!-- /.col-lg-4 -->
          
          
          </div><!-- /.col-lg-3 -->
  
  
  
  </div>
  <!-- Fin fenetre des achats   -->
 
 
 
 
  <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab"><br> Mes locations </div>
  
  
  
  <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab"><br> Mon profil</div>

</div>











       
	

     </div>
     
     <div class="col-lg-3">
     
     <h5>Acc�s rapide � nos films</h5>
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
      

<script src="vendors/jquery/dist/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>