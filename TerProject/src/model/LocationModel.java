package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Vector;



import entities.Abonnement;
import entities.Location;

public class LocationModel extends NetfloxDB {

	public LocationModel() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/*
	 * Methode permettant de verifier si le client à louer la video pour une durée donnée
	 */
	public boolean verifLocationClient(int idClient, int idVideo){
		
		try{
			
			java.sql.Date dateSystem = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM LOCATION  WHERE idClient="+idClient+ " AND idVideo="+ idVideo+" AND dateFinLocation <"+ dateSystem);
			Location location;
			Vector<Location> listLocation=new Vector<>();
			
			while(rs.next()){
				location=new entities.Location();
				
				location.setIdClient(rs.getInt(idClient));
				
				listLocation.add(location);
			}
			if(!listLocation.isEmpty()){
				return true;
			}
		}catch(Exception e){}
		
		return false;
		
	}
	
	
	
}
