package fr.afcepf.ai103.data;

import javax.persistence.Column;
/* javax.persistance = package de JPA */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Entité persistance prise en charge par JPA/hibernate
// @Table(name="Client")
public class Client {

	@Id // identifiant persistante prise en charge oar JPA/Hibernate
	// @Column(name="numClient")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY le mieux pour les BDD récentes
	private Long numClient;

	private String nom;
	private String prenom;
	private String email;
	private String adresse;

	@Column(length = 15) // varchar(15)
	private String telephone;

	private String password;

	// +get/set , +toString() , + default constructor

	@Override
	public String toString() {
		return "Client [numClient=" + numClient + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", adresse=" + adresse + ", telephone=" + telephone + ", password=" + password + "]";
	}

	public Client() {
		super();
	}

	public Long getNumClient() {
		return numClient;
	}

	public void setNumClient(Long numClient) {
		this.numClient = numClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}