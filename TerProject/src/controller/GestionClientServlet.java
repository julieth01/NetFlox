package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Client;
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
		//String supp=(String) request.getAttribute("supp");
		
		//Recuperation de la variable de session
		Client client=(Client) request.getSession().getAttribute("client");
		
		//Verification de la valeur de la variable de session
		if(client!=null){
		
		//Recuperation de l'idClient passer en parametre
		String sIdClient=(String) request.getParameter("idClient");
		
		//Conversion de l'idClient en int
		Integer idClient=Integer.parseInt(sIdClient);
		
		try{
			
			   //Initialisation d'un objet Model
			   ClientModel clientModel=new ClientModel();		
			   
			   //Execution de la methode de suppression et recuperation de la valeur retournée
				Boolean verifSupp=clientModel.deleteId(idClient);
				
				if(verifSupp==true){
					System.out.println("La suppression a reussie");
				}
				//RequestDispatcher rd=request.getRequestDispatcher("/form")
				response.sendRedirect(request.getContextPath() + "/ClientServlet");
			
		}catch(Exception e){
			
	}
		
}else{
		RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
}
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Gestion de la mise à jour du client
		
		
		String nom=(String) request.getParameter("nom");
		String prenom=(String) request.getParameter("prenom");
		String email=(String) request.getParameter("email");
		String tel=(String) request.getParameter("tel");
		
	
		try {
			
				if(nom==null || prenom==null || email==null || tel==null){
					throw new Exception();
				}
				//Recuperation de la variable de session dans un nouveau objet client
				//Client clientSession= (Client) request.getSession().getAttribute("client");
				
				String sIdClient=request.getParameter("idClient");
				int idClient=Integer.parseInt(sIdClient);
				
				//Création d'un nouveau client à partir des données recupérées
				Client client=new Client(idClient, nom,prenom,"",email,tel);
				
				//Création d'un objet  client model
				ClientModel clientModel=new ClientModel();
				
				//Mise à jour du profil du client
				clientModel.updateClient(client);
				
				//Redirection vers le servlet EspaceClientServlet
				response.sendRedirect(request.getContextPath() + "/ClientServlet");
								
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 
	
	}
		
		
}


