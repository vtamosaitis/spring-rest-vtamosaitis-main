package com.vtamosaitis.springrest.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vtamosaitis.springrest.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query(value = "SELECT animal.name AS name, specie.specie_name AS specie_name, enclosure.enclosure_type AS enclosure_type "
            + "FROM animal LEFT JOIN specie ON animal.specie_id = specie.id \r\n"
            + "LEFT JOIN animal_enclosure ON animal.home_enclosure_id = animal_enclosure.id \r\n"
            + "LEFT JOIN enclosure ON animal_enclosure.enclosure_id = enclosure.id", nativeQuery = true)
    List<Map<String, String>> joinedFindAll();

}

