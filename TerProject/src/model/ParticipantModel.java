package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import entities.Client;
import entities.Participant;

public class ParticipantModel extends NetfloxDB {

	public ParticipantModel() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	/*
	 * Selectionne le participant dont l'idParticipant est en parametre
	 * si idParticipant=null, retourne la liste de tous les participant
	 */
	public Vector<Participant> selectParticipant(Integer idParticipant){
		
			Vector<Participant> listParticipant=new Vector<>();
			try{
			Statement st= conn.createStatement();
			ResultSet rs;
				if(idParticipant==null){
					rs=st.executeQuery("SELECT * FROM PARTICIPANT ");
				}else{
					rs=st.executeQuery("SELECT * FROM PARTICIPANT WHERE idPARTICIPANT= "+idParticipant);
				}
				
			Participant participant;
			while(rs.next()){
				
				participant=new Participant();
				participant.setIdParticipant(rs.getInt("idParticipant"));
				participant.setNomParticipant(rs.getString("NOMPARTICIPANT"));
				participant.setPrenomParticipant(rs.getString("PRENOMPARTICIPANT"));
			
				listParticipant.add(participant);
			
			}
				
			}catch(Exception e){
				System.out.println("Erreur de connexion ");
			}
			
		return listParticipant;
	}
	
	
	
	/*
	 * Méthode pour sauvegarder un participant
	 */
	
	public void saveParticpant(String nomParticipant, String prenomParticipant ){
		
		try
		{
			
			PreparedStatement st=conn.prepareStatement("INSERT INTO PARTICIPANT( nomParticipant,prenomParticipant) VALUES (?,?) ");
			st.setString(1, nomParticipant);
			st.setString(2, prenomParticipant);
			
			int result=st.executeUpdate();
			if(result==1){
				System.out.println("Insertion reussie");
			}else{
				System.out.println("Insertion echouée");
			}
		}catch(Exception e){System.out.println(e.getMessage());}

	}
	
	/*
	 * Methode pour faire la mise à  jour d'un participant
	 */
	public void updateParticipant(Participant participant){
		
		try{
			
			PreparedStatement st=conn.prepareStatement("UPDATE  PARTICIPANT SET nomParticipant=?, prenomParticipant=?  WHERE IdParticipant=?");
			st.setString(1, participant.getNomParticipant());
			st.setString(2, participant.getPrenomParticipant());
			st.setInt(3, participant.getIdParticipant());
			st.executeUpdate();
			
		}catch(Exception e){ }
		
		
	}
	
	/*
	 * Appele la methode deleteId de NetfloxDB en changeant les 
	 * parametres sur le nom de la table et le nom de id
	 */
	public boolean deleteId(int idParticipant) {
		return super.deleteId(idParticipant,"PARTICIPANT","IDPARTICIPANT");
	}
	
	
	
	
	
}
