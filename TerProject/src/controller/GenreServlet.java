package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategorieModel;
import model.GenreModel;

/**
 * Servlet implementation class GenreServlet
 */
@WebServlet("/GenreServlet")
public class GenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sIdGenre=(String) request.getParameter("idGenre");
		
		if(sIdGenre!=null){
			
			Integer idGenre=Integer.parseInt(sIdGenre);

			try {
				GenreModel genreModel=new GenreModel();
				
				request.setAttribute("updateGenre",genreModel.selectGenre(idGenre).get(0));
				
				RequestDispatcher rd= request.getRequestDispatcher("/updateGenre.jsp");
				rd.forward(request, response); 
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}else{

			try{
				GenreModel genreModel=new GenreModel();

				request.setAttribute("listGenre",genreModel.selectGenre(null));
				
				RequestDispatcher rd= request.getRequestDispatcher("/genre.jsp");
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
