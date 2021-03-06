package controller;

//Auteur: OUMAROU KABORE

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClientModel;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sIdClient=(String) request.getParameter("idClient");
		
		if(sIdClient!=null){
			
			Integer idClient=Integer.parseInt(sIdClient);

			try {
				ClientModel clientModel=new ClientModel();
				
				request.setAttribute("updateClient",clientModel.selectClient(idClient).get(0));
				
				RequestDispatcher rd= request.getRequestDispatcher("/adminUpdateClient.jsp");
				rd.forward(request, response); 
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}else{

			try{
				ClientModel clientModel=new ClientModel();
				
				request.setAttribute("listClient",clientModel.selectClient(null));
				
				RequestDispatcher rd= request.getRequestDispatcher("/form.jsp");
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
