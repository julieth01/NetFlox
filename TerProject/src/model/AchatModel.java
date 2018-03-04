package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import entities.Abonnement;
import entities.Achat;

public class AchatModel extends NetfloxDB {

	public AchatModel() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/*
	 * Methode permettant de verifier si le client a acheté la video
	 */
	public boolean verifAchatClient(int idClient,int idVideo){
		
		try{
			
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM ACHAT WHERE idClient="+idClient+" AND idVideo="+ idVideo);
			Achat achat;
			Vector<Achat> listAchat=new Vector<>();
			while(rs.next()){
				achat=new Achat();
				achat.setIdClient(rs.getInt("idClient"));
				achat.setIdVideo(rs.getInt("idVideo"));
				
				listAchat.add(achat);
			}
			if(!listAchat.isEmpty()){
				return true;
			}
		}catch(Exception e){}
		
		return false;
		
	}
	
	
	
}
