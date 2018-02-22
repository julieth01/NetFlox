package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import entities.TypeAbonnement;

public class TypeAbonnementModel extends NetfloxDB {

	public TypeAbonnementModel() throws ClassNotFoundException, SQLException {
		super();
		
	}

	
	/*
	 * Selectionne le typeAbonnement dont l'idTypeAbonnement est en parametre
	 * si typeAbonnement=null, retourne la liste de tous les typeAbonnement
	 */
	public Vector<TypeAbonnement> selectTypeAbonnement(Integer idTypeAbonnement){
		
			Vector<TypeAbonnement> listTypeAbonnement=new Vector<>();
			try{
			Statement st= conn.createStatement();
			ResultSet rs;
				if(idTypeAbonnement==null){
					rs=st.executeQuery("SELECT * FROM TYPEABONNEMENT ");
				}else{
					rs=st.executeQuery("SELECT * FROM TYPEABONNEMENT  WHERE IDTYPEABONNEMENT= "+idTypeAbonnement);
				}
			
			TypeAbonnement typeAbonnement;
				
			while(rs.next()){
				
			    typeAbonnement=new TypeAbonnement();
			    typeAbonnement.setIdTypeAbonnement(rs.getInt("idTypeAbonnement"));
				typeAbonnement.setLibelleAbonnement(rs.getString("libelleAbonnement"));
				typeAbonnement.setMontant(rs.getDouble("montant"));
				listTypeAbonnement.add(typeAbonnement);
			
			}
				
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
		return listTypeAbonnement;
	}
	
	
	//Methode permettant d'enregistrer un type d'abonnement de video dans la base de données
	public void saveTypeAbonnement(String libelleAbonnement, double montant){
		
		try {
			PreparedStatement st=conn.prepareStatement("INSERT INTO TYPEABONNEMENT(libelleAbonnement,montant) VALUES(?,?)");
			st.setString(1, libelleAbonnement);
			st.setDouble(2, montant);
			st.executeUpdate();
		} catch (Exception e) {
			
		}
	}
	
	//Mise à jour d'un typeAbonnement
	
	public void updateTypeAbonnement(TypeAbonnement typeAbonnement){
		
		try {
			PreparedStatement st=conn.prepareStatement("UPDATE TYPEABONNEMENT SET LIBELLEABONNEMENT=?, MONTANT=?  WHERE IDTYPEABONNEMENT=?");
			st.setString(1, typeAbonnement.getLibelleAbonnement());
			st.setDouble(2, typeAbonnement.getMontant());
			st.setInt(3, typeAbonnement.getIdTypeAbonnement());
			st.executeUpdate();
			
		} catch (Exception e) {
			
		}
	}
	
//Suppression d'un typeAbonnement
public boolean deleteId(Integer  idTypeAbonnement){
	
	return 	super.deleteId(idTypeAbonnement, "TYPEABONNEMENT", "IDTYPEABONNEMENT");

}
	

	
	
	
	
	
}
