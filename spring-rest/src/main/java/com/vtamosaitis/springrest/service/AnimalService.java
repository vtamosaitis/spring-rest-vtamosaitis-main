package com.vtamosaitis.springrest.service;

import org.springframework.stereotype.Service;

import java.util.List;
import com.vtamosaitis.springrest.Payloads.AnimalData;
import com.vtamosaitis.springrest.entity.*;
import com.vtamosaitis.springrest.repository.*;

@Service
public class AnimalService {
	
	private AnimalRepository animalRepository;
	private SpecieRepository specieRepository;
	private AnimalEnclosureRepository animalEnclosureRepo;

	public AnimalService(AnimalRepository animalRepository, 
			SpecieRepository specieRepository, 
			AnimalEnclosureRepository animalEnclosureRepo) {
		super();
		this.animalRepository = animalRepository;
		this.specieRepository = specieRepository;
		this.animalEnclosureRepo = animalEnclosureRepo;
	}
	
	public Animal saveAnimal(Animal animal) {
		return animalRepository.save(animal);
	}
	
	public Animal saveAnimal(AnimalData animalData) {
		Animal animal = makeAnimal(animalData);
		return animalRepository.save(animal);
	}
	
	public List<Animal> all() {
		return animalRepository.findAll();
	}
	
	public List<Object> allJoined() {
		return animalRepository.joinedFindAll();
	}
	
	public Animal findById(Long id) {
		return animalRepository.findById(id).orElse(null);
	}
	
	public Animal updateAnimal(AnimalData animalData, Long id) {
		Animal existingAnimal = animalRepository.findById(id).orElse(null);
		Specie specie = specieRepository.findById(animalData.specie_id).orElse(null);
		AnimalEnclosure animalEnc = animalEnclosureRepo.findById(animalData.enc_id).orElse(null);
		existingAnimal.setName(animalData.name);
		existingAnimal.setSpecie(specie);
		existingAnimal.setHomeEnclosure(animalEnc);

		animalRepository.save(existingAnimal);
		
		return existingAnimal;
	}
	
	public Animal deleteAnimal(Long id) {
		Animal animal = animalRepository.findById(id).orElse(null);
		
		animalRepository.delete(animal);
		
		return animal;
	}

	public Animal makeAnimal(AnimalData animalData) {
		Specie specie = specieRepository.findById(animalData.specie_id).orElse(null);
		AnimalEnclosure animalEnclosure = animalEnclosureRepo.findById(animalData.enc_id).orElse(null);
		return new Animal(animalData.name, specie, animalEnclosure);
	}
}
