package fr.afcepf.ai103.web;

import fr.afcepf.ai103.data.Compte;
import fr.afcepf.ai103.service.ServiceCompte;

import java.util.List;

import javax.faces.bean.ManagedBean ; 
import javax.faces.bean.SessionScoped;

@ManagedBean    
@SessionScoped

public class CompteBean {
	
	private Long numClient = 1L;
	private ServiceCompte servciceCompte = new ServiceCompte();
	private List<Compte> comptes;
	
	public CompteBean() {
		comptes = servciceCompte.comptesDuClient(numClient);
	}

	public Long getNumClient() {
		return numClient;
	}

	public void setNumClient(Long numClient) {
		this.numClient = numClient;
	}

	public ServiceCompte getServciceCompte() {
		return servciceCompte;
	}

	public void setServciceCompte(ServiceCompte servciceCompte) {
		this.servciceCompte = servciceCompte;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	

	private Long numCptDebiteur =null;
	private Long numCptCrediteur =null;
	private Double montant =null;

	public Long getNumCptDebiteur() {
		return numCptDebiteur;
	}

	public void setNumCptDebiteur(Long numCptDebiteur) {
		this.numCptDebiteur = numCptDebiteur;
	}

	public Long getNumCptCrediteur() {
		return numCptCrediteur;
	}

	public void setNumCptCrediteur(Long numCptCrediteur) {
		this.numCptCrediteur = numCptCrediteur;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}
	
	public String effectuerVirement() {
		String suite="";
		servciceCompte.transferer(montant, numCptDebiteur, numCptCrediteur);
		comptes = servciceCompte.comptesDuClient(numClient);
		suite="comptes";
		
		return suite;
		
	}
}
