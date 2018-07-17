package fr.afcepf.ai103.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Compte {

	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", label=" + label + ", solde=" + solde + ", dernieresOperations="
				+ dernieresOperations + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numCompte")
	private Long numero;
	private String label;
	private Double solde;

	@OneToMany(mappedBy = "compte") // mappedBy = "nomJava_RelatioInverse_Many"
	private List<Operation> dernieresOperations; //

	public Compte() {
		super();
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public List<Operation> getDernieresOperations() {
		return dernieresOperations;
	}

	public void setDernieresOperations(List<Operation> dernieresOperations) {
		this.dernieresOperations = dernieresOperations;
	}
}