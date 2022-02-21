package com.vtamosaitis.springrest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtamosaitis.springrest.entity.AnimalEnclosure;
import com.vtamosaitis.springrest.service.AnimalEnclosureService;

@RestController
@RequestMapping("/api/animal-enclosure")
public class AnimalEnclosureController {

	private AnimalEnclosureService animalEnclosureService;
	
	public AnimalEnclosureController(AnimalEnclosureService animalEnclosureService) {
		super();
		this.animalEnclosureService = animalEnclosureService;
	}
	
	@PostMapping
	public ResponseEntity<AnimalEnclosure> saveAnimalEnclosure(@RequestBody AnimalEnclosure animalEnclosure) { 
		return new ResponseEntity<AnimalEnclosure>(animalEnclosureService.saveAnimalEnclosure(animalEnclosure), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<AnimalEnclosure> all() {
		return animalEnclosureService.all();
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<AnimalEnclosure> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<AnimalEnclosure>(animalEnclosureService.findById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<AnimalEnclosure> updateAnimal(@RequestBody AnimalEnclosure animalEnclosure, @PathVariable("id") Long id) {
		return new ResponseEntity<AnimalEnclosure>(animalEnclosureService.updateAnimalEnclosure(animalEnclosure, id), HttpStatus.OK);
	}
}
