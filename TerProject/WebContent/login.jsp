<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
		
    <title>NetFlox</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <!-- Font Awesome -->
    <link href="css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="css/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="css/custom.min.css" rel="stylesheet">
    
    
    	<style type="text/css">
	.error{
		color:red;
	}
	
	body{
	background-color:red;
	background-image:url(images/back.jpg);
	}
	
	</style>
  </head>

  <body class="login" background="back.jpg">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
        <center><h1><span class='logo_netflox'><i class="fa fa-video-camera"></i></span> NetFlox</h1></center>
          <section class="login_content">
            <form method="POST" action="ConnexionServlet">
              <h1>Connexion Client</h1>
             
              
              <c:if test="${erreur!=null}"> <div class="alert alert-danger" role="alert"> ${erreur}  </div></c:if>
               <c:if test="${inscription!=null}"><div class="alert alert-info" role="alert"> ${inscription}  </div></c:if>
              <div>
                <input type="text" name="email" class="form-control" placeholder="pseudo" required="" />
              </div>
              <div>
                <input type="password" name="password" class="form-control" placeholder="mot de passe" required="" />
              </div>
              <div>
                <button type="submit"  class="btn btn-primary">connecter</button>
                <a class="reset_pass" href="#">Mot de passe perdu?</a>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">Nouveau sur le site?
                  <a href="#signup" class="to_register"> Créer un compte </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  
                  <p>©NetFlox</p>
                </div>
              </div>
            </form>
          </section>
        </div>

        <div id="register" class="animate form registration_form">
         
         <center><h1><span class='logo_netflox'><i class="fa fa-video-camera"></i></span> NetFlox</h1></center>
          <section class="login_content">
            <form action="InscriptionClientServlet" method="POST" >
              <h1>Création compte</h1>
              <div>
                <input type="text" name="nom" class="form-control" placeholder="nom" required="" />
              </div>
              
              <div>
                <input type="text" name="prenom"  class="form-control" placeholder="prenom" required="" />
              </div>

              <div>
                <input type="email" name="email"  class="form-control" placeholder="Email" required="" />
              </div>
              <div>
                <input type="password" name="password"  class="form-control" placeholder="mot de passe" required="" />
              </div>
              
              <div>
                <input type="password" name="password2"  class="form-control" placeholder="repeter le mot de passe" required="" />
              </div>
              
              <div>
                <input type="text" name="tel"  class="form-control" placeholder="Tel" required="" />
              </div>
              
              <div>
                <button class="btn btn-primary" href="index.html">Soumettre</button>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">Déjà membre?
                  <a href="#signin" class="to_register"> se connecter </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <p>©NetFlox</p>
                </div>
              </div>
            </form>
          </section>
        </div>
      </div>
    </div>
     <br/><br/><br/><br/>
  </body>
</html>
