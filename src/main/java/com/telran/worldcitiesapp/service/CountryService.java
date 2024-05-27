package com.telran.worldcitiesapp.service;

import com.telran.worldcitiesapp.model.Country;
import com.telran.worldcitiesapp.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@AllArgsConstructor
public class CountryService {

    private CountryRepository repository;

//    public void setRepository(CountryRepository repository) {
//        this.repository = repository;
//    }

    @Autowired
    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public List<Country> getAll() {
        return repository.findAll();
    }

    @Override
    public String toString() {
        return "CountryService{" +
                "repository=" + repository +
                '}';
    }
}
