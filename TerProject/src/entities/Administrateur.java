package entities;

public class Administrateur {
	
	private Integer idAdmin;
	private String nomAdmin;
	private String prenomAdmin;
	private String pseudo;
	private String motPase;
	private String adresse;
	private String email;
	
	
	
	public Integer getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getNomAdmin() {
		return nomAdmin;
	}
	public void setNomAdmin(String nomAdmin) {
		this.nomAdmin = nomAdmin;
	}
	public String getPrenomAdmin() {
		return prenomAdmin;
	}
	public void setPrenomAdmin(String prenomAdmin) {
		this.prenomAdmin = prenomAdmin;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getMotPase() {
		return motPase;
	}
	public void setMotPase(String motPase) {
		this.motPase = motPase;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idAdmin == null) ? 0 : idAdmin.hashCode());
		result = prime * result + ((motPase == null) ? 0 : motPase.hashCode());
		result = prime * result
				+ ((nomAdmin == null) ? 0 : nomAdmin.hashCode());
		result = prime * result
				+ ((prenomAdmin == null) ? 0 : prenomAdmin.hashCode());
		result = prime * result + ((pseudo == null) ? 0 : pseudo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrateur other = (Administrateur) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idAdmin == null) {
			if (other.idAdmin != null)
				return false;
		} else if (!idAdmin.equals(other.idAdmin))
			return false;
		if (motPase == null) {
			if (other.motPase != null)
				return false;
		} else if (!motPase.equals(other.motPase))
			return false;
		if (nomAdmin == null) {
			if (other.nomAdmin != null)
				return false;
		} else if (!nomAdmin.equals(other.nomAdmin))
			return false;
		if (prenomAdmin == null) {
			if (other.prenomAdmin != null)
				return false;
		} else if (!prenomAdmin.equals(other.prenomAdmin))
			return false;
		if (pseudo == null) {
			if (other.pseudo != null)
				return false;
		} else if (!pseudo.equals(other.pseudo))
			return false;
		return true;
	}
	
	
	
	

}
