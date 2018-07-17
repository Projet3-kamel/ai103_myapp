package fr.afcepf.ai103.dao;

import java.util.List;

import fr.afcepf.ai103.data.Operation;

public interface IDaoOperation {

	public Operation insererNouveauOperation(Operation operation);

	public Operation rechercherOperationParNumero(Long num);

	public List<Operation> rechercherOperation();

	// autres recherches
	public void mettreAjourOperation(Operation operation);

	public void supprilmerOperation(Long numOperation);

}
