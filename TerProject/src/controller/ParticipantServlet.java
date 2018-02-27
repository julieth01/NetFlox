package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClientModel;
import model.ParticipantModel;

/**
 * Servlet implementation class ParticipantServlet
 */
@WebServlet("/ParticipantServlet")
public class ParticipantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParticipantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String sIdParticipant=(String) request.getParameter("idParticipant");
		
		if(sIdParticipant!=null){
			
			Integer idParticipant=Integer.parseInt(sIdParticipant);

			try {
				ParticipantModel participantModel=new ParticipantModel();
				
				request.setAttribute("updateParticipant",participantModel.selectParticipant(idParticipant).get(0));
				
				RequestDispatcher rd= request.getRequestDispatcher("/updateParticipant.jsp");
				rd.forward(request, response); 
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}else{

			try{
				ParticipantModel participantModel=new ParticipantModel();
				
				request.setAttribute("listParticipant",participantModel.selectParticipant(null));
				
				RequestDispatcher rd= request.getRequestDispatcher("/participant.jsp");
				rd.forward(request, response); 
				
			}catch(Exception e){
				
			}
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
