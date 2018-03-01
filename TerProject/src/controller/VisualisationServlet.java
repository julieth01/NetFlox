package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Client;

/**
 * Servlet implementation class VisualisationServlet
 */
@WebServlet("/VisualisationServlet")
public class VisualisationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualisationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Recuperation de la variable de session
		Client client=new Client();
		client=(Client) request.getSession().getAttribute("client");
		
		//Verification de session, si elle n'existe pas on renvoie l'utilisateur vers la page de connexion
		if(client!=null){
		RequestDispatcher rd=request.getRequestDispatcher("/visualisation2.jsp");
		rd.forward(request, response);
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
	}

}
