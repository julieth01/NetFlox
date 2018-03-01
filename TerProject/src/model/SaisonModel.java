package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import entities.Saison;
import entities.Serie;

public class SaisonModel extends NetfloxDB {

	public SaisonModel() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Vector<Saison> selectSaison(Integer idSerie){
		
		Vector<Saison> listSaison=new Vector<>();
		try{
		Statement st= conn.createStatement();
		ResultSet rs;
			if(idSerie==null){
				rs=st.executeQuery("SELECT * FROM SAISON ");
			}else{
				rs=st.executeQuery("SELECT * FROM SAISON WHERE IDSERIE= "+idSerie);
			}
			
		Saison saison;
		while(rs.next()){
			saison=new Saison();
			
			saison.setIdSaison(rs.getInt("idSaison"));
			saison.setIdSerie(rs.getInt("idSerie"));
			saison.setLibelleSaison(rs.getString("libelleSaison"));
			saison.setNbEpisode(rs.getInt("nbEpisode"));
		
			listSaison.add(saison);
		
		}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	return listSaison;
}

	public void saveSaison(String libelleSaison,int idSerie, int nbEpisode){
		
		try
		{
			System.out.println("***************** DEBUT INSERTION**************");
			
			PreparedStatement st=conn.prepareStatement("INSERT INTO SAISON( libelleSaison,idSerie, nbEpisode) VALUES (?,?,?) ");
			st.setString(1, libelleSaison);
			st.setInt(2, idSerie);
			st.setInt(3, nbEpisode);
			
			int result=st.executeUpdate();
			if(result==1){
				System.out.println("Insertion reussie");
			}else{
				System.out.println("Insertion echouée");
			}
		}catch(Exception e){System.out.println(e.getMessage());}
		
		
	}
	

	
	
    public boolean deleteId(int idSaison) {
    	return super.deleteId(idSaison, "Saison", "idSaison");
    }
    
    /*
     * Supprimer une saison connaissant l'idSerie
     */
    public void deleteSaison(int idSerie){
    	
    	try{
    		Statement st=conn.createStatement();
    		st.executeUpdate("DELETE FROM SAISON WHERE idSerie="+ idSerie);
    	}catch(Exception e){}
    }

}
