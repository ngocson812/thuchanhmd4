package com.example.thuchanhmd4.service;

import com.example.thuchanhmd4.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICityService {
    public Page<City> findAll(Pageable pageable);
    public void save(City city);
    public void delete(int id);
    public Optional<City> findById(int id);
    public Page<City> findByName(Pageable pageable, String name);
}
