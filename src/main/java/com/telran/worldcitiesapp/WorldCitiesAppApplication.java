package com.telran.worldcitiesapp;

import com.telran.worldcitiesapp.model.City;
import com.telran.worldcitiesapp.model.Country;
import com.telran.worldcitiesapp.repository.CityRepository;
import com.telran.worldcitiesapp.repository.CountryRepository;
import com.telran.worldcitiesapp.service.CityService;
import com.telran.worldcitiesapp.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WorldCitiesAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WorldCitiesAppApplication.class, args);


        CountryService service = (CountryService) context.getBean("countryService");
        CityService cityService = (CityService) context.getBean("cityService");
        CountryRepository countryRepository = (CountryRepository) context.getBean("countryRepository");

        System.out.println(service);
//        service.getAll().forEach(System.out::println);

//        Country country = new Country();
//        country.setCode("AAA");
//        country.setName("Antarktida");
//        service.addCountry(country);

        City city = new City();
      //  city.setId(1111111L);
        city.setName("San Francisco");
        city.setPopulation(1234567);

        Country country = countryRepository.getReferenceById("AAA");
        city.setCountry(country);
        cityService.addCity(city);
    }

}
