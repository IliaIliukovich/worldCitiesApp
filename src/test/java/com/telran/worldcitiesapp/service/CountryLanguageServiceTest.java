package com.telran.worldcitiesapp.service;

import com.telran.worldcitiesapp.model.CountryLanguage;
import com.telran.worldcitiesapp.model.enums.IsOfficial;
import com.telran.worldcitiesapp.repository.CountryLanguageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CountryLanguageServiceTest {


    private CountryLanguageRepository countryLanguageRepository;
    private CountryLanguageService countryLanguageService;
    private List<CountryLanguage> list;

    @BeforeEach
    public void init(){
        countryLanguageRepository = Mockito.mock(CountryLanguageRepository.class);
        countryLanguageService = new CountryLanguageService(countryLanguageRepository);
        CountryLanguage countryLanguage1 = new CountryLanguage();
        CountryLanguage countryLanguage2 = new CountryLanguage();
        countryLanguage1.setLanguage("Suahilli");
        countryLanguage1.setPercentage(80);
        countryLanguage1.setCountryCode("TNZ");
        countryLanguage1.setIsOfficial(IsOfficial.T);
        countryLanguage2.setLanguage("French");
        countryLanguage2.setPercentage(90);
        countryLanguage2.setCountryCode("FRN");
        countryLanguage2.setIsOfficial(IsOfficial.T);
        list = new ArrayList<>();
        list.add(countryLanguage1);
        list.add(countryLanguage2);
        Mockito.when(countryLanguageRepository.findAll()).thenReturn(list); }

    @Test void getAllCountryLanguages() {
        List<CountryLanguage> countryLanguageList = countryLanguageService.getAllCountryLanguages();
        assertEquals(countryLanguageList.get(0).getLanguage(), list.get(0).getLanguage());
        assertEquals(countryLanguageList.get(1).getLanguage(), list.get(1).getLanguage());
    }


    @Test
    public void getAllCountryLanguagesByCountryCode() {
    }

    @Test
    public void addCountryLanguage() {

//        Assertions.assertThrows()
    }

    @Test
    public void updateCountryLanguage() {
    }

    @Test
    public void deleteCountryLanguage() {
    }
}