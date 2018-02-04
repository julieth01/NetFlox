package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import entities.Client;
import model.ClientModel;

//Auteur: OUMAROU KABORE

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getSession().invalidate();
		
		// Vérification de la présence de la session Client
		Client client=(Client) request.getSession().getAttribute("client");
		
		if(client!=null){
			System.out.println("La session n'est pas null");
			RequestDispatcher rd=request.getRequestDispatcher("/ConnexionServlet/index.jsp");
			rd.forward(request, response);
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email=(String) request.getParameter("email");
		String password= (String) request.getParameter("password");
		
		try{
					
			ClientModel clientModel=new ClientModel();
			
			if(email!=null && password!=null){
			
				if(clientModel.verifConnexion(email, password).size()>0){
					Client client=clientModel.verifConnexion(email, password).get(0);
					
					//Creation de la session avec les parametre du client qui se connecte
					if(request.getSession().getAttribute("client")==null){
					request.getSession().setAttribute("client", client);
					}
					
					//Redirection vers la page d'accueil
					RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
			}
		
				RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			
		}catch(Exception e){}
		
	}

}
