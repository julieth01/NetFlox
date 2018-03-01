package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import entities.Client;
import entities.Serie;

public class SerieModel extends NetfloxDB {

	public SerieModel() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/*
	 * Selectionne la serie dont l'idSerie est en parametre
	 * si idSerie=null, retourne la liste de toutes les series
	 */
	public Vector<Serie> selectSerie(Integer idSerie){
		
			Vector<Serie> listSerie=new Vector<>();
			try{
			Statement st= conn.createStatement();
			ResultSet rs;
				if(idSerie==null){
					rs=st.executeQuery("SELECT * FROM SERIE ");
				}else{
					rs=st.executeQuery("SELECT * FROM SERIE WHERE IDSERIE= "+idSerie);
				}
				
			Serie serie;
			while(rs.next()){
				serie=new Serie();
				serie.setIdSerie(rs.getInt("idSerie"));
				serie.setNbSaison(rs.getInt("nbSaison"));
				serie.setResume(rs.getString("resume"));
				serie.setDateSortie(rs.getDate("dateSortie"));
				serie.setTitreSerie(rs.getString("titreSerie"));
				
				
				GenreModel genreModel=new GenreModel();
				serie.setIdGenre(genreModel.selectGenre(rs.getInt("idGenre")).get(0));
				
				listSerie.add(serie);
			
			}
				
			}catch(Exception e){
				System.out.println("Erreur de connexion ");
			}
			
		return listSerie;
	}
	
	/*
	 * Méthode pour sauvegarder une serie
	 */
	
	public void saveSerie(String titre, int idGenre, int nbSaison, Date dateSortie, String resume){
		
		try
		{
			System.out.println("***************** DEBUT INSERTION**************");
			
			PreparedStatement st=conn.prepareStatement("INSERT INTO SERIE( titreSerie,idGenre, nbSaison,dateSortie,resume) VALUES (?,?,?,?,?) ");
			st.setString(1, titre);
			st.setInt(2, idGenre);
			st.setInt(3, nbSaison);
			st.setDate(4, dateSortie);
			st.setString(5, resume);
			int result=st.executeUpdate();
			if(result==1){
				System.out.println("Insertion reussie");
			}else{
				System.out.println("Insertion echouée");
			}
		}catch(Exception e){System.out.println(e.getMessage());}
		
		
	}
	

public boolean deleteId(int idSerie) {
	// TODO Auto-generated method stub
	return super.deleteId(idSerie, "SERIE", "IDSERIE");
}
	
	
}
