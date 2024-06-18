DELETE FROM topics;
DELETE FROM guides;
DELETE FROM provide;
DELETE FROM available_answers;
DELETE FROM questions;
DELETE FROM quizzes;
DELETE FROM users;

INSERT INTO users (email, name, password) VALUES
	('administrateur@mqb.com', 'admin', '$2a$12$YFtTh0SduMN.AL1NeFo7feRyPqMGrlvrwiJWixo0tfKbdB46jchzG'),
	('coucou@mqb.com', 'coucou', '$2a$12$YFtTh0SduMN.AL1NeFo7feRyPqMGrlvrwiJWixo0tfKbdB46jchzG');

INSERT INTO guides
	(name, url, image) VALUES
	('La definition du poste', 'https://majrh.fr/topics/definition-du-poste/', 'Some image'),
	('La redaction de l''offre d''emploi', 'https://majrh.fr/topics/la-redaction-de-loffre-demploi/', 'Some image'), 
	('Modele d''offre d''emploi inclusive', 'https://majrh.fr/topics/modele-doffre-demploi-inclusive/', 'Some image'),
	('La diffusion de l''offre d''emploi', 'https://majrh.fr/topics/la-diffusion-de-loffre-demploi/', 'Some image'),
	('Selection des candidatures', 'https://majrh.fr/topics/selection-des-candidatures/', 'Some image'),
	('Preparation de la rencontre', 'https://majrh.fr/topics/preparation-de-la-rencontre/', 'Some image'),
	('Reponse aux candidats', 'https://majrh.fr/topics/reponse-aux-candidats-es/', 'Some image'),
	('Preparation aux entretiens techniques', 'https://majrh.fr/topics/preparation-entretiens-techniques/', 'Some image'),
	('Preparation a l''arrivee en entreprise', 'https://majrh.fr/topics/preparation-arrivee-entreprise/', 'Some image'),
	('Presenter le poste de travail', 'https://majrh.fr/topics/preparer-poste-de-travail/', 'Some image'),
	('Former a la culture d''entreprise', 'https://majrh.fr/topics/former-culture-entreprise/', 'Some image'),
	('Integrer a l''equipe', 'https://majrh.fr/topics/integrer-equipe/', 'Some image'),
	('Former ses managers', 'https://majrh.fr/topics/former-manager/', 'Some image');
