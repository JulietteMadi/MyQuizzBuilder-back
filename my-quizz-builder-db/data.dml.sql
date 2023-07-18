DELETE FROM topics;
DELETE FROM guides;

INSERT INTO guides
	(name, url, image)VALUES
	('Travailleurs étrangers', 'https://majrh.fr/', 'Some image'), ('Dispositifs RH', 'https://lienrh.fr/', 'Some image'), ('Onboarding facile', 'https://noticerh.fr/', 'Some image');

INSERT INTO topics 
	(name)
	VALUES 
	('Réussir à être inclusif')