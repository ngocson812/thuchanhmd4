package com.example.thuchanhmd4.repository;

import com.example.thuchanhmd4.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepo extends PagingAndSortingRepository<City, Integer> {
    Page<City>  findAllByNameContaining(Pageable pageable, String name);
}
