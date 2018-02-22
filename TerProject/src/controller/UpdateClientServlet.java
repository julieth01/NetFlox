package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import entities.Client;
import model.ClientModel;

/**
 * Servlet implementation class UpdateClientServlet
 */
@WebServlet("/UpdateClientServlet")
public class UpdateClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nom=(String) request.getParameter("nom");
		String prenom=(String) request.getParameter("prenom");
		String email=(String) request.getParameter("email");
		String tel=(String) request.getParameter("tel");
		
	
		try {
			
				if(nom==null || prenom==null || email==null || tel==null){
					throw new Exception();
				}
				//Recuperation de la variable de session dans un nouveau objet client
				Client clientSession= (Client) request.getSession().getAttribute("client");
				
				//Création d'un nouveau client à partir des données recupérées
				Client client=new Client(clientSession.getIdClient(), nom,prenom,"",email,tel);
				
				//Création d'un objet  client model
				ClientModel clientModel=new ClientModel();
				
				//Mise à jour du profil du client
				clientModel.updateClient(client);
				
				//Redirection vers le servlet EspaceClientServlet
				response.sendRedirect(request.getContextPath() + "/EspaceClientServlet");
								
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 
	
	}

}
