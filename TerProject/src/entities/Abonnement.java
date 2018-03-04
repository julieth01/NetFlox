package entities;

import java.sql.Date;

public class Abonnement {
private int idAbonnement;
private int typeAbonnement;
private int idClient;
private Date dateDebut;
private Date dateFin;
private int idCarteBancaire;


public int getIdAbonnement() {
	return idAbonnement;
}
public void setIdAbonnement(int idAbonnement) {
	this.idAbonnement = idAbonnement;
}
public int getTypeAbonnement() {
	return typeAbonnement;
}
public void setTypeAbonnement(int typeAbonnement) {
	this.typeAbonnement = typeAbonnement;
}
public int getIdClient() {
	return idClient;
}
public void setIdClient(int idClient) {
	this.idClient = idClient;
}
public Date getDateDebut() {
	return dateDebut;
}
public void setDateDebut(Date dateDebut) {
	this.dateDebut = dateDebut;
}
public Date getDateFin() {
	return dateFin;
}
public void setDateFin(Date dateFin) {
	this.dateFin = dateFin;
}
public int getIdCarteBancaire() {
	return idCarteBancaire;
}
public void setIdCarteBancaire(int idCarteBancaire) {
	this.idCarteBancaire = idCarteBancaire;
}

}
