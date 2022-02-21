package com.vtamosaitis.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtamosaitis.springrest.entity.AnimalEnclosure;

public interface AnimalEnclosureRepository extends JpaRepository<AnimalEnclosure, Long> {

}
