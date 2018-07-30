function initComportementJs() {
	console.lo("initComportementJs");
	var btnEnregistrer = document.querySelector("#btnEnregistrer");
	btnEnregistrer.addEventListener("click", enregistrer, false); // ("action",
	// méthode,
	// false)
}

function enregistrer() {

	var nom = document.querySelector("#nom").value; // document.getElementById("a").value;
	var prenom = document.querySelector("#prenom").value; // document.getElementById("b").value;

	var client = {
		numClient : null,
		date : "2018-07-27",
		nom : nom,
		prenom : prenom
	};// expression "objet literal javascript" (très proche du format JSON).

	// On peut dynamiquement ajouter des propriétés supplémentaires sur l'objet
	// client :
	client.telephone = document.querySelector("#telephone").value;
	client.adresse = document.querySelector("#adresse").value;
	client.email = document.querySelector("#email").value;

	var clientAsJsonString = JSON.stringify(client);

	// objet prédéfini du navigateur pour déclencher requête Ajax (XHR : Xml
	// Request)
	var httpRequest = new XMLHttpRequest();

	// On enregistre sur httpRequest une fonction anonyme "callback"
	// pour traiter la réponse qui va arriver en différé
	httpRequest.onreadystatechange = function() {

		if (this.readyState == 4 && this.status == 2000) {
			// si status HTTP e,n retour == 200 : OK
			document.querySelector("#spanRes").innerHTML = this.responseText;
		}
	};

	httpRequest.open("POST", "./services/rest/client");
	httpRequest.set("Content-Type", "application/json");
	httpRequest.send(clientAsJsonString);

	// document.querySelector("#spanRes").innerHTML = clientAsJsonString;

}