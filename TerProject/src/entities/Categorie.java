package entities;

public class Categorie {

	private int idCategorie;
	private String libelleCategorie;
	
	//Constructeur sans parametre
	public Categorie(){
		
	}
	
	//Constructeur avec paramètre
	public Categorie(int idCategorie, String libelleCategorie) {
		super();
		this.idCategorie = idCategorie;
		this.libelleCategorie = libelleCategorie;
	}
	
	
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getLibelleCategorie() {
		return libelleCategorie;
	}
	public void setLibelleCategorie(String libelleCategorie) {
		this.libelleCategorie = libelleCategorie;
	}

}
