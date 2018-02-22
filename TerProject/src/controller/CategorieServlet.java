package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategorieModel;
import model.ClientModel;

/**
 * Servlet implementation class CategorieServlet
 */
@WebServlet("/CategorieServlet")
public class CategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String sIdCategorie=(String) request.getParameter("idCategorie");
		
		if(sIdCategorie!=null){
			
			Integer idCategorie=Integer.parseInt(sIdCategorie);

			try {
				CategorieModel categorieModel=new CategorieModel();
				
				request.setAttribute("updateCategorie",categorieModel.selectCategorie(idCategorie).get(0));
				
				RequestDispatcher rd= request.getRequestDispatcher("/updateCategorie.jsp");
				rd.forward(request, response); 
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}else{

			try{
				CategorieModel categorieModel=new CategorieModel();
				
				request.setAttribute("listCategorie",categorieModel.selectCategorie(null));
				
				RequestDispatcher rd= request.getRequestDispatcher("/categorie.jsp");
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
