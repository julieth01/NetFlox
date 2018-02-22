package entities;

public class TypeAbonnement {

		private int idTypeAbonnement;
		private String libelleAbonnement;
		private double montant;
	
	
	//Constructeur sans paramètre
		public TypeAbonnement(){
			
		}
		
		//Constructeur avec parametre
		
		
		public TypeAbonnement(int idTypeAbonnement, String libelleAbonnement,
				double montant) {
			super();
			this.idTypeAbonnement = idTypeAbonnement;
			this.libelleAbonnement = libelleAbonnement;
			this.montant = montant;
		}


		public int getIdTypeAbonnement() {
			return idTypeAbonnement;
		}

		public void setIdTypeAbonnement(int idTypeAbonnement) {
			this.idTypeAbonnement = idTypeAbonnement;
		}
		
		public String getLibelleAbonnement() {
			return libelleAbonnement;
		}
		
		public void setLibelleAbonnement(String libelleAbonnement) {
			this.libelleAbonnement = libelleAbonnement;
		}
		
		public double getMontant() {
			return montant;
		}
		
		public void setMontant(double montant) {
			this.montant = montant;
		}
	
	
		
}
