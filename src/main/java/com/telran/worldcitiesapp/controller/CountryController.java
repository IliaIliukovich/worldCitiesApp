package com.telran.worldcitiesapp.controller;

import com.telran.worldcitiesapp.model.Country;
import com.telran.worldcitiesapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping("/allCountries")
    public List<Country> getAll() {
        return service.getAllCountries();
    }



}
