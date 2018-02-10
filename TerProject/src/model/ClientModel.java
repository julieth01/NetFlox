package model;

//Auteur: OUMAROU KABORE

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import entities.Client;


public class ClientModel extends NetfloxDB {
	

	
	public ClientModel() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/*
	 * Selectionne le client dont l'idClient est en parametre
	 * si idClient=null, retourne la liste de tous les clients
	 */
	public Vector<Client> selectClient(Integer idClient){
		
			Vector<Client> listClient=new Vector<>();
			try{
			Statement st= conn.createStatement();
			ResultSet rs;
				if(idClient==null){
					rs=st.executeQuery("SELECT * FROM CLIENT ");
				}else{
					rs=st.executeQuery("SELECT * FROM CLIENT WHERE idClient= "+idClient);
				}
				
			Client client;
			while(rs.next()){
				
				client=new Client();
				client.setIdClient(rs.getInt("idClient"));
				client.setNomClient(rs.getString("nomAdmin"));
				client.setPrenomClient(rs.getString("prenomAdmin"));
				client.setEmail(rs.getString("email"));
				client.setTel(rs.getString("tel"));
				listClient.add(client);
			
			}
				
			}catch(Exception e){
				System.out.println("Erreur de connexion ");
			}
			
		return listClient;
	}
	
	
	public Vector<Client> verifConnexion(String email, String password){
	
		Vector<Client> listClient=new Vector<>();
		try{
			PreparedStatement st= conn.prepareStatement("SELECT * FROM CLIENT  c WHERE c.email=? AND c.motpasse=?");
			st.setString(1, email);
			st.setString(2, password);
		    ResultSet rs=st.executeQuery();
			
			Client client;
			while(rs.next()){
				client=new Client();
				client.setIdClient(rs.getInt("idClient"));
				client.setNomClient(rs.getString("nomAdmin"));
				client.setPrenomClient(rs.getString("prenomAdmin"));
				client.setEmail(rs.getString("email"));
				client.setTel(rs.getString("tel"));
				listClient.add(client);
			}
		
		}catch(Exception e){
			
		}
		return listClient;
	}
	
	/*
	 * Méthode pour sauvegarder un client
	 */
	
	public void saveClient(String nom, String prenom, String email, String tel, String password ){
		
		try
		{
			System.out.println("***************** DEBUT INSERTION**************");
			
			PreparedStatement st=conn.prepareStatement("INSERT INTO CLIENT( nomadmin,prenomadmin,email,tel,motpasse) VALUES (?,?,?,?,?) ");
			st.setString(1, nom);
			st.setString(2, prenom);
			st.setString(3, email);
			st.setString(4, tel);
			st.setString(5, password);
			int result=st.executeUpdate();
			if(result==1){
				System.out.println("Insertion reussie");
			}else{
				System.out.println("Insertion echouée");
			}
		}catch(Exception e){System.out.println(e.getMessage());}
		
		
	}
	
	/*
	 * Methode pour faire la mise à  jour d'un client
	 */
	public void updateClient(Client client){
		
	}
	
	/*
	 * Appele la methode deleteId de NetfloxDB en changeant les 
	 * parametres sur le nom de la table et le nom de id
	 */
	public boolean deleteId(int id) {
		return super.deleteId(id,"Client","idClient");
	}
	
	/*
	 *Appele la methode deleteAll de NetFloxDB en précisant le table
	 */
	public boolean deleteAll( ){
	
		return super.deleteAll("Client");
	}
	

	/* Methode pour supprimer un client 
	 * de la base de données en utilisant son id
	
	public void deleteClient(int id){
		try{
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("DELETE FROM CLIENT WHERE idClient="+id);
		}catch(Exception e){
			
		}
	
	}
	*/
	

}
