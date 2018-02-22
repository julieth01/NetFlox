package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import entities.Categorie;
import entities.Genre;

public class GenreModel extends NetfloxDB {

	public GenreModel() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/*
	 * Selectionne le Genre dont l'idGenre est en parametre
	 * si idGenre=null, retourne la liste de tous les Genre
	 */
	public Vector<Genre> selectGenre(Integer idGenre){
		
			Vector<Genre> listGenre=new Vector<>();
			try{
			Statement st= conn.createStatement();
			ResultSet rs;
				if(idGenre==null){
					rs=st.executeQuery("SELECT * FROM GENRE ");
				}else{
					rs=st.executeQuery("SELECT * FROM GENRE WHERE idGenre= "+idGenre);
				}
				
			Genre genre;
			while(rs.next()){
				
				genre=new Genre();
				genre.setIdGenre(rs.getInt("idGenre"));
				genre.setLibelleGenre(rs.getString("libelleGenre"));
				listGenre.add(genre);
			
			}
				
			}catch(Exception e){
				System.out.println(e.getStackTrace());
			}
			
		return listGenre;
	}
	
	
	//Methode permettant d'enregistrer un genre de video dans la base de données
	public void saveGenre(String libelleGenre){
		
		try {
			PreparedStatement st=conn.prepareStatement("INSERT INTO GENRE(libelleGenre) VALUES(?)");
			st.setString(1, libelleGenre);
			st.executeUpdate();
		} catch (Exception e) {
			
		}
	}
	
	//Mise à jour d'une categorie
	
	public void updateGenre(Genre genre){
		
		try {
			PreparedStatement st=conn.prepareStatement("UPDATE GENRE SET LIBELLEGENRE=? WHERE IDGENRE=?");
			st.setString(1, genre.getLibelleGenre());
			st.setInt(2, genre.getIdGenre());
			st.executeUpdate();
			
		} catch (Exception e) {System.out.println(e.getMessage());}

	}
	
//Suppression d'une categorie
public boolean deleteId(Integer idGenre){
	
	return 	super.deleteId(idGenre, "GENRE", "IDGENRE");

}
	
	
}
