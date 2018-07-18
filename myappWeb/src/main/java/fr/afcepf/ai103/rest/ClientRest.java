package fr.afcepf.ai103.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import fr.afcepf.ai103.data.Client;
import fr.afcepf.ai103.service.IServiceClient;

/*
 * classe java du WS REST lié au client
 */

@Path("client") // Avant dernière partie de l'URL
@Produces("application/json") // Pour convertir automatiquement réponse java en réponse JSON
public class ClientRest {

	@EJB
	private IServiceClient serviceClient;

	@Path("/{idClient}")
	@GET // GET pour lecture, recherche unique par id/clef primaire
	// URL = http://localhost:8080/myappWeb/services/rest/client/1 ===> 1
	public Client rechercherClientQuiVaBien(@PathParam("idClient") Long numClient) {

		return serviceClient.rechercherInfosClient(numClient);
	}

	@Path("")
	@GET // GET pour lecture, recherche multtiple via critère
	// URL =
	// http://localhost:8080/myappWeb/services/rest/client/client?nom=Therieur
	public List<Client> rechercherClients(@QueryParam("nom") String nom) {

		return serviceClient.rechercherListeClientsParNom(nom);
	}

}
