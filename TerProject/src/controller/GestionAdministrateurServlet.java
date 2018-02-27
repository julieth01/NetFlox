package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Administrateur;
import entities.Genre;
import model.AdministrateurModel;
import model.GenreModel;

/**
 * Servlet implementation class GestionAdministrateurServlet
 */
@WebServlet("/GestionAdministrateurServlet")
public class GestionAdministrateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionAdministrateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String sIdAdmin=(String) request.getParameter("idAdmin");
	        int idAdmin=Integer.parseInt(sIdAdmin);
	        
	        try {
				AdministrateurModel administrateurModel=new AdministrateurModel();
				
				administrateurModel.deleteId(idAdmin);
			
				response.sendRedirect(request.getContextPath() + "/AdministrateurServlet");
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
		
		String nom=(String) request.getParameter("nom");
		String prenom=(String) request.getParameter("prenom");
		String email=(String) request.getParameter("email");
		String password=(String) request.getParameter("password");
		
		
		if(request.getParameter("action")!=null && action.equals("insert") ){
			
			try{

				AdministrateurModel administrateurModel=new AdministrateurModel();
				
				administrateurModel.saveAdministrateur(nom, prenom, email, password);
				response.sendRedirect(request.getContextPath() + "/AdministrateurServlet");
			}catch(Exception e){ System.out.println(e.getMessage());}
		
		}else if(action.equals("update")){
			
			System.out.println("MISE A JOUR EN COURS");
			String sIdAdmin=(String) request.getParameter("idAdmin");
			
			int idAdmin=Integer.parseInt(sIdAdmin);
			try {
				
				if(nom==null || prenom==null || email==null || password==null){
					throw new Exception();
				}
				

				AdministrateurModel administrateurModel=new AdministrateurModel();
				Administrateur administrateur=new Administrateur(idAdmin, nom,prenom,password, email);
				
				administrateurModel.updateAdministrateur(administrateur);
				
				response.sendRedirect(request.getContextPath() + "/AdministrateurServlet");
		} catch (Exception e) {System.out.println(e.getMessage());  }
			
	}else{
		
		response.sendRedirect(request.getContextPath() + "/AdministrateurServlet");
	}
		
}
	

}
