package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.VideoModel;

/**
 * Servlet implementation class EpisodeServlet
 */
@WebServlet("/EpisodeServlet")
@MultipartConfig
public class EpisodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int TAILLE_TAMPON = 10240;
	private static String CHAMP_FICHIER="fichier1";
	private static String CHAMP_FICHIER2="fichier2";
	private static String CHEMIN="C:/Users/USER/git/LocalNetFloxRepository/TerProject/WebContent/uploads/";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EpisodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String sIdSaison=(String) request.getParameter("idSaison");
		if(sIdSaison!=null){
			VideoModel videoModel;
			try {
				
				videoModel = new VideoModel();
				int idSaison=Integer.parseInt(sIdSaison);
				//Selectionne la liste des videos de la meme saison
				request.setAttribute("listVideo",videoModel.selectEpisode(idSaison) );
				
			} catch (ClassNotFoundException | SQLException e) {
			
			}
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("/listEpisode.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*
	     * Les données reçues sont multipart, on doit donc utiliser la méthode
	     * getPart() pour traiter le champ d'envoi de fichiers.
	     */
		 Part part = request.getPart( CHAMP_FICHIER );  
		 Part part2=request.getPart(CHAMP_FICHIER2);
	    /*
	     * Il faut déterminer s'il s'agit d'un champ classique 
	     * ou d'un champ de type fichier : on délègue cette opération 
	     * à la méthode utilitaire getNomFichier().
	     */
	    String nomFichier =UploadVideoServlet. getNomFichier(part);
	    String nomFichier2= UploadVideoServlet.getNomFichier(part2);
	    
	    
	  //Recupération des autres parametres
	  		String titre=(String) request.getParameter("titre");
	  		String duree=(String) request.getParameter("duree");
	  		String sDateSortie=(String) request.getParameter("dateSortie");
	  		String sPrixVente=(String) request.getParameter("prixVente");
	  		
	  		
	  		if(sPrixVente!=null  && sDateSortie!=null){
				//int anneeProduction=Integer.parseInt(sAnneeProduction);
				double prixVente=Double.parseDouble(sPrixVente);
				Date dateSortie=null;
				
				//Conversion de la date au format date SQL
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		        java.util.Date parsed;
				try {
					parsed = format.parse(sDateSortie);
					 dateSortie = new java.sql.Date(parsed.getTime());
				} catch (ParseException e) { System.out.println(e.getMessage());}
				
				try {

					VideoModel videoModel=new VideoModel();
					
					videoModel.saveVideo(titre, duree, dateSortie,  "", prixVente,23, null);
					
					//Recuperation de l'id de la video qui vient d'etre enregistré
					int idVideo=videoModel.selectVideo();
					
					String nouveauNom;
					/*Appel de la méthode uplod pour le chargement des fichiers  pour le chargement de l'image*/
				nouveauNom= uploadFile(part, nomFichier, idVideo);
				    /* Mise à jour de la video avec le nom du fichier*/
				   videoModel.updateImagePoster(nouveauNom, idVideo);
			      

					/*Appel de la méthode uplod pour le chargement des fichiers  pour le chargement de la video*/
				     nouveauNom= uploadFile(part2, nomFichier2, idVideo);
				    /* Mise à jour de la video avec le nom du fichier*/
				     videoModel.updateVideoChemin(nouveauNom, idVideo);
				     
				     
				 	//Redirection 
					response.sendRedirect(request.getContextPath() + "/SerieServlet");	
				     
				}catch(Exception e){}
	  		}
					
	}
	
				public  String  uploadFile(Part part, String nomFichier,int idVideo ) throws IOException{
				    /*
				     * Si la méthode a renvoyé quelque chose, il s'agit donc d'un champ
				     * de type fichier (input type="file").
				     */
				    if ( nomFichier != null && !nomFichier.isEmpty() ) {
				       // String nomChamp = part.getName();
				        /*
				         * Antibug pour Internet Explorer, qui transmet pour une raison
				         * mystique le chemin du fichier local à la machine du client...
				         * 
				         * Ex : C:/dossier/sous-dossier/fichier.ext
				         * 
				         * On doit donc faire en sorte de ne sélectionner que le nom et
				         * l'extension du fichier, et de se débarrasser du superflu.
				         */
				         nomFichier = nomFichier.substring( nomFichier.lastIndexOf( '/' ) + 1 )
				                .substring( nomFichier.lastIndexOf( '\\' ) + 1 );
				         
				         /*Concatenation du nom  de fichier avec l'id de la video*/ 
				         String  extend = nomFichier.substring(nomFichier.indexOf(".") + 1);
					     String  nouveauNomFichier = nomFichier.substring(0, nomFichier.indexOf(".")) + "-" + idVideo + "."+extend;
				         
				        
				        /* Écriture du fichier sur le disque */
				       ecrireFichier( part, nouveauNomFichier, CHEMIN );

				    //    request.setAttribute( nomChamp, nomFichier );
				        return nouveauNomFichier;
				    }
				    	return null;
				    
				}
	
				/*
				 * Méthode utilitaire qui a pour but d'écrire le fichier passé en paramètre
				 * sur le disque, dans le répertoire donné et avec le nom donné.
				 */
			public void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
				    /* Prépare les flux. */
				    BufferedInputStream entree = null;
				    BufferedOutputStream sortie = null;
				    try {
				        /* Ouvre les flux. */
				        entree = new BufferedInputStream( part.getInputStream(), TAILLE_TAMPON );
				        sortie = new BufferedOutputStream( new FileOutputStream( new File( chemin + nomFichier ) ), TAILLE_TAMPON );
				      
				        /*
				         * Lit le fichier reçu et écrit son contenu dans un fichier sur le
				         * disque.
				         */
				        byte[] tampon = new byte[TAILLE_TAMPON];
				        int longueur;
				        while ( ( longueur = entree.read( tampon ) ) > 0 ) {
				            sortie.write( tampon, 0, longueur );
				        
				        }    
				    } finally {
				    	try {
							sortie.close();
						} catch (Exception e) {}
						
				    	try {
							entree.close();
						} catch (Exception e) {}
									
				}
			}

				
				
}
