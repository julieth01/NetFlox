package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClientModel;

//Auteur: OUMAROU KABORE

/**
 * Servlet implementation class InscriptionClientServlet
 */
@WebServlet("/InscriptionClientServlet")
public class InscriptionClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("client")!=null){
			
			RequestDispatcher rd=request.getRequestDispatcher("/erorPage..jsp");
			rd.forward(request, response);
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String tel=request.getParameter("tel");

		//Client client=new Client(0, nom, prenom, "", password,email,tel);
		
	try{
			ClientModel clientModel=new ClientModel();
			clientModel.saveClient(nom, prenom, email, tel, password);
			 
			RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			
		}catch(Exception e){System.out.println(e.getMessage()) ;}

	}

}
