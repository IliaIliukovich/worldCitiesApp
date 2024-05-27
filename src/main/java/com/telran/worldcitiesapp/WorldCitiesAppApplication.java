package com.telran.worldcitiesapp;

import com.telran.worldcitiesapp.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WorldCitiesAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WorldCitiesAppApplication.class, args);


        CountryService service = (CountryService) context.getBean("countryService");
        System.out.println(service);
//        service.getAll().forEach(System.out::println);

    }

}
