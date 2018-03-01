package entities;

import java.sql.Date;

public class Serie {
	
	private int idSerie;
	private Genre idGenre;
	private String titreSerie;
	private int nbSaison;
	private Date dateSortie;
	private  String resume;
	
	
	public int getIdSerie() {
		return idSerie;
	}
	
	public void setIdSerie(int idSerie) {
		this.idSerie = idSerie;
	}
	public Genre getIdGenre() {
		return idGenre;
	}
	public void setIdGenre(Genre idGenre) {
		this.idGenre = idGenre;
	}
	public String getTitreSerie() {
		return titreSerie;
	}
	public void setTitreSerie(String titreSerie) {
		this.titreSerie = titreSerie;
	}
	public int getNbSaison() {
		return nbSaison;
	}
	public void setNbSaison(int nbSaison) {
		this.nbSaison = nbSaison;
	}
	public Date getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	
}
