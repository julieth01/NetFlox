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
              <a href="accueil.jsp" class="site_title"><span class='logo_netflox'><i class="fa fa-video-camera"></i></span> <span>NetFlox Admin.</span></a>
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
         
            <div class="page-title">
              <div class="title_left">
                <h3><i class="fa fa-gear"/> </i> Réglage des données paramètres</h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  
                </div>
              </div>
            </div>
            <div class="clearfix"></div> 
          
            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Liste des catégories de vidéo <small></small></h2>
                  
                     
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  <br />
                  
                      <button class="btn btn-success" data-toggle="modal" data-target="#myModal"> <i class="fa fa-plus"></i> Ajouter</button>
                      
                      <c:set var="count" value="0" scope="page" />
                      
                      <c:choose>
                      	<c:when test="${! empty listCategorie}">
                      	 <table id="tableCategorie" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>id</th>
                          <th>Libellé de la catégorie</th>
                          <th>Action</th>
                          
                        </tr>
                      </thead>
                      <tbody>
                      		 <c:forEach items="${listCategorie}" var="categorie">
                      			<tr>
                      			<c:set var="count" value="${count + 1}" scope="page"/>
			                          <td><c:out value="${count}"></c:out></td>
			                          <td><c:out value="${categorie.idCategorie}"></c:out> </td>
				                      <td><c:out value="${categorie.libelleCategorie}"></c:out></td> 
				                      
				                      <td><font color="red" ><a class="btn btn-success" href="CategorieServlet?update=true&idCategorie=${categorie.idCategorie}"><i class="fa fa-pencil"></i> Modif</a><a class="btn btn-danger" href="GestionCategorieServlet?supp=true&idCategorie=${categorie.idCategorie}"> <i class="fa fa-trash"></i> Supp</a></font> </td>
                       		    </tr>
                       		    
                     		 </c:forEach>
        			    
                      </tbody>
                    </table>
                      	
                      	</c:when>
                      	
                      	<c:otherwise>
                      		<h1>Aucune catégorie retrouvée </h1>
                      	</c:otherwise>
                      
               </c:choose>
                     
                        
                     
                   
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
    
    
     <!--Modal -->
    
    
      <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <h3>Ajouter une catégorie </h3>
          
          
        </div>
        <div class="modal-body">
        
          <form method="POST" action="GestionCategorieServlet?action=insert" class="form-horizontal form-label-left"> 
          	        <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Libelle Categorie<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" name="libelleCategorie"  id="first-name" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div> 
                      
                      <br>
                      <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                          <button href="CategorieServlet" class="btn btn-danger" type="button" data-dismiss="modal"> <i class="fa fa-close"></i> Annuler</button>
				
                          <button type="submit" class="btn btn-success"> <i class="fa fa-check"></i> Ajouter</button>
                        </div>
                      </div>         
          </form>
          
        </div>
        <div class="modal-footer">
          
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
    <!-- Custom Theme Scripts -->
    <script src="js/custom.min.js"></script>
    
	<script type="text/javascript">
	$(document).ready(function() {
	    $('#tableCategorie').DataTable();
	} );
	</script>
	
	
	
	</br></br></br></br></br>
  </body>
</html>