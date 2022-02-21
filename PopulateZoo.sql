USE zoo;

INSERT INTO specie (specie_name) VALUES 
	("Cervus camelopardalis"), ("Loxodonta africana"), ("Panthera leo"), ("Alligator mississippiensis"), ("Penguin");
INSERT INTO enclosure (type) VALUES ("Waterland"), ("Aquatic"), ("Aviary"), ("Savannah");
INSERT INTO animal_enclosure (enclosure_id) VALUES (1), (4), (4), (4), (2);
INSERT INTO animal (animal_name, specie_id, home_id) VALUES ("Leo", 3, 2), ("Dumbo", 2, 4), ("Graf", 1, 3), ("Sif", 4, 1), ("Pen", 5, NULL);
INSERT INTO specie_enclosure (specie_id, enclosure_id) VALUES (1, 4), (2, 4), (3, 4), (4, 1);