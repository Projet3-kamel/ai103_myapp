package fr.afcepf.ai103.web;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;

import fr.afcepf.ai103.data.Compte;
import fr.afcepf.ai103.data.Operation;
import fr.afcepf.ai103.service.ServiceCompte;

@ManagedBean
@SessionScoped
public class CompteBean {

	private Long numClient = null;
	@EJB // @EJB demande au serveur d'initialiser la variable serviceCompte
	// pour référencer un EJB exitant compatible avec l'interface ou la classe

	private ServiceCompte serviceCompte = new ServiceCompte();

	// avec get/set
	private Long numCptDeb = null; // à selectionner dans liste déroulante dans virement.xhtml
	private Long numCptCred = null; // à selectionner dans liste déroulante dans virement.xhtml
	private Double montant = null; // à saisir dans virement.xhtml

	private List<Compte> comptes; // à afficher sous forme de tableau (h:dataTable)
	private List<Operation> operations; // à afficher sous forme de tableau (h:dataTable)

	private Long selectedNumCompte = null; // +get/set

	public String onSelectCompteAction() {
		System.out.println("dans onSelectCompteAction() , selectedNumCompte= " + selectedNumCompte);
		operations = serviceCompte.operationsDuCompte(selectedNumCompte);
		return operations.toString();
	}

	// constructeur par défaut:
	public CompteBean() {
		operations = new ArrayList<Operation>();
	}

	// méthode appelée après que numClient soit automatiquement mis à jour par JSF
	public void initComptes(ComponentSystemEvent event) {
		comptes = serviceCompte.comptesDuClient(numClient);

		// test temporaire
		this.operations = serviceCompte.operationsDuCompte(numClient);
	}

	public String effectuerVirement() {
		String suite = null;
		// effectuer le virement
		serviceCompte.transferer(montant, numCptDeb, numCptCred);
		// recharger en mémoire les nouveaux soldes qui ont évolués et qui seront
		// ré-afficher
		comptes = serviceCompte.comptesDuClient(numClient);
		// demander à naviguer vers comptes.xhtml pour réafficher les nouveaux soldes:
		suite = "comptes"; // .xhtml
		return suite;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public Long getNumClient() {
		return numClient;
	}

	public void setNumClient(Long numClient) {
		this.numClient = numClient;
	}

	public Long getNumCptDeb() {
		return numCptDeb;
	}

	public void setNumCptDeb(Long numCptDeb) {
		this.numCptDeb = numCptDeb;
	}

	public Long getNumCptCred() {
		return numCptCred;
	}

	public void setNumCptCred(Long numCptCred) {
		this.numCptCred = numCptCred;
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

	public Long getSelectedNumCompte() {
		return selectedNumCompte;
	}

	public void setSelectedNumCompte(Long selectedNumCompte) {
		this.selectedNumCompte = selectedNumCompte;
	}

}