<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>index</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome/css/font-awesome.css">
<style type="text/css">
	.title{
		margin-top:350px;
		text-align:center;
	}
		.logo_netflox{
	color:#B22222;}
</style>
</head>
<body> 
  
 <div class='title'><h1><span class='logo_netflox'><i class="fa fa-video-camera"></i></span> NetFlox...</h1> <i>Streaming direct</i> </div>
   
   
 <center>Client connecté:<br/>
Nom:<c:out value="${client.nomClient}"/>
Prenom:<c:out value="${client.prenomClient}"/>
</center>
   
</body>
</html>