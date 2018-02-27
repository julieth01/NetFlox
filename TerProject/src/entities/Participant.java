package entities;

public class Participant {

	private int idParticipant;
	private String nomParticipant;
	private String prenomParticipant;
	
	
	//Constructeur sans parametre
	public Participant(){
		
	}

	//Constructeur avec parameètre
	public Participant(int idParticipant, String nomParticipant,
			String prenomParticipant) {
		super();
		this.idParticipant = idParticipant;
		this.nomParticipant = nomParticipant;
		this.prenomParticipant = prenomParticipant;
	}

	public int getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(int idParticipant) {
		this.idParticipant = idParticipant;
	}

	public String getNomParticipant() {
		return nomParticipant;
	}

	public void setNomParticipant(String nomParticipant) {
		this.nomParticipant = nomParticipant;
	}

	public String getPrenomParticipant() {
		return prenomParticipant;
	}

	public void setPrenomParticipant(String prenomParticipant) {
		this.prenomParticipant = prenomParticipant;
	}
	
}
