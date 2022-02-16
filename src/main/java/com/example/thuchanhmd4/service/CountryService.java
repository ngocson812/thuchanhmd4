package com.example.thuchanhmd4.service;

import com.example.thuchanhmd4.model.Country;
import com.example.thuchanhmd4.repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService{

    @Autowired
    CountryRepo countryRepo;

    @Override
    public List<Country> findAll() {
        return (List<Country>) countryRepo.findAll();
    }
}
