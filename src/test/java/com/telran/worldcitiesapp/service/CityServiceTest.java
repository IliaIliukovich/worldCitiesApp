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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityServiceTest {

    private CityRepository repository;
    private CountryRepository countryRepository;
    private List<City> list = new ArrayList<>();
    private CityService service;

    @BeforeEach
    public void init() {
        repository = Mockito.mock(CityRepository.class);
        countryRepository = Mockito.mock(CountryRepository.class);
        service = new CityService(repository,countryRepository);

        City city1 = new City();
        City city2 = new City();
        city1.setId(65465464L);
        city2.setId(65465464L);
        city1.setName("New-York");
        city2.setName("London");
        city1.setDistrict("NY1");
        city2.setDistrict("L2");
        city1.setPopulation(100000);
        city2.setPopulation(200000);
        list.add(city1);
        list.add(city2);

        Mockito.when(repository.findAll()).thenReturn(list);

    }

    @Test
    public void testGetAllCities() {

        List<City> cities = service.getAllCities();
        assertEquals(list.get(0).getName(), cities.get(0).getName());
        assertEquals(list.get(1).getName(), cities.get(1).getName());
    }

    @Test
    public void testAddCity(){
        City city3 = new City();
        city3.setId(12356654L);
        city3.setName("Berlin");
        city3.setPopulation(40000);
        city3.setDistrict("B3");
        Country country = new Country();
        country.setName("Germany");
        country.setCode("324");
        Mockito.when(countryRepository.getReferenceById("324")).thenReturn(country);
        service.addCity(city3,"324");
        Mockito.verify(repository, Mockito.times(1)).save(city3);
    }

    @Test
    public void testGetAllByCountry() {
        String code = "skksksddkdk";
        service.getAllCitiesByCountry(code);
        Mockito.verify(repository).findCitiesByCountryCode(code);
    }
}
