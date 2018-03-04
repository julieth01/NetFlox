package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import entities.Categorie;
import entities.Client;
import entities.Genre;
import entities.Participant;
import entities.Video;

public class VideoModel extends NetfloxDB {

	public VideoModel() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	public void saveVideo(String titre, String duree, java.sql.Date dateSortie, String resume, double prixVente, Integer idCategorie, Integer idGenre){
		
		try
		{
			System.out.println("***************** DEBUT INSERTION**************");
			
			PreparedStatement st=conn.prepareStatement("INSERT INTO VIDEO( titre,duree,dateSortie,resume,prixVente,idCategorie,idGenre,nbVue,nbTelechargement) VALUES (?,?,?,?,?,?,?,?,?) ");
			st.setString(1, titre);
			st.setString(2, duree);
			st.setDate(3, dateSortie);
		
			st.setString(4, resume);
			st.setDouble(5, prixVente);
			st.setInt(6, idCategorie);
			st.setInt(7, idGenre);
			st.setInt(8, 0);
			st.setInt(9, 0);
			
			int result=st.executeUpdate();
			if(result==1){
				System.out.println("Insertion reussie");
			}else{
				System.out.println("Insertion echouée");
			}
		}catch(Exception e){System.out.println(e.getMessage());}
		
	}
	
	
	//Selectionne l'idVideo de la derniere video qui vient d'etre inserée
	public int selectVideo(){
		
	int idVideo = 0;
		try{
		Statement st= conn.createStatement();
		ResultSet rs;
		
		rs=st.executeQuery("SELECT max(idVideo) as idVideo FROM Video ");
		
		rs.next();
		idVideo= rs.getInt("idVideo");
		}catch(Exception e){
			System.out.println("Erreur de connexion ");
		}
		return idVideo;
}
	
	/*
	 * Mise à jour du champ CheminAccess avec le nom du fichier uploader
	 */
	public void updateVideoChemin(String fileName, int idVideo){
		
		try{
			PreparedStatement st=conn.prepareStatement("UPDATE VIDEO SET CHEMINACCESS=? WHERE IDVIDEO=?");
			st.setString(1, fileName);
			st.setInt(2, idVideo);
			st.executeUpdate();
		}catch(Exception e){}
	}
	
	/*
	 * Mise à jour du champ image poster avec le nom du fichier uploader
	 */
	
	public void updateImagePoster(String fileName, int idVideo){
		
		try{
			PreparedStatement st=conn.prepareStatement("UPDATE VIDEO SET IMAGEPOSTER=? WHERE IDVIDEO=?");
			st.setString(1, fileName);
			st.setInt(2, idVideo);
			st.executeUpdate();
		}catch(Exception e){}
	}
	
	
	/* 
	 * Selection des video
	 */
	
	public Vector<Video> selectVideo(Integer idVideo){
		
		Vector<Video> listVideo=new Vector<>();
		try{
			Statement st=conn.createStatement();
			ResultSet rs;
				if(idVideo!=null){
				rs=st.executeQuery("SELECT * FROM VIDEO WHERE IDVIDEO="+idVideo);
				}else{
				rs=st.executeQuery("SELECT * FROM VIDEO");
				}
		
		Video video;
		Categorie categorie;
		Genre genre;
		CategorieModel categorieModel=new CategorieModel();
		GenreModel genreModel=new GenreModel();
		
		while(rs.next()){
		video=new Video();
		video.setIdVideo(rs.getInt("idVideo"));
		video.setTitre(rs.getString("titre"));
		video.setCheminAcces(rs.getString("Cheminaccess"));
		video.setDateSortie(rs.getDate("dateSortie"));
		video.setDuree(rs.getString("duree"));
		video.setNbTelechargement(rs.getInt("nbTelechargement"));
		video.setNbVue(rs.getInt("nbVue"));
		video.setImagePoster(rs.getString("imagePoster"));
		
		/*
		 * Selection de la categorie associée a la video
		 */
		categorie=new Categorie();
		categorie=categorieModel.selectCategorie(rs.getInt("idCategorie")).get(0);
		
		video.setIdCategorie(categorie);
		
		/*
		 * selection du genre associé à la video
		 */
		genre=genreModel.selectGenre(rs.getInt("idGenre")).get(0);
		video.setIdGenre(genre);
		
		/*
		 * Liste d'acteur associée
		 */
		
		
		/*
		 * Le réalisateur associé

		RealisateurModel realisateurModel=new RealisateurModel();
		Participant realisateur=realisateurModel.selectRealisateur(idVideo).get(0);
		if(realisateur!=null){
			video.setRealisateur(realisateur);
			
		}
		 */
		//Ajout de la video courante à la liste
			listVideo.add(video);
		}
			
		}catch(Exception e){System.out.println(e.getMessage());}
		
		return listVideo;
	}
	
	
	/*
	 * Selectionne les autres video de la meme categorie que l'id de la video passé en parametre
	 */
	
