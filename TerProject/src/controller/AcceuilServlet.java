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

import model.VideoModel;
import entities.Video;

/**
 * Servlet implementation class AcceuilServlet
 */
@WebServlet("/AcceuilServlet")
public class AcceuilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceuilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Selection des videos disponibles
		VideoModel videoModel;
		try {
			
			videoModel = new VideoModel();
			Vector<Video> listVideo=videoModel.selectVideo(null);
			request.setAttribute("listVideo",listVideo);
			
			RequestDispatcher rd=request.getRequestDispatcher("/accueil2.jsp");
			rd.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
		
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//Recherche
		
		
		
	}

}
