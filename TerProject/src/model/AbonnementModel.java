package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import entities.Abonnement;

public class AbonnementModel  extends NetfloxDB{

	public AbonnementModel() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}


	/*
	 * Methode permettant de verifier si le client est prenium ou pas
	 */
	public boolean verifAbonnementClient(int idClient){
		
		try{
			
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM ABONNEMENT WHERE idClient="+idClient);
			Abonnement abonnement;
			Vector<Abonnement> listAbonnement=new Vector<>();
			while(rs.next()){
				abonnement=new Abonnement();
				abonnement.setIdAbonnement(rs.getInt("idAbonnement"));
				listAbonnement.add(abonnement);
			}
			if(!listAbonnement.isEmpty()){
				return true;
			}
		}catch(Exception e){}
		
		return false;
		
	}
	
	
}
