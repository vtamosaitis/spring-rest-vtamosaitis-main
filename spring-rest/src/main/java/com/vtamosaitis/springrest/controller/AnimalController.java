package com.vtamosaitis.springrest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtamosaitis.springrest.Payloads.AnimalData;
import com.vtamosaitis.springrest.entity.*;
import com.vtamosaitis.springrest.service.AnimalService;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {

	private AnimalService animalService;
	
	public AnimalController(AnimalService animalService) {
		super();
		this.animalService = animalService;
	}
	
	@PostMapping
	public ResponseEntity<Animal> saveAnimal(@RequestBody AnimalData animalData) { 
		return new ResponseEntity<Animal>(animalService.saveAnimal(animalData), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Animal> all() {
		return animalService.all();
	}
	
	@GetMapping("joined")
	public List<Object> allJoined() {
		return animalService.allJoined();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Animal> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<Animal>(animalService.findById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Animal> updateAnimal(@RequestBody AnimalData animalData, @PathVariable("id") Long id) {
		return new ResponseEntity<Animal>(animalService.updateAnimal(animalData, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Animal> deleteAnimal(@PathVariable("id") Long id) {
		return new ResponseEntity<Animal>(animalService.deleteAnimal(id), HttpStatus.OK);
	}

}
