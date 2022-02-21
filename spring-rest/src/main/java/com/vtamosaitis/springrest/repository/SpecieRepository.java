package com.vtamosaitis.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtamosaitis.springrest.entity.Specie;

public interface SpecieRepository extends JpaRepository<Specie, Long> {

}
