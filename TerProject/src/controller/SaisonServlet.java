package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SaisonModel;

/**
 * Servlet implementation class SaisonServlet
 */
@WebServlet("/SaisonServlet")
public class SaisonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaisonServlet() {
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
		
		System.out.println("Debut Insertion");
		String libelleSaison=(String) request.getParameter("libelleSaison");
		String sNbEpisode=(String) request.getParameter("nbEpisode");
		String sIdSerie=(String) request.getParameter("idSerie");
		
		System.out.println(libelleSaison);
		System.out.println(sNbEpisode);
		System.out.println(sIdSerie);
		
		if(libelleSaison!=null && sNbEpisode!=null && sIdSerie!=null){
			
			int nbEpisode=Integer.parseInt(sNbEpisode);
			int idSerie=Integer.parseInt(sIdSerie);
			
			try {
				SaisonModel saisonModel=new SaisonModel();
				
				saisonModel.saveSaison(libelleSaison, idSerie, nbEpisode);
				
				System.out.println("Ajout reussi");
				//Redirection vers le servlet SerieServlet
				response.sendRedirect(request.getContextPath() + "/SerieServlet");
				
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e.getMessage());
			}
			
		}else{
			//Redirection vers le servlet SerieServlet
			response.sendRedirect(request.getContextPath() + "/SerieServlet");
		}
			
	}

}
