package fr.afcepf.ai103.web;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai103.data.Client;
import fr.afcepf.ai103.service.IServiceClient;

@ManagedBean /*
				 * pour que cette classe java soit prise en charge par le framework JSF2 et pour
				 * qu'on puisse accéder à une instance depuis une page .xhtml via la syntaxe
				 * #{clientBean...}
				 */
@SessionScoped /* pour que ce soit socker en Session Http , dure longtemps en mémoire */
public class ClientBean {
	private Long numClient; // à saisir
	private String password; // à saisir

	private String message; // à afficher

	private Client client; // infos "client" à récupérer

	// private ServiceClient serviceClient = new ServiceClient();

	@EJB // pour demander au serveur JEE de mettre à jour automatiquement
	// la référence serviceClient en pointant vers un EJB existant de l'application
	// qui implémente l'interface précisée (Pattern "injection de dépendance")
	// @Inject peut par fois être utilisé à la place de @EJB
	private IServiceClient serviceClient;

	public ClientBean() {

		System.out.println("Dans le constructeur par défaut, serviceClient = " + serviceClient);
		// serviceClient.appelMethodeDesDebut() ==> NullPointerException
	}

	@PostConstruct
	public void initialisationApresInjectionDeDependance() {

		System.out.println("Dans méthode préfixe par @PostContruct, serciveClient = " + serviceClient);
		// serviceClient.appelMethodeDesDebut() ==> ok !!!
	}

	public String verifLogin() {
		String suite = null; /* si suite reste à null on reste sur même page */
		// simuler verification du mot de passe:
		if (password != null && password.equals("pwd" + numClient)) {
			// mot de passe considéré comme ok si "pwd" + numClient (ex: "pwd1" )
			this.client = serviceClient.rechercherInfosClient(numClient);
			message = "";
			// on demande à naviguer vers la page client
			suite = "client"; // .jsf (.jsp ou .xhtml)
		} else {
			message = "invalid password";
		}
		return suite;
	}

	public Long getNumClient() {
		return numClient;
	}

	public void setNumClient(Long numClient) {
		this.numClient = numClient;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}