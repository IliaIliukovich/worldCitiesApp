package com.telran.worldcitiesapp.service;

import com.telran.worldcitiesapp.model.Country;
import com.telran.worldcitiesapp.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository repository;

    @Autowired
    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public List<Country> getAllCountries() {
        return repository.findAll();
    }

    public void addCountry(Country country) {
        repository.save(country);
    }

}
