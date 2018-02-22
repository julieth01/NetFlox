package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategorieModel;
import model.GenreModel;
import entities.Categorie;
import entities.Genre;

/**
 * Servlet implementation class GestionGenreServlet
 */
@WebServlet("/GestionGenreServlet")
public class GestionGenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionGenreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  String sIdGenre=(String) request.getParameter("idGenre");
	        int idGenre=Integer.parseInt(sIdGenre);
	        
	        try {
				GenreModel genreModel=new GenreModel();
				
				genreModel.deleteId(idGenre);
			
				response.sendRedirect(request.getContextPath() + "/GenreServlet");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String action=(String) request.getParameter("action");
		
		if(request.getParameter("action")!=null && action.equals("insert") ){
			
			String libelleGenre=(String) request.getParameter("libelleGenre");
		
			try{

				GenreModel genreModel=new GenreModel();
				
				genreModel.saveGenre(libelleGenre);
				response.sendRedirect(request.getContextPath() + "/GenreServlet");
			}catch(Exception e){ System.out.println(e.getMessage());}
		
		}else if(action.equals("update")){
			
			System.out.println("MISE A JOUR EN COURS");
			String libelleGenre=(String) request.getParameter("libelleGenre");
			String sIdGenre=(String) request.getParameter("idGenre");
			
			int idGenre=Integer.parseInt(sIdGenre);
			try {
				
				if(libelleGenre==null){
					throw new Exception();
				}
				

				GenreModel genreModel=new GenreModel();
				Genre genre=new Genre(idGenre,libelleGenre);
				
				genreModel.updateGenre(genre);
				
				response.sendRedirect(request.getContextPath() + "/GenreServlet");
		} catch (Exception e) {System.out.println(e.getMessage());  }
			
	}else{
		
		response.sendRedirect(request.getContextPath() + "/GenreServlet");
	}
		
}

}
