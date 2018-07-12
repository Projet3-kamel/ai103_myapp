package fr.afcepf.ai103.service;

import fr.afcepf.ai103.data.Client;

public class ServiceClient {
	public Client recherherInfosClient(Long numClient) {
		Client cli = new Client();
		cli.setNumClient(numClient);
		cli.setPrenom("jean");
		cli.setNom("Bon");
		cli.setAdresse("12 rue elle 75000 Par ici");
		cli.setEmail("jeanbon@ici-ou-la.fr");
		cli.setTelephone("0102030405");
		return cli;
	}

}
