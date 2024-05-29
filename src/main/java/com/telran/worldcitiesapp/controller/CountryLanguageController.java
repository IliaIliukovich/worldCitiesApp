package com.telran.worldcitiesapp.controller;

import com.telran.worldcitiesapp.model.CountryLanguage;
import com.telran.worldcitiesapp.service.CountryLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CountryLanguageController {

    @Autowired
    private CountryLanguageService service;

    @GetMapping("/allCountryLanguages")
    public List<CountryLanguage> getAll() {
        return service.getAllCountryLanguages();
    }
}
