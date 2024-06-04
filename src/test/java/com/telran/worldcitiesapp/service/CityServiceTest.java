package com.telran.worldcitiesapp.service;

import com.telran.worldcitiesapp.model.City;
import com.telran.worldcitiesapp.model.Country;
import com.telran.worldcitiesapp.repository.CityRepository;
import com.telran.worldcitiesapp.repository.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        List<City> list = new ArrayList<>();

        City city1 = new City();
        city1.setId(654313464L);
        city1.setName("Paris");
        city1.setDistrict("PR");
        city1.setPopulation(300000);
        city1.setCountry(new Country());

        City city2 = new City();
        city2.setId(65465464L);
        city2.setName("London");
        city2.setDistrict("LO");
        city2.setPopulation(5000000);
        city2.setCountry(new Country());

        list.add(city1);
        list.add(city2);

        Mockito.when(cityRepository.findAll()).thenReturn(list);
        List<City> cities = cityService.getAllCities();
        assertEquals(list.get(0).getName(), cities.get(0).getName());
        assertEquals(list.get(1).getName(), cities.get(1).getName());
        assertEquals(list.size(), cities.size());
    }

    @Test
    public void TestGetAllCitiesByCountry() {

        List<City> list = new ArrayList<>();

        City city1 = new City();
        city1.setId(65465464L);
        city1.setName("New-York");
        city1.setDistrict("NY");
        city1.setPopulation(100000);
        Country country1 = new Country();
        country1.setName("USA");
        country1.setCode("321");
        city1.setCountry(country1);

        City city2 = new City();
        city2.setId(65465464L);
        city2.setName("Los Angeles");
        city2.setDistrict("LA");
        city2.setPopulation(200000);
        Country country2 = new Country();
        country2.setName("USA");
        country2.setCode("321");
        city2.setCountry(country2);

        list.add(city1);
        list.add(city2);

        Mockito.when(cityRepository.findCitiesByCountryCode("321")).thenReturn(list);
        List<City> cities = cityService.getAllCitiesByCountry("321");
        assertEquals(list.get(0).getName(), cities.get(0).getName());
        assertEquals(list.get(1).getName(), cities.get(1).getName());
        assertEquals(list.size(), cities.size());
    }

    @Test
    public void testAddCity() {
        City city3 = new City();
        city3.setId(12356654L);
        city3.setName("Berlin");
        city3.setPopulation(40000);
        city3.setDistrict("BL");
        Country country = new Country();
        country.setName("Germany");
        country.setCode("324");

        Mockito.when(countryRepository.getReferenceById("324")).thenReturn(country);
        cityService.addCity(city3, "324");
        Mockito.verify(cityRepository, Mockito.times(1)).save(city3);
    }

    @Test
    public void testUpdateCityPopulation (){

        Long id = 12356654L;
        Integer population = 90000;

        City city4 = new City();
        city4.setId(12356654L);
        city4.setName("Rome");
        city4.setPopulation(80000);
        city4.setDistrict("RO");
        Country country = new Country();
        country.setName("Italy");
        country.setCode("135");

        Mockito.when(cityRepository.findById(id)).thenReturn(Optional.of(city4));
        assertEquals(city4.getPopulation(), 80000);
        cityService.updateCityPopulation(id, population);
        assertEquals(city4.getPopulation(), 90000);
        Mockito.verify(cityRepository, Mockito.times(1)).save(city4);
    }

    @Test
    public void testDeleteCity(){

        Long id = 13254654L;

        City city5 = new City();
        city5.setId(13254654L);
        city5.setName("Madrid");
        city5.setPopulation(600000);
        city5.setDistrict("MA");
        Country country = new Country();
        country.setName("Spain");
        country.setCode("167");

        Mockito.when(cityRepository.findById(id)).thenReturn(Optional.of(city5));
        cityService.deleteCity(id);
        Mockito.verify(cityRepository, Mockito.times(1)).deleteById(id);
    }
}
