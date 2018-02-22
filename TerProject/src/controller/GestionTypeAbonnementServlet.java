package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Genre;
import entities.TypeAbonnement;
import model.GenreModel;
import model.TypeAbonnementModel;

/**
 * Servlet implementation class GestionTypeAbonnementServlet
 */
@WebServlet("/GestionTypeAbonnementServlet")
public class GestionTypeAbonnementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionTypeAbonnementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String sIdTypeAbonnement=(String) request.getParameter("idTypeAbonnement");
	        int idTypeAbonnement=Integer.parseInt(sIdTypeAbonnement);
	        
	        try {
				TypeAbonnementModel typeAbonnementModel=new TypeAbonnementModel();
				
				typeAbonnementModel.deleteId(idTypeAbonnement);
			
				response.sendRedirect(request.getContextPath() + "/TypeAbonnementServlet");
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
			
			String libelleAbonnement=(String) request.getParameter("libelleAbonnement");
			String sMontant=(String) request.getParameter("montant");
			
			double montant=Double.parseDouble(sMontant);
		
			try{

				TypeAbonnementModel typeAbonnementModel=new TypeAbonnementModel();
				
				typeAbonnementModel.saveTypeAbonnement(libelleAbonnement, montant);
				response.sendRedirect(request.getContextPath() + "/TypeAbonnementServlet");
			}catch(Exception e){ System.out.println(e.getMessage());}
		
		}else if(action.equals("update")){
			
			System.out.println("MISE A JOUR EN COURS");
			String libelleAbonnement=(String) request.getParameter("libelleAbonnement");
			String sIdTypeAbonnement=(String) request.getParameter("idTypeAbonnement");
		   String sMontant=(String) request.getParameter("montant");
			double montant=Double.parseDouble(sMontant);
			
			int idTypeAbonnement=Integer.parseInt(sIdTypeAbonnement);
			try {
				
				if(libelleAbonnement==null){
					throw new Exception();
				}
				

				TypeAbonnementModel typeAbonnementModel=new TypeAbonnementModel();
				TypeAbonnement typeAbonnement=new TypeAbonnement(idTypeAbonnement, libelleAbonnement, montant);
				
				typeAbonnementModel.updateTypeAbonnement(typeAbonnement);
				
				response.sendRedirect(request.getContextPath() + "/TypeAbonnementServlet");
		} catch (Exception e) {System.out.println(e.getMessage());  }
			
	}else{
		
		response.sendRedirect(request.getContextPath() + "/GenreServlet");
	}
		
}
				
}


