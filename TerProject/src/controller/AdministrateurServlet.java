package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AdministrateurModel;

/**
 * Servlet implementation class AdministrateurServlet
 */
@WebServlet("/AdministrateurServlet")
public class AdministrateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministrateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String sIdAdmin=(String) request.getParameter("idAdmin");
		
		if(sIdAdmin!=null){
			
			Integer idAdministrateur=Integer.parseInt(sIdAdmin);

			try {
				AdministrateurModel AdministrateurModel=new AdministrateurModel();
				
				request.setAttribute("updateAdministrateur",AdministrateurModel.selectAdministrateur(idAdministrateur).get(0));
				
				RequestDispatcher rd= request.getRequestDispatcher("/updateAdministrateur.jsp");
				rd.forward(request, response); 
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}else{

			try{
				AdministrateurModel AdministrateurModel=new AdministrateurModel();
				
				request.setAttribute("listAdministrateur",AdministrateurModel.selectAdministrateur(null));
				
				RequestDispatcher rd= request.getRequestDispatcher("/administrateur.jsp");
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
