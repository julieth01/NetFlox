package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
