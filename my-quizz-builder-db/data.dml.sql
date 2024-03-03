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
	('Reponse aux candidats', 'https://majrh.fr/topics/reponse-aux-candidats-es/', 'Some image');

INSERT INTO topics (name) VALUES
	('Onboarding'),
	('Recrutement'),
	('Dispositifs d''inclusion'),
	('Formation interne');

INSERT INTO provide(topic_id, guide_id) VALUES
	(1,1),(1,5),(1,4),(1,3),(1,2),
	(2,1),(2,7),(2,2),(2,3),(2,6),
	(3,2),(3,4),(3,5),(3,7),(3,1),
	(4,6),(4,2),(4,5),(4,4),(4,1);

/* INSERT INTO quizzes (name, image, user_id) VALUES
	('Quiz pour les manager RSE en grand groupe', 'some image', 2);
	
INSERT INTO questions (name, answer_description, topic_id, quiz_id) VALUES
	('Lesquels sont des biais cognitif parmi la liste ci-dessous ?', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit', 2, 1),
	('Tout le monde a des biais cognitif', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit', 1, 1),
	('A poste et temps de travail équivalent, les hommes et le femmes gagnent autant', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit', 2, 1),
	('Pourquoi faut-il se former à l''inclusivité', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit', 4, 1),
	('Que veut dire l''accronyme RSE ?', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit', 4, 1);

INSERT INTO available_answers (name, valid, question_id) VALUES
	('Biais du coup irrécupérable', true, 1),
	('Biais de confirmation', true, 1),
	('Biais de complémentarité réciproque', false, 1),
	('Biais retrospectif', true, 1),
	('Vrai', true, 2),
	('Faux', false, 2),
	('Vrai', false, 3),
	('Faux', true, 3);*/