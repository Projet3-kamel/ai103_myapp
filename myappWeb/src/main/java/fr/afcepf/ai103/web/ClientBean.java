package fr.afcepf.ai103.web;

import javax.faces.bean.ManagedBean ; 
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai103.data.Client;
import fr.afcepf.ai103.service.ServiceClient; 
@ManagedBean    
@SessionScoped

public class ClientBean {
	private Long numClient;
	private String password;
	private Client client;
	private String message;
	private ServiceClient servClient = new ServiceClient();
	
	public String verifLogin() {
		String suite=null;
		if(password!=null && password.equals("pwd" + numClient)) {
			suite="client";
			this.client = servClient.recherherInfosClient(numClient);
		}
		else {
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ServiceClient getServClient() {
		return servClient;
	}

	public void setServClient(ServiceClient servClient) {
		this.servClient = servClient;
	}
	
	
}
