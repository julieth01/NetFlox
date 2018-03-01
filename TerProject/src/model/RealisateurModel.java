package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import entities.Participant;
import entities.Realisateur;

public class RealisateurModel  extends NetfloxDB{

	public RealisateurModel() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	/* 
	 * Enregistrer un realisateur
	 */
	public void saveRealisateur(int idVideo, int idParticipant){
		
		try {
			
			PreparedStatement st=conn.prepareStatement("INSERT INTO REALISATEUR( idVideo, idParticipant) VALUES (?,?) ");
			st.setInt(1, idVideo);
			st.setInt(2, idParticipant);
			int result=st.executeUpdate();
			if(result==1){
				System.out.println("Insertion reussie");
			}else{
				System.out.println("Insertion echouée");
			}
			
		} catch (Exception e) {System.out.println(e.getMessage());}

	}
	
	/*
	 * Selection du realisateur en fonction de l'idVideo
	 */
	
	public Vector<Participant>selectRealisateur(Integer idVideo){
		
		Vector<Participant> listRealisateur=new Vector<>();
		
		
		return listRealisateur;
		
	}
	
	
	/*
	 * Suppression d'un realisateur connaissant l'idVideo
	 */
	
	public void deleteRealisateur(int idVideo){
		try{
			Statement st=conn.createStatement();
			st.executeUpdate("DELETE FROM REALISATEUR WHERE idvideo="+idVideo);
			
		}catch(Exception e){}
	}
	
}
