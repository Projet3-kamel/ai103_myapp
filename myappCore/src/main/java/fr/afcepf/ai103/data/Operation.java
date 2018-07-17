package fr.afcepf.ai103.data;

import java.util.Date;


//@Entity
public class Operation {
	
	//@Id
	private Long numero;
	private Date date;
	private Double montant;
	private String label;

	public Operation() {
		super();
	}

	public Operation(Long numero, Date date, Double montant, String label) {
		super();
		this.numero = numero;
		this.date = date;
		this.montant = montant;
		this.label = label;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}