INSERT INTO Client(numClient, prenom, nom, email, adresse, telephone, password) VALUES (1, 'Jean', 'DU JARDIN', 'jean.dujardin@gmail.com', '1 rue Thénard 75005 Paris', '06552233', 'pwd1')
INSERT INTO Client(numClient, prenom, nom, email, adresse, telephone, password) VALUES (2, 'axelle', 'Aire', 'axelle.aire@gmail.com', '1 rue elle 69005 Lyon', '06552233', 'pwd2')
INSERT INTO Client(numClient, prenom, nom, email, adresse, telephone, password) VALUES (3, 'amar', 'DEKABYLIE', 'amardekabylie@gmail.com', '1 rue Thénard 94120 Créteil', '06552233', 'pwd3')
INSERT INTO Client(numClient, prenom, nom, email, adresse, telephone, password) VALUES (4, 'air', 'Nike', 'air.nike@gmail.com', '23 rue de Londre 75009 PAris', '06552233', 'pwd4')

INSERT INTO Compte(numCompte, label, solde) VALUES (1, 'compte courant 1', 500.0)
INSERT INTO Compte(numCompte, label, solde) VALUES (2, 'compte courant 2', 10000.0)
INSERT INTO Compte(numCompte, label, solde) VALUES (3, 'compte courant 3', 2390.0)
INSERT INTO Compte(numCompte, label, solde) VALUES (4, 'compte courant 4', 1256.70)

INSERT INTO Operation(numOperation, dateOp, montant, label, numCpt) VALUES (1, '2018-07-17',  -15.50, 'Achat 1', 1)
INSERT INTO Operation(numOperation, dateOp, montant, label, numCpt) VALUES (2, '2018-07-07', -15.85, 'Achat 2', 2)


