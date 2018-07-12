package fr.afcepf.ai103.data;

import java.util.Date;

public class Operation {

	private Long numero;
	private Date date;
	private Double montan;
	private String label;

	public Operation() {
		super();
	}

	
	public Operation(Long numero, Date date, Double montan, String label) {
		super();
		this.numero = numero;
		this.date = date;
		this.montan = montan;
		this.label = label;
	}



	@Override
	public String toString() {
		return "Operation [numero=" + numero + ", date=" + date + ", montan=" + montan + ", label=" + label + "]";
	}

}
