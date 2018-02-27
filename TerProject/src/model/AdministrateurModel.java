package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import entities.Administrateur;

public class AdministrateurModel extends NetfloxDB {

	public AdministrateurModel() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/*
	 * Selectionne le Administrateur dont l'idAdministrateur est en parametre
	 * si idAdministrateur=null, retourne la liste de tous les Administrateurs
	 */
	public Vector<Administrateur> selectAdministrateur(Integer idAdmin){
		
			Vector<Administrateur> listAdministrateur=new Vector<>();
			try{
			Statement st= conn.createStatement();
			ResultSet rs;
				if(idAdmin==null){
					rs=st.executeQuery("SELECT * FROM Administrateur ");
				}else{
					rs=st.executeQuery("SELECT * FROM Administrateur WHERE idAdmin= "+idAdmin);
				}
				
			Administrateur administrateur;
			while(rs.next()){
				
				administrateur=new Administrateur();
				administrateur.setIdAdmin(rs.getInt("idAdmin"));
				administrateur.setNomAdmin(rs.getString("nomAdmin"));
				administrateur.setPrenomAdmin(rs.getString("prenomAdmin"));
				administrateur.setEmail(rs.getString("email"));
				listAdministrateur.add(administrateur);
			
			}
				
			}catch(Exception e){
				System.out.println("Erreur de connexion ");
			}
			
		return listAdministrateur;
	}
	
	
	//Methode permettant de verifier les parameètre de connexion d'un Administrateur
	public Vector<Administrateur> verifConnexion(String email, String password){
	
		Vector<Administrateur> listAdministrateur=new Vector<>();
		try{
			PreparedStatement st= conn.prepareStatement("SELECT * FROM Administrateur  a WHERE a.email=? AND a.motpasse=?");
			st.setString(1, email);
			st.setString(2, password);
		    ResultSet rs=st.executeQuery();
			
			Administrateur administrateur;
			while(rs.next()){
				administrateur=new Administrateur();
				administrateur.setIdAdmin(rs.getInt("idAdministrateur"));
				administrateur.setNomAdmin(rs.getString("nomAdministrateur"));
				administrateur.setPrenomAdmin(rs.getString("prenomAdministrateur"));
				administrateur.setEmail(rs.getString("email"));

				listAdministrateur.add(administrateur);
			}
		
		}catch(Exception e){
			
		}
		return listAdministrateur;
	}
	
	/*
	 * Méthode pour sauvegarder un Administrateur
	 */
	
	public void saveAdministrateur(String nom, String prenom, String email, String password ){
		
		try
		{
			System.out.println("***************** DEBUT INSERTION**************");
			
			PreparedStatement st=conn.prepareStatement("INSERT INTO Administrateur( nomAdmin,prenomAdmin,email,motpasse) VALUES (?,?,?,?) ");
			st.setString(1, nom);
			st.setString(2, prenom);
			st.setString(3, email);
			st.setString(4, password);
			int result=st.executeUpdate();
			if(result==1){
				System.out.println("Insertion reussie");
			}else{
				System.out.println("Insertion echouée");
			}
		}catch(Exception e){System.out.println(e.getMessage());}
		
		
	}
	
	/*
	 * Methode pour faire la mise à  jour d'un Administrateur
	 */
	public void updateAdministrateur(Administrateur administrateur){
		
		try{
			
			PreparedStatement st=conn.prepareStatement("UPDATE Administrateur SET nomAdmin=?, prenomAdmin=?, email=? WHERE IDAdmin=?");
			st.setString(1, administrateur.getNomAdmin());
			st.setString(2, administrateur.getPrenomAdmin());
			st.setString(3, administrateur.getEmail());
			st.setInt(4, administrateur.getIdAdmin());
			
			st.executeUpdate();
			
		}catch(Exception e){ }
		
		
	}
	
	/*
	 * Appele la methode deleteId de NetfloxDB en changeant les 
	 * parametres sur le nom de la table et le nom de id
	 */
	public boolean deleteId(int id) {
		return super.deleteId(id,"Administrateur","idAdmin");
	}
	
	/*
	 *Appele la methode deleteAll de NetFloxDB en précisant le table
	 */
	public boolean deleteAll( ){
	
		return super.deleteAll("Administrateur");
	}
	

	/* Methode pour supprimer un Administrateur 
	 * de la base de données en utilisant son id
	
	public void deleteAdministrateur(int id){
		try{
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("DELETE FROM Administrateur WHERE idAdministrateur="+id);
		}catch(Exception e){
			
		}
	
	}
	*/

}
