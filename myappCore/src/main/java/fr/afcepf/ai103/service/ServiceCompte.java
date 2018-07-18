package fr.afcepf.ai103.service;

import java.util.ArrayList;
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
		listeComptes.add(daoCompte.rechercherCompteParNumero(1L));
		listeComptes.add(daoCompte.rechercherCompteParNumero(2L));

		return listeComptes;
	}
	/*
	 * Varainte A exploitant le lien "@OneToMany
	 * 
	 * 
	 * // Lorsque cette méthode est exécutée dans Jboss, il faudra que Jboss
	 * initialise // un début de transaction. et pour cela "entityManager" doit par
	 * fois être créé // au même moment
	 * 
	 * 
	 * public List<Operation> operationsDuCompte(Long numCompte) { Compte cpt =
	 * daoCompte.rechercherCompteParNumero(numCompte); for (Operation op :
	 * cpt.getDernieresOperations()) { // pour éviter l'exception } int n =
	 * cpt.getDernieresOperations().size(); // temporaire pour eviter lazy exception
	 * // Soit via une boucle for ou bien via un appel à .size() on provoque //
	 * volontairement une remontée immédiate des valeurs de la table "Operation" //
	 * vers des objets de la liste "getDernieresOperations()" avant qu'entityManger
	 * // ne soit trop tard de le faire System.out.println("le compte " + numCompte
	 * + " a " + n); return cpt.getDernieresOperations(); // à la fin de l'exécution
	 * de cette méthode Jboss déclenche automatiquement // cmmit, si tout va bien
	 * sinon un rollback (exception) // parfois le "entityManger" est fermé ici (si
	 * il avait été créé dans le haut de // cette méthode)
	 * 
	 * }
	 */

	/*
	 * Variante 2 s'appuyant sur une requête spécifique du DAO
	 */
	public List<Operation> operationsDuCompte(Long numClient) {

		return daoCompte.getDernieresOperations(numClient);
	}

}