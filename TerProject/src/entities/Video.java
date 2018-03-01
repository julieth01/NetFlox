package entities;

import java.util.Date;
import java.util.Vector;

public class Video {
	
	private int idVideo;
	private Genre idGenre;
	private Saison idSaison;
	private Categorie idCategorie;
	private String titre;
	private String duree;
	private int nbVue;
	private int nbTelechargement;
	private java.sql.Date dateSortie;
	private String anneeProduction;
	private String resume;
	private double prixVente;
	private String cheminAcces;
	private boolean estEpisode;
	private String imagePoster;
	
	private Vector<Acteur> listActeur;
	private Participant realisateur;
	

	
	public int getIdVideo() {
		return idVideo;
	}
	public void setIdVideo(int idVideo) {
		this.idVideo = idVideo;
	}
	public Genre getIdGenre() {
		return idGenre;
	}
	public void setIdGenre(Genre idGenre) {
		this.idGenre = idGenre;
	}
	public Saison getIdSaison() {
		return idSaison;
	}
	public void setIdSaison(Saison idSaison) {
		this.idSaison = idSaison;
	}
	public Categorie getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Categorie idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public int getNbVue() {
		return nbVue;
	}
	public void setNbVue(int nbVue) {
		this.nbVue = nbVue;
	}
	public int getNbTelechargement() {
		return nbTelechargement;
	}
	public void setNbTelechargement(int nbTelechargement) {
		this.nbTelechargement = nbTelechargement;
	}
	public Date getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(java.sql.Date dateSortie) {
		this.dateSortie = dateSortie;
	}
	public String getAnneeProduction() {
		return anneeProduction;
	}
	public void setAnneeProduction(String anneeProduction) {
		this.anneeProduction = anneeProduction;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public double getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}
	public String getCheminAcces() {
		return cheminAcces;
	}
	public void setCheminAcces(String cheminAcces) {
		this.cheminAcces = cheminAcces;
	}
	public boolean isEstEpisode() {
		return estEpisode;
	}
	public void setEstEpisode(boolean estEpisode) {
		this.estEpisode = estEpisode;
	}
	public Vector<Acteur> getListActeur() {
		return listActeur;
	}
	public void setListActeur(Vector<Acteur> listActeur) {
		this.listActeur = listActeur;
	}
	public Participant getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(Participant realisateur) {
		this.realisateur = realisateur;
	}
	public String getImagePoster() {
		return imagePoster;
	}
	public void setImagePoster(String imagePoster) {
		this.imagePoster = imagePoster;
	}
	
	
	
	

}
