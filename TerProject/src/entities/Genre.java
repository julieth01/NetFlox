package entities;

public class Genre {
	private int idGenre;
	private String libelleGenre;
	
	
	//Construteur sans parametre
	public Genre(){
		
	}
	
	
	//Constructeur avec parametre
	public Genre(int idGenre, String libelleGenre) {
		super();
		this.idGenre = idGenre;
		this.libelleGenre = libelleGenre;
	}


	public int getIdGenre() {
		return idGenre;
	}


	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
	}


	public String getLibelleGenre() {
		return libelleGenre;
	}


	public void setLibelleGenre(String libelleGenre) {
		this.libelleGenre = libelleGenre;
	}
	
	
}
