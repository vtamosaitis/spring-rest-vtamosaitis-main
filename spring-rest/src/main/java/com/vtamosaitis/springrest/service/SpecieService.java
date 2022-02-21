package com.vtamosaitis.springrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vtamosaitis.springrest.entity.Specie;
import com.vtamosaitis.springrest.repository.SpecieRepository;

@Service
public class SpecieService {
	
	private SpecieRepository specieRepository;

	public SpecieService(SpecieRepository specieRepository) {
		super();
		this.specieRepository = specieRepository;
	}
	
	public Specie saveSpecie(Specie specie) {
		return specieRepository.save(specie);
	}
	
	public List<Specie> all() {
		return specieRepository.findAll();
	}
	
	public Specie findById(Long id) {
		return specieRepository.findById(id).orElse(null);
	}
	
	public Specie updateSpecie(Specie specie, Long id) {
		Specie existingSpecie = findById(id);
		existingSpecie.setId(specie.getId());
		existingSpecie.setSpecieName(specie.getSpecieName());
		specieRepository.save(existingSpecie);
		
		return existingSpecie;
	}
}