	public Vector<Video> selectVideoSimilaire(Integer idCategorie, int idVideo){
		
		Vector<Video> listVideo=new Vector<>();
		try{
			Statement st=conn.createStatement();
			ResultSet rs;
			
				rs=st.executeQuery("SELECT * FROM VIDEO WHERE IDCATEGORIE="+idCategorie+ " AND idVideo !="+idVideo);
				
		
		Video video;
	
		Genre genre;
		GenreModel genreModel=new GenreModel();
		
		while(rs.next()){
		video=new Video();
		video.setIdVideo(rs.getInt("idVideo"));
		video.setTitre(rs.getString("titre"));
		video.setCheminAcces(rs.getString("Cheminaccess"));
		video.setDateSortie(rs.getDate("dateSortie"));
		video.setDuree(rs.getString("duree"));
		video.setNbTelechargement(rs.getInt("nbTelechargement"));
		video.setNbVue(rs.getInt("nbVue"));
		video.setImagePoster(rs.getString("imagePoster"));
		
		
		genre=genreModel.selectGenre(rs.getInt("idGenre")).get(0);
		video.setIdGenre(genre);
		
		listVideo.add(video);
		}
		System.out.println(listVideo.size());
	}catch (Exception e) {System.out.println(e.getMessage());}
	return listVideo;
	}
		
		
	
	
	/*
	 * 
	 */
	public Vector<Video> selectEpisode(Integer idSaison){
		
		Vector<Video> listVideo=new Vector<>();
		try{
			Statement st=conn.createStatement();
			ResultSet rs;
			
			rs=st.executeQuery("SELECT * FROM VIDEO WHERE IDSAISON="+idSaison);
	
		
		Video video;
	
		
		while(rs.next()){
		video=new Video();
		video.setIdVideo(rs.getInt("idVideo"));
		video.setTitre(rs.getString("titre"));
		video.setCheminAcces(rs.getString("Cheminaccess"));
		video.setDateSortie(rs.getDate("dateSortie"));
		video.setDuree(rs.getString("duree"));
		video.setNbTelechargement(rs.getInt("nbTelechargement"));
		video.setNbVue(rs.getInt("nbVue"));
		video.setImagePoster(rs.getString("imagePoster"));

		
		/*
		 * Liste d'acteur associée
		 */
		
		
		/*
		 * Le réalisateur associé
		 */
		
		//Ajout de la video courante à la liste
			listVideo.add(video);
		}
			
		}catch(Exception e){}
		
		return listVideo;
	}
	
	
	
	/*
	 * Suppression d'une video connaissant l'idVideo
	 */
	public void deleteVideo(int idVideo){
		try{
			Statement st=conn.createStatement();
			st.executeUpdate("DELETE FROM VIDEO WHERE idvideo="+idVideo);
			
		}catch(Exception e){}
	}
	
}
