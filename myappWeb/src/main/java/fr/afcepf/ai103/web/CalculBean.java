package fr.afcepf.ai103.web;

import javax.faces.bean.ManagedBean ; 
import javax.faces.bean.RequestScoped; 
@ManagedBean    
@RequestScoped

public class CalculBean {
	
	private Double saisie;
	private Double resultat;
	
	public String calculerRacine() {
		this.resultat = Math.sqrt(this.saisie);
		return null;	//return null pour rester sur la même page.
	}

	public Double getSaisie() {
		return saisie;
	}
	public void setSaisie(Double saisie) {
		this.saisie = saisie;
	}
	public Double getResultat() {
		return resultat;
	}
	public void setResultat(Double resultat) {
		this.resultat = resultat;
	}
	
	

}
