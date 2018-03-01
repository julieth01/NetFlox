package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;




import entities.Categorie;
import entities.Genre;
import entities.Participant;
import entities.Video;
import model.ActeurModel;
import model.CategorieModel;
import model.GenreModel;
import model.ParticipantModel;
import model.RealisateurModel;
import model.VideoModel;

/**
 * Servlet implementation class UploadVideoServlet
 */
@WebServlet("/UploadVideoServlet")
@MultipartConfig
public class UploadVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int TAILLE_TAMPON = 10240;
	private static String CHAMP_FICHIER="fichier1";
	private static String CHAMP_FICHIER2="fichier2";
	private static String CHEMIN="C:/Users/USER/git/LocalNetFloxRepository/TerProject/WebContent/uploads/";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			
			CategorieModel categorieModel=new CategorieModel();
			Vector<Categorie> listCategorie=categorieModel.selectCategorie(null);
			
			GenreModel genreModel=new GenreModel();
			Vector<Genre> listGenre=genreModel.selectGenre(null);
			
			ParticipantModel participantModel=new ParticipantModel();
			Vector<Participant> listParticipant= participantModel.selectParticipant(null);
			
			request.setAttribute("listCategorie", listCategorie);
			request.setAttribute("listGenre", listGenre);
			request.setAttribute("listParticipant", listParticipant);
			
			System.out.println("La liste des categorie"+ listCategorie.size());
			
			RequestDispatcher rd=request.getRequestDispatcher("/video.jsp");
			rd.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			System.out.println(e.getMessage());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("***************Debut de l'ajout d'une video********************");
		
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
	    String nomFichier = getNomFichier(part);
	    String nomFichier2= getNomFichier(part2);

		
		//Recupération des autres parametres
		String titre=(String) request.getParameter("titre");
		String duree=(String) request.getParameter("duree");
		String sDateSortie=(String) request.getParameter("dateSortie");
		String anneeProduction=(String) request.getParameter("anneeProduction");
		String resume=(String) request.getParameter("resume");
		String sPrixVente=(String) request.getParameter("prixVente");
		String sIdCategorie=(String) request.getParameter("idCategorie");
		String sIdGenre=(String) request.getParameter("idGenre");
		
		
		String sIdRealisateur=(String) request.getParameter("realisateur");
		String sIdActeurPrincipal=(String) request.getParameter("acteurPrincipal");
		String sIdActeurSecondaire=(String) request.getParameter("acteurSecondaire");
		String role=(String) request.getParameter("role");

		if(sIdCategorie!=null && sIdGenre!=null && sPrixVente!=null ){
			//int anneeProduction=Integer.parseInt(sAnneeProduction);
		    int idCategorie=Integer.parseInt(sIdCategorie);
			int idGenre=Integer.parseInt(sIdGenre);
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
				
				videoModel.saveVideo(titre, duree, dateSortie,  resume, prixVente, idCategorie, idGenre);
				
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
				
	
				
				//Enregistrement du realisateur
				if(sIdRealisateur!=null){
					int idRealisateur=Integer.parseInt(sIdRealisateur);
					
					if(idRealisateur!=0){
					RealisateurModel realisateurModel=new RealisateurModel();
					realisateurModel.saveRealisateur(idVideo, idRealisateur);
					}
				}
				
				
				//Enregistrement du realisateur
				ActeurModel acteurModel=new ActeurModel();
				
				if(sIdActeurPrincipal!=null){
					int idActeurPrincipal=Integer.parseInt(sIdActeurPrincipal);
					
					if(idActeurPrincipal!=0){
					acteurModel.saveActeur(idVideo, idActeurPrincipal, "Acteur principal");
					}
				}
				
				if(sIdActeurSecondaire!=null && role!=null){
					int idActeurSecondaire=Integer.parseInt(sIdActeurSecondaire);
					
					if(idActeurSecondaire!=0){
					acteurModel.saveActeur(idVideo, idActeurSecondaire,role);
					}
				}
		
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			}

		}
		
		//Redirection 
		response.sendRedirect(request.getContextPath() + "/UploadVideoServlet");	
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
	 * Méthode utilitaire qui a pour unique but d'analyser l'en-tête "content-disposition",
	 * et de vérifier si le paramètre "filename"  y est présent. Si oui, alors le champ traité
	 * est de type File et la méthode retourne son nom, sinon il s'agit d'un champ de formulaire 
	 * classique et la méthode retourne null. 
	 */
	public static String getNomFichier( Part part ) {
		
		System.out.println("Get Nom Fichier est en cours de lecture");
		System.out.println("La valeur du part est"+ part.getHeader("content-disposition"));
		
	    /* Boucle sur chacun des paramètres de l'en-tête "content-disposition". */
	    for ( String contentDisposition : part.getHeader( "Content-Disposition" ).split( ";" ) ) {
	    	/* Recherche de l'éventuelle présence du paramètre "filename". */
	        if ( contentDisposition.trim().startsWith("filename") ) {
	        	System.out.println("UN FICHIER RETROUVE");
	            /* Si "filename" est présent, alors renvoi de sa valeur, c'est-à-dire du nom de fichier. */
	              String firstSubstring=contentDisposition.substring( contentDisposition.indexOf( '=' ) + 2);	      
	             return firstSubstring.substring(0,firstSubstring.indexOf('"'));
	            }
	    }
	    /* Et pour terminer, si rien n'a été trouvé... */
	    System.out.println("La valeur null a été retournée");
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
