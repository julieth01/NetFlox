package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClientModel;
import model.TypeAbonnementModel;

/**
 * Servlet implementation class TypeAbonnementServlet
 */
@WebServlet("/TypeAbonnementServlet")
public class TypeAbonnementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeAbonnementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
String sIdTypeAbonnement=(String) request.getParameter("idTypeAbonnement");
		
		if(sIdTypeAbonnement!=null){
			
			Integer idTypeAbonnement=Integer.parseInt(sIdTypeAbonnement);

			try {
				TypeAbonnementModel typeAbonnementModel=new TypeAbonnementModel();
				
				request.setAttribute("updateTypeAbonnement",typeAbonnementModel.selectTypeAbonnement(idTypeAbonnement).get(0));
				
				RequestDispatcher rd= request.getRequestDispatcher("/updateTypeAbonnement.jsp");
				rd.forward(request, response); 
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}else{

			try{
				TypeAbonnementModel typeAbonnementModel=new TypeAbonnementModel();
				
				request.setAttribute("listTypeAbonnement", typeAbonnementModel.selectTypeAbonnement(null));
				
				RequestDispatcher rd= request.getRequestDispatcher("/typeAbonnement.jsp");
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
