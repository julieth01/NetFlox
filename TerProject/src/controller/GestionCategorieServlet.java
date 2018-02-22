package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Categorie;
import model.CategorieModel;

/**
 * Servlet implementation class GestionCategorieServlet
 */
@WebServlet("/GestionCategorieServlet")
public class GestionCategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionCategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        String sIdCategorie=(String) request.getParameter("idCategorie");
        int idCategorie=Integer.parseInt(sIdCategorie);
        
        try {
			CategorieModel categorieModel=new CategorieModel();
			
			categorieModel.deleteId(idCategorie);
			response.sendRedirect(request.getContextPath() + "/CategorieServlet");
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
			String libelle=(String) request.getParameter("libelleCategorie");
		
			try{

				CategorieModel categorieModel=new CategorieModel();
				
				categorieModel.saveCategorie(libelle);
				response.sendRedirect(request.getContextPath() + "/CategorieServlet");
			}catch(Exception e){ }
		
		}else if(action.equals("update")){
			
			String libelleCategoire=(String) request.getParameter("libelleCategorie");
			String sIdCategoire=(String) request.getParameter("idCategorie");
			
			int idCategorie=Integer.parseInt(sIdCategoire);
			try {
				
				if(libelleCategoire==null){
					throw new Exception();
				}
				
				CategorieModel categorieModel=new CategorieModel();
				Categorie categorie=new Categorie(idCategorie,libelleCategoire);
				
				categorieModel.updateCategoire(categorie);
				
				response.sendRedirect(request.getContextPath() + "/CategorieServlet");
		} catch (Exception e) {
			
		}
	}else{
		
		response.sendRedirect(request.getContextPath() + "/CategorieServlet");
	}
		
		
		
	}

}
