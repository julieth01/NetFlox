package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Video;
import model.ActeurModel;
import model.RealisateurModel;
import model.VideoModel;

/**
 * Servlet implementation class GestionVideoServlet
 */
@WebServlet("/GestionVideoServlet")
public class GestionVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		VideoModel videoModel;
		
		String action= (String) request.getParameter("action");
		String sIdVideo= (String) request.getParameter("idVideo");
		
		System.out.println("IDVIDEO"+ sIdVideo);
		if(action!=null &&  action.equals("supp")){
			if(sIdVideo!=null){
				System.out.println("Debut de la suppression");
				int idVideo=Integer.parseInt(sIdVideo);
				
				try {
					//Suppression du realisateur
					RealisateurModel realisateurModel=new RealisateurModel();
					realisateurModel.deleteRealisateur(idVideo);
					
					//Suppression des acteur
					ActeurModel acteurModel=new ActeurModel();
					acteurModel.deleteActeur(idVideo);
					
					//Suppression de la video
					videoModel = new VideoModel();
					videoModel.deleteVideo(idVideo);
					
					Vector<Video> listVideo=videoModel.selectVideo(null);
					request.setAttribute("listVideo",listVideo);
				} catch (ClassNotFoundException | SQLException e) {
					
					System.out.print(e.getMessage());
				}
			
				RequestDispatcher rd=request.getRequestDispatcher("/gestionVideo.jsp");
				rd.forward(request, response);
			}
		}
		
		else{
		try {
			videoModel = new VideoModel();
			Vector<Video> listVideo=videoModel.selectVideo(null);
			request.setAttribute("listVideo",listVideo);
		} catch (ClassNotFoundException | SQLException e) {
			
			System.out.print(e.getMessage());
		}
	
		RequestDispatcher rd=request.getRequestDispatcher("/gestionVideo.jsp");
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
