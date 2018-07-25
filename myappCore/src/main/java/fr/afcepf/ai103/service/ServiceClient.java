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

	}

	@Override
	public List<Client> rechercherListeClientsParNom(String nom) {

		return daoClient.rechercherClientsParNom(nom);
	}

	@Override
	public Client saveOrUpdateClient(Client cli) {

		if (cli.getNumClient() == null) {
			cli = daoClient.insererNouveauClient(cli); // entityManger.persist();;
		} else {
			daoClient.mettreAjourClient(cli); // entityManger.merge();
		}
		return cli;
	}

	// ....
}