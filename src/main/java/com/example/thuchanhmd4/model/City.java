package com.example.thuchanhmd4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double area;
    private int population;
    private Double gdp;
    private String description;

    @ManyToOne
    Country country;
}
