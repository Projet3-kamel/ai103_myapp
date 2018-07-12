package fr.afcepf.ai103.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.afcepf.ai103.data.Compte;
import fr.afcepf.ai103.data.Operation;

public class ServiceCompte {

	private Map<Long, Compte> mapComptes = new HashMap<Long, Compte>();

	public ServiceCompte() {
		Compte cpt1 = new Compte();
		cpt1.setNumCompte(123456L);
		cpt1.setLabel("compte courant");
		cpt1.setSolde(500.0);
		mapComptes.put(cpt1.getNumCompte(), cpt1);

		Compte cpt2 = new Compte();
		cpt2.setNumCompte(987654L);
		cpt2.setLabel("livret A");
		cpt2.setSolde(2000.0);
		mapComptes.put(cpt2.getNumCompte(), cpt2);
	}

	public List<Compte> comptesDuClient(Long numClient) {

		List<Compte> listeComptes = new ArrayList<Compte>();
		// simulation de valeurs récupérées en base:
		listeComptes.add(mapComptes.get(123456L));
		listeComptes.add(mapComptes.get(987654L));

		return listeComptes;
	}

	public List<Operation> oprationDuCompte(long numCompte) {

		List<Operation> listeOperations = new ArrayList<Operation>();
		if (numCompte % 2 == 0) {
			listeOperations.add(new Operation(1L, new Date(), -30.0, "achat livre"));
			listeOperations.add(new Operation(2L, new Date(), -10.0, "achat DVD"));
		} else {
			listeOperations.add(new Operation(3L, new Date(), -15.0, "achat Mag"));
		}

		return listeOperations;
	}

	public void transferer(double montant, long numCptDebiteur, long numCptCrediteur) {
		Compte cptDebiteur = mapComptes.get(numCptDebiteur);
		Compte cptCrediteur = mapComptes.get(numCptCrediteur);

		cptDebiteur.setSolde(cptDebiteur.getSolde() - montant);
		cptCrediteur.setSolde(cptCrediteur.getSolde() + montant);
	}
}
