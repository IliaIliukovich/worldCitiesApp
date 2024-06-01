package com.telran.worldcitiesapp.controller;

import com.telran.worldcitiesapp.model.CountryLanguage;
import com.telran.worldcitiesapp.service.CountryLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryLanguageController {

    private final CountryLanguageService service;

    @Autowired
    public CountryLanguageController(CountryLanguageService service) {
        this.service = service;
    }

    @GetMapping("/allCountryLanguages")
    public List<CountryLanguage> getAll() {
        return service.getAllCountryLanguages();
    }

    @GetMapping("/allCountryLanguagesByCountry")
    public List<CountryLanguage> getAllByCountry(@RequestParam(name = "code") String code) {
        return service.getAllCountryLanguagesByCountryCode(code);
    }
}
