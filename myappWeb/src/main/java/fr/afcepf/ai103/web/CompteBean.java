package fr.afcepf.ai103.web;

import fr.afcepf.ai103.data.Compte;
import fr.afcepf.ai103.data.Operation;
import fr.afcepf.ai103.service.ServiceCompte;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;

@ManagedBean
@SessionScoped

public class CompteBean {

	private ServiceCompte servciceCompte = new ServiceCompte();

	private Long numClient = null;
	private Long numCptDebiteur = null;
	private Long numCptCrediteur = null;
	private Double montant = null;

	private List<Compte> comptes = null;
	private List<Operation> operations = null;

	private Long selectedNumCompte = null;

	public CompteBean() {
		operations = new ArrayList<Operation>();
	}

	public Long getSelectedNumCompte() {
		return selectedNumCompte;
	}

	public void setSelectedNumCompte(Long selectedNumCompte) {
		this.selectedNumCompte = selectedNumCompte;
	}

	// Méthode appelée après que le numClient soit automatiquement mis à jour par
	// JSF
	public void initComptes(ComponentSystemEvent event) {
		comptes = servciceCompte.comptesDuClient(numClient);
	}

	public void onSelectCompte(ActionEvent event) {
		operations = servciceCompte.oprationDuCompte(numClient);
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

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public String effectuerVirement() {
		String suite = "";
		servciceCompte.transferer(montant, numCptDebiteur, numCptCrediteur);
		comptes = servciceCompte.comptesDuClient(numClient);
		suite = "comptes";

		return suite;

	}
}
