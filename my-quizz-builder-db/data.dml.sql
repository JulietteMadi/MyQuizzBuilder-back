DELETE FROM topics;
DELETE FROM guides;
DELETE FROM users;

INSERT INTO guides
	(name, url, image) VALUES
	('Inclusion pour tous les travailleurs', 'https://majrh.fr/', 'Some image'), ('Dispositifs RH', 'https://lienrh.fr/', 'Some image'), ('Onboarding facile', 'https://noticerh.fr/', 'Some image');


INSERT INTO users (email, name, password) VALUES
	('juliette.madinier@gmail.com', 'coucou', '$2a$12$YFtTh0SduMN.AL1NeFo7feRyPqMGrlvrwiJWixo0tfKbdB46jchzG');