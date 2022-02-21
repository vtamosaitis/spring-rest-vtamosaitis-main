package com.vtamosaitis.springrest;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vtamosaitis.springrest.entity.*;
import com.vtamosaitis.springrest.repository.*;

@Configuration
public class LoadDatabase {
	
	@Bean
	CommandLineRunner loadDB(AnimalRepository animalRepository,
			AnimalEnclosureRepository animalEnclosureRepository,
			EnclosureRepository enclosureRepository,
			SpecieRepository specieRepository) {
		return args -> {
			// Specie entries
			Specie giraffe = new Specie();
			giraffe.setSpecieName("Cervus camelopardalis");
			
			Specie elephant = new Specie();
			elephant.setSpecieName("Loxodonta africana");
			
			Specie lion = new Specie();
			lion.setSpecieName("Panthera leo");
			
			Specie alligator = new Specie();
			alligator.setSpecieName("Alligator mississippiensis");
			
			Specie test = new Specie();
			test.setSpecieName("test");
			
			// Enclosure entries
			Enclosure waterland = new Enclosure();
			waterland.setEnclosureType("Waterland");
			
			Enclosure aquatic = new Enclosure();
			aquatic.setEnclosureType("Aquatic");
			
			Enclosure aviary = new Enclosure();
			aviary.setEnclosureType("Aviary");
			
			Enclosure savannah = new Enclosure();
			savannah.setEnclosureType("Savannah");
			
			// AnimalEnclosure entries
			AnimalEnclosure waterlandEnclosureOne = new AnimalEnclosure();
			waterlandEnclosureOne.setEnclosure(waterland);
			
			AnimalEnclosure savannahEnclosureOne = new AnimalEnclosure();
			savannahEnclosureOne.setEnclosure(savannah);

			AnimalEnclosure savannahEnclosureTwo = new AnimalEnclosure();
			savannahEnclosureTwo.setEnclosure(savannah);

			AnimalEnclosure savannahEnclosureThree = new AnimalEnclosure();
			savannahEnclosureThree.setEnclosure(savannah);
			
			AnimalEnclosure aquaticEnclosureOne = new AnimalEnclosure();
			aquaticEnclosureOne.setEnclosure(aquatic);
			
			// Animal Entries ("Leo", 3, 2), ("Dumbo", 2, 4), ("Graf", 1, 3), ("Sif", 4, 1), ("Pen", 5, NULL)
			Animal leo = new Animal();
			leo.setName("Leo");
			leo.setSpecie(lion);
			leo.setHomeEnclosure(savannahEnclosureOne);
			
			Animal dumbo = new Animal();
			dumbo.setName("Dumbo");
			dumbo.setSpecie(elephant);
			dumbo.setHomeEnclosure(savannahEnclosureTwo);
			
			Animal graf = new Animal();
			graf.setName("Graf");
			graf.setSpecie(giraffe);
			graf.setHomeEnclosure(savannahEnclosureThree);
			
			Animal sif = new Animal();
			sif.setName("Sif");
			sif.setSpecie(alligator);
			sif.setHomeEnclosure(waterlandEnclosureOne);
			
			Animal pen = new Animal();
			pen.setName("Pen");
			pen.setSpecie(test);
			
			
			specieRepository.saveAll(Arrays.asList(giraffe, elephant, lion, elephant, alligator, test));
			enclosureRepository.saveAll(Arrays.asList(waterland, aquatic, aviary, savannah));
			animalEnclosureRepository.saveAll(Arrays.asList(
					waterlandEnclosureOne, savannahEnclosureOne, savannahEnclosureTwo,
					savannahEnclosureThree, aquaticEnclosureOne
				));
			animalRepository.saveAll(Arrays.asList(leo, dumbo, graf, sif, pen));
			
		};
	}
}
