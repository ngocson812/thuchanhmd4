package com.example.thuchanhmd4.service;

import com.example.thuchanhmd4.model.City;
import com.example.thuchanhmd4.repository.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements ICityService{

    @Autowired
    CityRepo cityRepo;

    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepo.findAll(pageable);
    }

    @Override
    public void save(City city) {
        cityRepo.save(city);
    }

    @Override
    public void delete(int id) {
        cityRepo.deleteById(id);
    }

    @Override
    public Optional<City> findById(int id) {
        return cityRepo.findById(id);
    }

    @Override
    public Page<City> findByName(Pageable pageable, String name) {
        return (Page<City>) cityRepo.findAllByNameContaining(pageable, name);
    }
}
