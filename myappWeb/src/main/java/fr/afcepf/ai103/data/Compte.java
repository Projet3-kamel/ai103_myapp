package fr.afcepf.ai103.data;

public class Compte {
	private Long numCompte;
	private String label;
	private Double solde;
	
	
	
	public Compte() {
		super();
	}
	
	public Long getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(Long numCompte) {
		this.numCompte = numCompte;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double d) {
		this.solde = d;
	}
	

}	


