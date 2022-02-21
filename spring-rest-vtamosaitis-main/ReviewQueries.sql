SELECT * FROM animal;
SELECT * FROM animal_enclosure;
SELECT * FROM enclosure;
SELECT * FROM specie;
SELECT * FROM specie_enclosure;

SELECT * FROM animal NATURAL JOIN specie JOIN animal_enclosure ON animal.home_id = animal_enclosure.id JOIN enclosure ON animal_enclosure.enclosure_id = enclosure.id;