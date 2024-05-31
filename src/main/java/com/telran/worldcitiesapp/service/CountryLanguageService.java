package com.telran.worldcitiesapp.service;

import com.telran.worldcitiesapp.model.CountryLanguage;
import com.telran.worldcitiesapp.repository.CountryLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryLanguageService {

    private CountryLanguageRepository repository;

    @Autowired
    public CountryLanguageService(CountryLanguageRepository repository) {
        this.repository = repository;
    }


    public List<CountryLanguage> getAllCountryLanguages() {
        return repository.findAll();
    }

    @Override
    public String toString() {
        return "CountryLanguageService{" +
                "repository=" + repository +
                '}';
    }
}
