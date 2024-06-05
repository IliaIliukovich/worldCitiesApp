package com.telran.worldcitiesapp.service;

import com.telran.worldcitiesapp.model.City;
import com.telran.worldcitiesapp.model.Country;
import com.telran.worldcitiesapp.repository.CityRepository;
import com.telran.worldcitiesapp.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {



    private final CityRepository repository;
    private final CountryRepository countryRepository;

    @Autowired
    public CityService(CityRepository repository, CountryRepository countryRepository) {
        this.repository = repository;
        this.countryRepository = countryRepository;
    }

    public List<City> getAllCities() {
        return repository.findAll();
    }

    public List<City> getAllCitiesByCountry(String code) {
        return repository.findCitiesByCountryCode(code);
    }

    public void addCity(City city, String countryCode) {
        Country country = countryRepository.getReferenceById(countryCode);
        city.setCountry(country);
        repository.save(city);
    }

    public City updateCityPopulation(Long id, Integer population) {
        Optional<City> cityOptional = repository.findById(id);
        if (cityOptional.isPresent()) {
            City city = cityOptional.get();
            city.setPopulation(population);
            return repository.save(city);
        }
        return null;
    }

    public void deleteCity(Long id) {
        repository.deleteById(id);
    }


    @Override
    public String toString() {
        return "CityService{" +
                "repository=" + repository +
                '}';
    }

}
