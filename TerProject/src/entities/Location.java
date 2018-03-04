package entities;

import java.sql.Date;

public class Location {
	
	private int idClient;
	private int idVideo;
	private Date dateLocation;
	private Date dateFinLocation;
	private int duree;
	private double montantLocation;
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public int getIdVideo() {
		return idVideo;
	}
	public void setIdVideo(int idVideo) {
		this.idVideo = idVideo;
	}
	public Date getDateLocation() {
		return dateLocation;
	}
	public void setDateLocation(Date dateLocation) {
		this.dateLocation = dateLocation;
	}
	public Date getDateFinLocation() {
		return dateFinLocation;
	}
	public void setDateFinLocation(Date dateFinLocation) {
		this.dateFinLocation = dateFinLocation;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public double getMontantLocation() {
		return montantLocation;
	}
	public void setMontantLocation(double montantLocation) {
		this.montantLocation = montantLocation;
	}


}
