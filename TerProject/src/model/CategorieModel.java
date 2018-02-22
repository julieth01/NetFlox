package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import entities.Categorie;


public class CategorieModel extends NetfloxDB {

	public CategorieModel() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Selectionne la categorie dont l'idCategorie est en parametre
	 * si idCategorie=null, retourne la liste de toutes les catégories
	 */
	public Vector<Categorie> selectCategorie(Integer idCategorie){
		
			Vector<Categorie> listCategorie=new Vector<>();
			try{
			Statement st= conn.createStatement();
			ResultSet rs;
				if(idCategorie==null){
					rs=st.executeQuery("SELECT * FROM CATEGORIE ");
				}else{
					rs=st.executeQuery("SELECT * FROM CATEGORIE WHERE idCategorie= "+idCategorie);
				}
				
			Categorie categorie;
			while(rs.next()){
				
				categorie=new Categorie();
				categorie.setIdCategorie(rs.getInt("idCategorie"));
				categorie.setLibelleCategorie(rs.getString("libelleCategorie"));
				listCategorie.add(categorie);
			
			}
				
			}catch(Exception e){
				System.out.println(e.getStackTrace());
			}
			
		return listCategorie;
	}
	
	
	//Methode permettant d'enregistrer une categorie de video dans la base de données
	public void saveCategorie(String libelleCategorie){
		
		try {
			PreparedStatement st=conn.prepareStatement("INSERT INTO CATEGORIE(libelleCategorie) VALUES(?)");
			st.setString(1, libelleCategorie);
			st.executeUpdate();
		} catch (Exception e) {
			
		}
	}
	
	//Mise à jour d'une categorie
	
	public void updateCategoire(Categorie categorie){
		
		try {
			PreparedStatement st=conn.prepareStatement("UPDATE CATEGORIE SET LIBELLECATEGORIE=? WHERE IDCATEGORIE=?");
			st.setString(1, categorie.getLibelleCategorie());
			st.setInt(2, categorie.getIdCategorie());
			st.executeUpdate();
			
		} catch (Exception e) {
			
		}
	}
	
//Suppression d'une categorie
public boolean deleteId(Integer idCategorie){
	
	return 	super.deleteId(idCategorie, "CATEGORIE", "IDCATEGORIE");

}
	

}
