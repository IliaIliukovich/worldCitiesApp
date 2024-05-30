package com.telran.worldcitiesapp.controller;

import com.telran.worldcitiesapp.model.City;
import com.telran.worldcitiesapp.model.CountryLanguage;
import com.telran.worldcitiesapp.service.CountryLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryLanguageController {

    @Autowired
    private CountryLanguageService countryLanguageService;

    @GetMapping("/allLanguageService")
    public List<CountryLanguage> getAll() {
        return countryLanguageService.getAllLanguages();
    }
}
