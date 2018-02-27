package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Genre;
import entities.Participant;
import model.GenreModel;
import model.ParticipantModel;

/**
 * Servlet implementation class GestionParticipantServlet
 */
@WebServlet("/GestionParticipantServlet")
public class GestionParticipantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionParticipantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String sIdParticipant=(String) request.getParameter("idParticipant");
	        int idParticipant=Integer.parseInt(sIdParticipant);
	        
	        try {
				ParticipantModel participantModel=new ParticipantModel();
				
				participantModel.deleteId(idParticipant);
			
				response.sendRedirect(request.getContextPath() + "/ParticipantServlet");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String action=(String) request.getParameter("action");
		
		if(request.getParameter("action")!=null && action.equals("insert") ){
			
			String nomParticipant=(String) request.getParameter("nomParticipant");
			String prenomParticipant=(String) request.getParameter("prenomParticipant");
		
			try{

				ParticipantModel participantModel=new ParticipantModel();
				
				participantModel.saveParticpant(nomParticipant, prenomParticipant);
				response.sendRedirect(request.getContextPath() + "/ParticipantServlet");
			}catch(Exception e){ System.out.println(e.getMessage());}
		
		}else if(action.equals("update")){
			
			//System.out.println("MISE A JOUR EN COURS");
			String nomParticipant=(String) request.getParameter("nomParticipant");
			String prenomParticipant=(String) request.getParameter("prenomParticipant");
			String sIdParticipant=(String) request.getParameter("idParticipant");
			
			int idParticipant=Integer.parseInt(sIdParticipant);
			try {
				
				if(nomParticipant==null || prenomParticipant==null){
					throw new Exception();
				}
				

				ParticipantModel participantModel=new ParticipantModel();
				Participant participant=new Participant(idParticipant, nomParticipant, prenomParticipant);
				
				participantModel.updateParticipant(participant);
				
				response.sendRedirect(request.getContextPath() + "/ParticipantServlet");
		} catch (Exception e) {System.out.println(e.getMessage());  }
			
	}else{
		
		System.out.println("Execution echoué");
		response.sendRedirect(request.getContextPath() + "/ParticipantServlet");
	}
		
}
		
		
}


