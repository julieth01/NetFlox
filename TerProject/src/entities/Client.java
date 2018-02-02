package entities;

//Auteur: OUMAROU KABORE

public class Client {
	
	private int idClient;
	private String nomClient;
	private String prenomClient;
	private String adresseClient;
	private String motPasse;
	private String email;
	private String tel;
	
	// Constructeur sans parametre
	public Client(){
		
	}
	
	//Constructeur avec parametre
	public Client(int idClient, String nomClient, String prenomClient, String adresseClient, String motPasse, String email, String tel){
		this.idClient=idClient;
		this.nomClient=nomClient;
		this.prenomClient=prenomClient;
		this.adresseClient=adresseClient;
		this.motPasse=motPasse;
		this.email=email;
		this.tel=tel;
	}
	
	//Getters and Setters
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getAdresseClient() {
		return adresseClient;
	}
	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (adresseClient == null) {
			if (other.adresseClient != null)
				return false;
		} else if (!adresseClient.equals(other.adresseClient))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idClient != other.idClient)
			return false;
		if (motPasse == null) {
			if (other.motPasse != null)
				return false;
		} else if (!motPasse.equals(other.motPasse))
			return false;
		if (nomClient == null) {
			if (other.nomClient != null)
				return false;
		} else if (!nomClient.equals(other.nomClient))
			return false;
		if (prenomClient == null) {
			if (other.prenomClient != null)
				return false;
		} else if (!prenomClient.equals(other.prenomClient))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((adresseClient == null) ? 0 : adresseClient.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idClient;
		result = prime * result
				+ ((motPasse == null) ? 0 : motPasse.hashCode());
		result = prime * result
				+ ((nomClient == null) ? 0 : nomClient.hashCode());
		result = prime * result
				+ ((prenomClient == null) ? 0 : prenomClient.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient
				+ ", prenomClient=" + prenomClient + ", adresseClient="
				+ adresseClient + ", motPasse=" + motPasse + ", email=" + email
				+ ", tel=" + tel + "]";
	}
	
	
}
