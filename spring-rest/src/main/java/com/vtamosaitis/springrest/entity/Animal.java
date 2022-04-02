package com.vtamosaitis.springrest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToOne
    @JoinColumn(name = "specie_id")
    private Specie specie;

    @ManyToOne
    @JoinColumn(name = "home_enclosure_id")
    private AnimalEnclosure homeEnclosure;

    public Animal() {
    }

    public Animal(String name, Specie specie, AnimalEnclosure homeEnclosure) {
        super();
        this.name = name;
        this.specie = specie;
        this.homeEnclosure = homeEnclosure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }

    public AnimalEnclosure getHomeEnclosure() {
        return homeEnclosure;
    }

    public void setHomeEnclosure(AnimalEnclosure homeEnclosure) {
        this.homeEnclosure = homeEnclosure;
    }

    @Override
    public String toString() {
        return "Animal [id=" + id + ", name=" + name + ", specie=" + specie + ", homeEnclosure=" + homeEnclosure + "]";
    }


}
