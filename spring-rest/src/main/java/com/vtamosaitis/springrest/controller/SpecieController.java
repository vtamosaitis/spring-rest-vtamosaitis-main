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

import com.vtamosaitis.springrest.entity.Specie;
import com.vtamosaitis.springrest.service.SpecieService;

@RestController
@RequestMapping("/api/specie")
public class SpecieController {

    private final SpecieService specieService;

    public SpecieController(SpecieService specieService) {
        super();
        this.specieService = specieService;
    }

    //TODO fix post and put mapping: both enter null values for foreign keys
    @PostMapping
    public ResponseEntity<Specie> saveSpecie(@RequestBody Specie specie) {
        System.out.println(specie);
        return new ResponseEntity<Specie>(specieService.saveSpecie(specie), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Specie> all() {
        return specieService.all();
    }


    @GetMapping("{id}")
    public ResponseEntity<Specie> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Specie>(specieService.findById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Specie> updateSpecie(@RequestBody Specie specie, @PathVariable("id") Long id) {
        return new ResponseEntity<Specie>(specieService.updateSpecie(specie, id), HttpStatus.OK);
    }
}
