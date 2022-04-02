package com.vtamosaitis.springrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vtamosaitis.springrest.entity.AnimalEnclosure;
import com.vtamosaitis.springrest.repository.AnimalEnclosureRepository;

@Service
public class AnimalEnclosureService {
	
	private final AnimalEnclosureRepository animalEnclosureRepo;

	public AnimalEnclosureService(AnimalEnclosureRepository animalEnclosureRepo) {
		super();
		this.animalEnclosureRepo = animalEnclosureRepo;
	}
	
	public AnimalEnclosure saveAnimalEnclosure(AnimalEnclosure animalEnclosure) {
		return animalEnclosureRepo.save(animalEnclosure);
	}
	
	public List<AnimalEnclosure> all() {
		return animalEnclosureRepo.findAll();
	}
	
	public AnimalEnclosure findById(Long id) {
		return animalEnclosureRepo.findById(id).orElse(null);
	}
	
	public AnimalEnclosure updateAnimalEnclosure(AnimalEnclosure animalEnclosure, Long id) {
		AnimalEnclosure existingAnimalEnc = findById(id);
		existingAnimalEnc.setId(animalEnclosure.getId());
		existingAnimalEnc.setEnclosure(animalEnclosure.getEnclosure());
		animalEnclosureRepo.save(existingAnimalEnc);
		
		return existingAnimalEnc;
	}
}
