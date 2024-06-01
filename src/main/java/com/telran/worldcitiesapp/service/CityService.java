package com.telran.worldcitiesapp.service;

import com.telran.worldcitiesapp.model.City;
import com.telran.worldcitiesapp.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {


    private final CityRepository repository;

    @Autowired
    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public List<City> getAllCities() {
        return repository.findAll();
    }

    public List<City> getAllCitiesByCountry(String code) {
        return repository.findCitiesByCountryCode(code);
    }

    public void addCity(City city) {
        repository.save(city);
    }


    @Override
    public String toString() {
        return "CityService{" +
                "repository=" + repository +
                '}';
    }

}
