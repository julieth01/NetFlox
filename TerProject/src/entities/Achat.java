package entities;

import java.sql.Date;

public class Achat {

	private int idClient;
	private int idVideo;
	private Date  dateAchat;
	
	
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
	public Date getDateAchat() {
		return dateAchat;
	}
	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
	
	
	
	
	
	
}
