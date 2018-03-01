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
              <a href="index.jsp" class="site_title"><span class='logo_netflox'><i class="fa fa-video-camera"></i></span> <span>NetFlox Admin.</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
           
            <!-- /menu profile quick info -->

            <br />

            <!-- Inclusion du Menu d'administration -->
            
             <%@include file="menuAdministration.jsp" %>

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
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
         <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-film"></i> Gestion des vidéos</h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  
                </div>
              </div>
            </div>
            <div class="clearfix"></div>
            <div class="row">
              
                <div class="x_panel">
                  <div class="x_title">
                    <h2> Ajouter une vidéo<small></small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                    </ul>
                    <div class="clearfix"></div>
                  </div>
					
      
                    <div id="wizard" class="form_wizard wizard_horizontal">
                      <ul class="wizard_steps">
                        <li>
                          <a href="#step-1">
                            <span class="step_no">1</span>
                            <span class="step_descr">
                              Etape 1<br />
                             <small>Informations sur la vidéo</small>
                             </span>
                          </a>
                        </li>
                        <li>
                          <a href="#step-2">
                            <span class="step_no">2</span>
                            <span class="step_descr">
                            Etape 2<br />
                            <small>Infos sur les participants</small>
                            </span>
                          </a>
                        </li>
                        <li>
                          <a href="#step-3">
                            <span class="step_no">3</span>
                            <span class="step_descr">
                            Etape 3<br />
                            <small>Upload des fichiers</small>
                            </span>
                          </a>
                        </li>
                      
                      </ul>
                      
                      
                      <form class="form-horizontal form-label-left" method="post" action="UploadVideoServlet" enctype="multipart/form-data">
                      
                      <div id="step-1">

                          <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Titre
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                              <input type="text" name="titre" id="titre" required="required" class="form-control col-md-7 col-xs-12">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Durée <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                              <input type="text" id="duree" name="duree" required="required" class="form-control col-md-7 col-xs-12">
                            </div>
                          </div>
                          <div class="form-group">
                            <label for="date" class="control-label col-md-3 col-sm-3 col-xs-12">Date de sortie</label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                              <input id="date" class="form-control col-md-7 col-xs-12" type="Date" name="dateSortie">
                            </div>
                          </div>
                         
                          
                          <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Année de production
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                              <input id="anneeProduction" class="date-picker form-control col-md-7 col-xs-12" name="anneeProduction" required="required" type="text">
                            </div>
                          </div>
                          
                           <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Prix de vente
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                             <input id="prixVente" class="date-picker form-control col-md-7 col-xs-12" name="prixVente" required="required" type="text">
                            </div>
                          </div>
						
					<div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Resumé
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <textarea name="resume" class="date-picker form-control col-md-7 col-xs-12" required="required" cols="4" rows="6" ></textarea>
                        </div>
                      </div>
                       
                       
                       
                       <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Catégorie
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <select id="heard" name="idCategorie" class="form-control" required>
                          <option value="0">Selectionner</option>
                          <c:forEach items="${listCategorie}" var="categorie">
                          	<option value="${categorie.getIdCategorie()}"> <c:out value="${categorie.getLibelleCategorie()}"/> </option>
                          	
                          </c:forEach>
                          </select>
                          
                        </div>
                      </div>
                       
                          <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Genre
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <select id="heard" name="idGenre" class="form-control" required>
                            <option value="">Selectionner</option>
                           
                           <c:forEach items="${listGenre}" var="genre">
                          	<option value="${genre.idGenre}"> <c:out value="${genre.libelleGenre}"/> </option>
                          	
                          </c:forEach>
                          
                          </select>
                        </div>
                      </div>
                          
							
                      </div>
                      
                      <div id="step-2">
                        
                          <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Réalisateur
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <select id="heard" name="realisateur" class="form-control">
                            <option value="">Selectionner</option>
                              <c:forEach items="${listParticipant}" var="realisateur">
                          	<option value="${realisateur.idParticipant}"> <c:out value="${realisateur.nomParticipant}"/> <c:out value="${realisateur.prenomParticipant}"/> </option>
                          	
                          </c:forEach>
                          
                          </select>
                        </div>
                      </div>
                        
                        
                        <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Acteur principal
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <select id="heard" name="acteurPrincipal" class="form-control">
                            <option value="">Selectionner</option>
                               <c:forEach items="${listParticipant}" var="realisateur">
                          	<option value="${realisateur.idParticipant}"> <c:out value="${realisateur.nomParticipant}"/> <c:out value="${realisateur.prenomParticipant}"/> </option>
                          	
                          </c:forEach>                 
                          </select>
                        </div>
                        </div>
                        
                        
                        
                         <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Ajouter un acteur
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <select id="heard" name="acteurSecondaire" class="form-control">
                            <option value="">Selectionner</option>
                            <c:forEach items="${listParticipant}" var="realisateur">
                          	<option value="${realisateur.idParticipant}"> <c:out value="${realisateur.nomParticipant}"/> <c:out value="${realisateur.prenomParticipant}"/> </option>
                          	
                          </c:forEach>
                          
                          </select>
                        </div>
                        </div>
                        
                        
                         <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Son rôle
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                              <input id="roleActeurSecondaire" class="date-picker form-control col-md-7 col-xs-12" name="role" type="text">
                            </div>
                          </div>
                       
                          
                    </div>
                      

                      <div id="step-3">
                        
                        
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Image Poster 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="date-picker form-control col-md-7 col-xs-12" name="fichier1"  type="file">
                        </div>
                      </div>
                      
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Charger la video 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="date-picker form-control col-md-7 col-xs-12" name="fichier2" type="file">
                        </div>
                      </div>

							<center><button type="submit"  class="btn btn-primary"> <i class="fa fa-check"></i> Enregistrer</button></center>
                      </div>
   						</form>	
                    </div>
		  
                
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