package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClientModel;

/**
 * Servlet implementation class GestionClientServlet
 */
@WebServlet("/GestionClientServlet")
public class GestionClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//boolean modif=(boolean) request.getAttribute("modif");
		/*boolean supp=(boolean) request.getAttribute("supp");
		
		Integer idClient=(Integer) request.getAttribute("idClient");
		
		try{
			ClientModel clientModel=new ClientModel();	
			
			if(supp==true){
				clientModel.deleteId(idClient);
				response.sendRedirect(request.getContextPath() + "/ClientServlet");
			}
			
		}catch(Exception e){
			
		}
		
		*/
		
	
		RequestDispatcher rd=request.getRequestDispatcher("/accueil.jsp");
		rd.forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
