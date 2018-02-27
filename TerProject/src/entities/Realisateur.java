package entities;

public class Realisateur {
	
	private int idVideo;
	private int idParticipant;
	
	
	public Realisateur(int idVideo, int idParticipant) {
		super();
		this.idVideo = idVideo;
		this.idParticipant = idParticipant;
	}


	public int getIdVideo() {
		return idVideo;
	}


	public void setIdVideo(int idVideo) {
		this.idVideo = idVideo;
	}


	public int getIdParticipant() {
		return idParticipant;
	}


	public void setIdParticipant(int idParticipant) {
		this.idParticipant = idParticipant;
	}


}


