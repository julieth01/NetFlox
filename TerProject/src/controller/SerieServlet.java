package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Serie;
import model.ClientModel;
import model.GenreModel;
import model.SaisonModel;
import model.SerieModel;

/**
 * Servlet implementation class SerieServlet
 */
@WebServlet("/SerieServlet")
public class SerieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sIdSerie=(String) request.getParameter("idSerie");
		String action=(String) request.getParameter("action");
		
		if(sIdSerie!=null){
			
			Integer idSerie=Integer.parseInt(sIdSerie);

			try {
				SerieModel serieModel=new SerieModel();
				GenreModel genreModel=new GenreModel();
				SaisonModel saisonModel=new SaisonModel();
				
				request.setAttribute("selectedSerie",serieModel.selectSerie(idSerie).get(0));
				request.setAttribute("listSerie",serieModel.selectSerie(null));
				request.setAttribute("listGenre",genreModel.selectGenre(null));
				request.setAttribute("selectedSerie", serieModel.selectSerie(idSerie).get(0));
				request.setAttribute("listSaison", saisonModel.selectSaison(idSerie));
				
				RequestDispatcher rd= request.getRequestDispatcher("/serie.jsp");
				rd.forward(request, response); 
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		if(sIdSerie!=null && action!=null && action.equals("supp")){
			try {
				int idSerie=Integer.parseInt(sIdSerie);
				//Suppression
				SaisonModel saisonModel=new SaisonModel();
				SerieModel  serieModel = new SerieModel();
				GenreModel genreModel=new GenreModel();
			
				saisonModel.deleteSaison(idSerie);
				serieModel.deleteId(idSerie);
				
				request.setAttribute("listSerie",serieModel.selectSerie(null));
				request.setAttribute("listGenre",genreModel.selectGenre(null));
				
				RequestDispatcher rd= request.getRequestDispatcher("/serie.jsp");
				rd.forward(request, response); 
			} catch (ClassNotFoundException | SQLException e) {
			
		}

		}else{

			try{
				SerieModel serieModel=new SerieModel();
				GenreModel genreModel=new GenreModel();

				request.setAttribute("listSerie",serieModel.selectSerie(null));
				request.setAttribute("listGenre",genreModel.selectGenre(null));
				
				RequestDispatcher rd= request.getRequestDispatcher("/serie.jsp");
				rd.forward(request, response); 
				
			}catch(Exception e){
				
			}
		}	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String titre=(String) request.getParameter("titre");
		String sNbSaison=(String) request.getParameter("nbSaison");
		String sDateSortie=(String) request.getParameter("dateSortie");
		String resume=(String) request.getParameter("resume");
		String sIdGenre=(String) request.getParameter("idGenre");
		
		String action=(String) request.getParameter("action");
	
		/*Si action a effectuer est un insert alors 
		 * on fait une insertion d'un nouveau client dans la base
		 */
		if(action!=null && action.equals("insert")){
			Date dateSortie=null;
			
			//Conversion de la date au format date SQL
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	        java.util.Date parsed;
			try {
				parsed = format.parse(sDateSortie);
				 dateSortie = new java.sql.Date(parsed.getTime());
			} catch (ParseException e) { System.out.println(e.getMessage());}
			
			try {
				if(sIdGenre!=null && sNbSaison!=null){
					
				SerieModel serieModel=new SerieModel();
				int idGenre=Integer.parseInt(sIdGenre);
				int nbSaison=Integer.parseInt(sNbSaison);

				serieModel.saveSerie(titre, idGenre, nbSaison, dateSortie, resume);
				
				//Redirection vers le servlet SerieServlet
				response.sendRedirect(request.getContextPath() + "/SerieServlet");
				
				}
				
				
			} catch (ClassNotFoundException | SQLException e) {System.out.println(e.getMessage());  }
			
		}
		
		
		
	}

}
