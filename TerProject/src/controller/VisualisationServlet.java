package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AbonnementModel;
import model.AchatModel;
import model.LocationModel;
import model.VideoModel;
import entities.Client;
import entities.Video;

/**
 * Servlet implementation class VisualisationServlet
 */
@WebServlet("/VisualisationServlet")
public class VisualisationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualisationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Recuperation de la variable de session
		Client client=new Client();
		client=(Client) request.getSession().getAttribute("client");
		
	
		
		//Verification de session, si elle n'existe pas on renvoie l'utilisateur vers la page de connexion
		if(client!=null){
	
	   String sIdVideo=(String) request.getParameter("idVideo");
	   
		boolean prenim;
		boolean achat;
		boolean location;
	    try {
	    	int idVideo=Integer.parseInt(sIdVideo);
	    	
	    	VideoModel videoModel=new VideoModel();
			
			Video video= videoModel.selectVideo(idVideo).get(0);
			
			System.out.println(video.getCheminAcces());
			
			//Selectionne les videos similaires à celle qui doit être suivie
			Vector<Video>listVideoSimilaire=videoModel.selectVideoSimilaire(video.getIdCategorie().getIdCategorie(), idVideo);
	    	
	    	//On verifie si le client est prenium ou pas
	    	AbonnementModel abonnementModel=new AbonnementModel();
	    	prenim=abonnementModel.verifAbonnementClient(client.getIdClient());
	    	
	    	AchatModel achatModel=new AchatModel();
	    	
	    	if(prenim==false){
	    		/*
	    		 * Si le client n'est pas prenium alors, 
	    		 * On verifie s'il a acheté ou louer la video
	    		 */
	    		achat=achatModel.verifAchatClient(client.getIdClient(), idVideo);
	    		if(achat==false){
		    			/*
			    		 * Si le client n'a pas acheté la vidéo alors
			    		 * On verifie s'il l'a louée pour une durée donnée
			    		 */
		    			LocationModel locationModel=new LocationModel();
		    			
		    			location=locationModel.verifLocationClient(client.getIdClient(), idVideo);
		    			
		    			if(location==false){
		    				//Redirection vers la page de location ou d'achat de video
		    				request.setAttribute("video", video);
		    				RequestDispatcher rd= request.getRequestDispatcher("/beforeVisualisation.jsp");
		    				rd.forward(request, response);
		    			}else{

		    				request.setAttribute("listVideoSimilaire", listVideoSimilaire);
		    				request.setAttribute("video", video);
		    				
		    				RequestDispatcher rd=request.getRequestDispatcher("/visualisation2.jsp");
		    				rd.forward(request, response);
		    	    	}
		    			
	    		}else{

					request.setAttribute("listVideoSimilaire", listVideoSimilaire);
					request.setAttribute("video", video);
					
					RequestDispatcher rd=request.getRequestDispatcher("/visualisation2.jsp");
					rd.forward(request, response);
		    	}

	    	}else{

				request.setAttribute("listVideoSimilaire", listVideoSimilaire);
				request.setAttribute("video", video);
				
				RequestDispatcher rd=request.getRequestDispatcher("/visualisation2.jsp");
				rd.forward(request, response);
	    	}
	    	
		
		} catch (ClassNotFoundException | SQLException e) {
		
		}
	   
		
	} // Si le client  n'est pas connecté alors on le redirige vers la page de connexion
		else{
		RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
