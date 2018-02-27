package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import entities.Client;

public class VideoModel extends NetfloxDB {

	public VideoModel() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	public void saveVideo(String titre, String duree, java.sql.Date dateSortie, String resume, double prixVente, int idCategorie, int idGenre){
		
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
	
	
	
}
