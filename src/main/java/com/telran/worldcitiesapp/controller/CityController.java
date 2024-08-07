package com.telran.worldcitiesapp.controller;

import com.telran.worldcitiesapp.model.City;
import com.telran.worldcitiesapp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping("/allCities")
    public List<City> getAll() {
        return service.getAllCities();
    }

    @GetMapping("/allCitiesByCountry")
    public List<City> getAllByCountry(@RequestParam(name = "code") String code) {
        return service.getAllCitiesByCountry(code);
    }
    @PostMapping("/insertCity")
    public ResponseEntity<?> addCity(@RequestBody City city, @RequestParam String countryCode) {
        service.addCity(city, countryCode);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PatchMapping("/updateCity")
    public ResponseEntity<City> updateCity(@RequestParam long id, @RequestParam int population){
        City city = service.updateCityPopulation(id, population);
        return new ResponseEntity<>(city, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/deleteCity")
    public void deleteCity(@RequestParam long id){
        service.deleteCity(id);
    }
}
