package com.vtamosaitis.springrest.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Enclosure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enclosureType;

    @OneToMany(targetEntity = AnimalEnclosure.class, fetch = FetchType.LAZY, mappedBy = "enclosure")
    private List<AnimalEnclosure> animalEnclosures;


    public Enclosure() {
    }

    public Enclosure(Long id, String enclosureType) {
        super();
        this.id = id;
        this.enclosureType = enclosureType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnclosureType() {
        return enclosureType;
    }

    public void setEnclosureType(String enclosureType) {
        this.enclosureType = enclosureType;
    }

}
