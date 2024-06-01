package com.telran.worldcitiesapp.controller;

import com.telran.worldcitiesapp.model.City;
import com.telran.worldcitiesapp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CityController {

    private final CityService service;

    @Autowired
    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping("/allCities")
    public List<City> getAll() {
        return service.getAllCities();
    }

    @GetMapping("/allCitiesByCountry")
    public List<City> getAllByCountry(@RequestParam(name = "code") String code) {
        return service.getAllCitiesByCountry(code);
    }

}
