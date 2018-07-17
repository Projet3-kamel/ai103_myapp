package fr.afcepf.ai103.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import fr.afcepf.ai103.dao.IDaoCompte;
import fr.afcepf.ai103.data.Compte;
import fr.afcepf.ai103.data.Operation;

@Stateless
@Local
// avec transactions automatiques sur toutes les méthodes dont transferer()
public class ServiceCompte {
	@EJB
	private IDaoCompte daoCompte;

	public void transferer(double montant, long numCptDeb, long numCptCred) {
		Compte cptDeb = daoCompte.rechercherCompteParNumero(numCptDeb);
		cptDeb.setSolde(cptDeb.getSolde() - montant);
		Compte cptCred = daoCompte.rechercherCompteParNumero(numCptCred);
		cptCred.setSolde(cptCred.getSolde() + montant);
	}

	public List<Compte> comptesDuClient(Long numClient) {
		List<Compte> listeComptes = new ArrayList<Compte>();
		// temporairement en attendant le lien compte-client :
		listeComptes.add(daoCompte.rechercherCompteParNumero(numClient));
		listeComptes.add(daoCompte.rechercherCompteParNumero(numClient));
		for (Compte compte : listeComptes) {
			System.out.println(compte.toString());
		}
		return listeComptes;
	}

	public List<Operation> operationsDuCompte(Long numCompte) {
		List<Operation> listeOperations = new ArrayList<Operation>();
		// simulation de valeurs récupérées en base:
		if (numCompte != null && (numCompte % 2) == 0) {
			listeOperations.add(new Operation(1L, new Date(), -30.0, "achat livres"));
			listeOperations.add(new Operation(2L, new Date(), -10.0, "achat dvd"));
		} else {
			listeOperations.add(new Operation(3L, new Date(), -35.0, "achat vetement"));
			listeOperations.add(new Operation(4L, new Date(), -18.0, "achat crème solaire"));
		}
		return listeOperations;
	}

}