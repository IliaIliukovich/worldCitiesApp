package com.telran.worldcitiesapp.service;

import com.telran.worldcitiesapp.model.City;
import com.telran.worldcitiesapp.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public List<City> getAllCities() {
        return repository.findAll();
    }

}
