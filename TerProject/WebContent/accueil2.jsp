<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Font Awesome -->
    <link href="css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="css/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="vendors/iCheck/flat/green.css" rel="stylesheet">
    <!-- bootstrap-wysiwyg -->
    <link href="css/prettify.min.css" rel="stylesheet">
    <!-- Select2 -->
    <link href="vendors/select2/dist/css/select2.min.css" rel="stylesheet">
    <!-- Switchery -->
    <link href="vendors/switchery/dist/switchery.min.css" rel="stylesheet">
    <!-- starrr -->
    <link href="vendors/starrr/dist/starrr.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="css/daterangepicker.css" rel="stylesheet">
	
	<!-- bootstrap-daterangepicker -->
    <link href="css/dataTable.bootstrap.css" rel="stylesheet">
	
    <!-- Custom Theme Style -->
    <link href="css/custom.min.css" rel="stylesheet">
    
    <style type="text/css">
    	.logo_netflox{
    	color:#B22222;
    	}
    </style>
    
<title>NetFlox</title>
</head>


<body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.jsp" class="site_title"><span class='logo_netflox'><i class="fa fa-video-camera"></i></span> <span>NetFlox</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
           
            <!-- /menu profile quick info -->

            <br />

            <!-- Inclusion du Menu d'administration -->
            
             <%@include file="menuClient.jsp" %>

            <!-- /sidebar menu -->



            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Deconnexion" href="DeconnexionServlet">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>
					
              <ul class="nav navbar-nav navbar-right">
             
             <c:choose>
             	<c:when test="${empty client}">
             	
             	    <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal"><i class="fa fa-user"></i> S'identifier</button>
                    <span class=" fa fa-angle-down"></span>
                  </a>
                 
                </li>
            </c:when>
             	
             	<c:otherwise>
             	 <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="images/img.jpg" alt=""><c:out value="${client.prenomClient}" /> <c:out value="${client.nomClient}" />
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="javascript:;"> Profil</a></li>
                    <li>
                    </li>
                    
                    <li><a href="DeconnexionServlet"><i class="fa fa-sign-out pull-right"></i> Deconnexion</a></li>
                  </ul>
                </li>

              </ul>
             	
             	</c:otherwise>
             
             </c:choose>

            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
         <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-film"></i> Bienvenue sur NetFlox (Streaming direct)</h3>
              </div>
				  <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Rechercher...">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Ok</button>
                    </span>
                  </div>
                </div>
              </div>
              
            </div>
            <div class="clearfix"></div>
            <div class="row">
              
                <div class="x_panel">
                  <div class="x_title">
                    <h2> <small></small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                    </ul>
                    <div class="clearfix"></div>
                  </div>
			
	
	    
				                      <c:choose>
                      	<c:when test="${! empty listVideo}">
                      	 
                      	 <div class="row">
                      		 <c:forEach items="${listVideo}" var="video">
						
                      				<div class="col-md-2">
                      				<img alt="Pas de poster" width="180px" height="250px" src="uploads/${video.imagePoster}">
                      				<br><br><b>Titre:</b> ${video.getTitre()}<br><b>Cat�gorie:</b> ${video.getIdCategorie().getLibelleCategorie()}<br>
                      				<b>Genre:</b> ${video.getIdGenre().getLibelleGenre()}
                      				<br><a class="btn btn-info" href="VisualisationServlet?action=visualiser&idVideo=${video.idVideo}"> <i class="fa fa-film"></i> voir la vid�o</a> 
                      				</div>
                      				
                     		 </c:forEach>
						</div>
                      	</c:when>
                      	
                      	<c:otherwise>
                      		<h1>Aucune video retrouv�e</h1>
                      	</c:otherwise>
                      
               </c:choose>
                     
	



























				
				
				</div><!--Fin row  -->   
		  </div>
		  </div>
		  </div>
		  
                
         </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>
    
    
    
    
    
    
    
        
    
   
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <h3>Connexion � votre espace client </h3>
         
          
        </div>
        <div class="modal-body">
        
          <form method="POST" action="ConnexionServlet" class="form-horizontal form-label-left"> 
          
           <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name"> Username<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" name="email"  id="first-name" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
            </div> 
            
            
           <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name"> Password<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="password" name="email"  id="first-name" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
            </div> 
           
           		<br>
                      <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                          <button type="submit" class="btn btn-success"> <i class="fa fa-check"></i> Connexion</button>
                          <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModalInscription"> <i class="fa fa-disk"></i> S'inscrire</button>

                        </div>
                      </div>

          	
          		
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
        <h3>Inscription du client</h3>
        
          
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
  

  
   
   
   
    
    
    
    
    

    <!-- jQuery -->
    <script src="vendors/jquery/dist/jquery.min.js"></script>
    
    <!-- jQuery -->
    <script src="js/dataTable.min.js"></script>
    
    <!-- jQuery -->
    <script src="js/dataTable.bootstrap.min.js"></script>
    
    <!-- Bootstrap -->
    <script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="../vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../vendors/nprogress/nprogress.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="../vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="../vendors/iCheck/icheck.min.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="../vendors/moment/min/moment.min.js"></script>
    <script src="../vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
    <!-- bootstrap-wysiwyg -->
    <script src="../vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
    <script src="../vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
    <script src="vendors/google-code-prettify/src/prettify.js"></script>
    <!-- jQuery Tags Input -->
    <script src="../vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>
    <!-- Switchery -->
    <script src="vendors/switchery/dist/switchery.min.js"></script>
    <!-- Select2 -->
    <script src="vendors/select2/dist/js/select2.full.min.js"></script>
    <!-- Parsley -->
    <script src="../vendors/parsleyjs/dist/parsley.min.js"></script>
    <!-- Autosize -->
    <script src="../vendors/autosize/dist/autosize.min.js"></script>
    <!-- jQuery autocomplete -->
    <script src="../vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
    <!-- starrr -->
    <script src="vendors/starrr/dist/starrr.js"></script>
    
    <script src="vendors/jQuery-Smart-Wizard/js/jquery.smartWizard.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="js/custom.min.js"></script>
    


  </body>
</html>