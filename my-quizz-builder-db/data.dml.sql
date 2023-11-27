DELETE FROM topics;
DELETE FROM guides;
DELETE FROM users;

INSERT INTO guides
	(name, url, image) VALUES
	('La définition du poste', 'https://majrh.fr/topics/definition-du-poste/', 'Some image'), 
	('La rédaction de l''offre d''emploi', 'https://majrh.fr/topics/la-redaction-de-loffre-demploi/', 'Some image'), 
	('Modèle d''offre d''emploi inclusive', 'https://majrh.fr/topics/modele-doffre-demploi-inclusive/', 'Some image'),
	('La diffusion de l''offre d''emploi', 'https://majrh.fr/topics/la-diffusion-de-loffre-demploi/', 'Some image'),
	('Selection des candidatures', 'https://majrh.fr/topics/selection-des-candidatures/', 'Some image'),
	('Preparation de la rencontre', 'https://majrh.fr/topics/preparation-de-la-rencontre/', 'Some image'),
	('Réponse aux candidats', 'https://majrh.fr/topics/reponse-aux-candidats-es/', 'Some image');


INSERT INTO users (email, name, password) VALUES
	('administrateur@mqb.com', 'admin', '$2a$12$YFtTh0SduMN.AL1NeFo7feRyPqMGrlvrwiJWixo0tfKbdB46jchzG');
	
	
	