package com.telran.worldcitiesapp.service;

import com.telran.worldcitiesapp.model.City;
import com.telran.worldcitiesapp.repository.CityRepository;
import com.telran.worldcitiesapp.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {


    private CityRepository repository;

    @Autowired
    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public List<City> getAllCities() {
        return repository.findAll();
    }

    @Override
    public String toString() {
        return "CityService{" +
                "repository=" + repository +
                '}';
    }

}
