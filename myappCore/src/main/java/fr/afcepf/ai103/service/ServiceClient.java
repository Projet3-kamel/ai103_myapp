package fr.afcepf.ai103.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import fr.afcepf.ai103.dao.IDaoClient;
import fr.afcepf.ai103.data.Client;

@Stateless // EJB session sans état (98% des EJBs de traitement
@Local // ou @Remote
public class ServiceClient implements IServiceClient {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.afcepf.ai103.service.IServiceClient#rechercherInfosClient(java.lang.Long)
	 */
	@EJB
	private IDaoClient daoClient;

	@Override
	public Client rechercherInfosClient(Long numClient) {

		return daoClient.rechercherClientParNumero(numClient);
		/*
		 * Client cli = new Client();
		 * // simulation de valeurs récupérées en base: cli.setNumClient(numClient);
		 * cli.setPrenom("jean"); cli.setNom("Bon");
		 * cli.setAdresse("12 rue elle 75000 Par ici");
		 * cli.setEmail("jean.bon@ici_ou_la.fr"); cli.setTelephone("0102030405"); return
		 * cli;
		 */
	}

	@Override
	public List<Client> rechercherListeClientsParNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	// ....
}