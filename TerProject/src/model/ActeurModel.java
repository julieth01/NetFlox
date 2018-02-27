package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActeurModel extends NetfloxDB {

	public ActeurModel() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public void saveActeur(int idVideo, int idParticipant, String role){
		
		try {
			PreparedStatement st=conn.prepareStatement("INSERT INTO ACTEUR( idVideo, idParticipant,role) VALUES (?,?,?) ");
			st.setInt(1, idVideo);
			st.setInt(2, idParticipant);
			st.setString(3, role);
			int result=st.executeUpdate();
			if(result==1){
				System.out.println("Insertion reussie");
			}else{
				System.out.println("Insertion echouée");
			}
			
		} catch (Exception e) {System.out.println(e.getMessage());}

	}
	
}
