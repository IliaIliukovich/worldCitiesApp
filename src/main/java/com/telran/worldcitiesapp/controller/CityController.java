package com.telran.worldcitiesapp.controller;

import com.telran.worldcitiesapp.model.City;
import com.telran.worldcitiesapp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping("/allCities")
    public List<City> getAll() {
        return service.getAllCities();
    }


}
