package model;

//Auteur: OUMAROU KABORE

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class NetfloxDB {

	
	protected Connection conn;

	public NetfloxDB() throws ClassNotFoundException, SQLException{
		
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/netflox","postgres","admin");
		
	}

	@Override
	protected void finalize(){
		try{
			if(conn!=null && !conn.isClosed()){
				conn.close();
			}
		}catch(Exception e){}
	}

	
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	/*
	 * Supprimer une ligne dont id est passé en parametre dans une table
	 * dont le nom est passé en paramètre.
	 */
	
	public boolean deleteId(int id, String tableName, String tableIdName){
		try{
			Statement st=conn.createStatement();
			int nbDelete=st.executeUpdate("DELETE FROM "+ tableIdName +" WHERE "+ tableIdName +" = "+id);
			if(nbDelete>0){
				return true;
			}
		}catch(Exception e){}
		
		return false;
	}
	
	/*
	 * Methode pour supprimer vider une table dont le nom est passé en parametre
	 */
	public boolean deleteAll(String tableName){
		try{
			Statement st=conn.createStatement();
			int nbUpdate=st.executeUpdate("DELETE FROM "+tableName);
			if(nbUpdate>0){
				return true;
			}
		}catch(Exception e){}
		return false;
	}
}
