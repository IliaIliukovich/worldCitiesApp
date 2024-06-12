package com.telran.worldcitiesapp.service;

import com.telran.worldcitiesapp.model.City;
import com.telran.worldcitiesapp.model.Country;
import com.telran.worldcitiesapp.repository.CityRepository;
import com.telran.worldcitiesapp.repository.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CityServiceTest {

    private CityRepository cityRepository;
    private CountryRepository countryRepository;
    private CityService cityService;

    @BeforeEach
    public void init() {
        cityRepository = Mockito.mock(CityRepository.class);
        countryRepository = Mockito.mock(CountryRepository.class);
        cityService = new CityService(cityRepository, countryRepository);
    }

    @Test
    public void testGetAllCities() {
        cityService.getAllCities();
        Mockito.verify(cityRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testGetAllCitiesByCountry() {
        String code = "321";
        cityService.getAllCitiesByCountry(code);
        Mockito.verify(cityRepository, Mockito.times(1)).findCitiesByCountryCode(code);
    }

    @Test
    public void testAddCity() {
        City city1 = new City();
        city1.setId(12356654L);
        city1.setName("Berlin");
        city1.setPopulation(40000);
        city1.setDistrict("BL");
        Country country = new Country();
        country.setName("Germany");
        country.setCode("324");

        Mockito.when(countryRepository.getReferenceById("324")).thenReturn(country);
        cityService.addCity(city1, "324");
        Mockito.verify(cityRepository, Mockito.times(1)).save(city1);
    }

    @Test
    public void testUpdateCityPopulation () {
        Long id = 12356654L;
        Integer population = 900000;
        Long wrongId = 354989973L;

        City city2 = new City();
        city2.setId(id);
        city2.setName("Los Angeles");
        city2.setDistrict("LA");
        city2.setPopulation(800000);
        Country country2 = new Country();
        country2.setName("USA");
        country2.setCode("321");

        Mockito.when(cityRepository.findById(id)).thenReturn(Optional.of(city2));
        assertEquals(city2.getPopulation(), 800000);
        Mockito.when(cityRepository.save(city2)).thenReturn(city2);
        City updated = cityService.updateCityPopulation(id, population);
        assertEquals(updated.getPopulation(), population);
        Mockito.verify(cityRepository, Mockito.times(1)).save(city2);

        Mockito.when(cityRepository.findById(wrongId)).thenReturn(Optional.empty());
        City city3 = cityService.updateCityPopulation(wrongId, population);
        assertNull(city3);
    }

    @Test
    public void testDeleteCity(){
        Long id = 13254654L;
        cityService.deleteCity(id);
        Mockito.verify(cityRepository, Mockito.times(1)).deleteById(id);
    }
}
