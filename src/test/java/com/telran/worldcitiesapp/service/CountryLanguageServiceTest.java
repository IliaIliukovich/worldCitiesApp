package com.telran.worldcitiesapp.service;

import com.telran.worldcitiesapp.model.CountryLanguage;
import com.telran.worldcitiesapp.model.CountryLanguagePk;
import com.telran.worldcitiesapp.model.enums.IsOfficial;
import com.telran.worldcitiesapp.repository.CountryLanguageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

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
        Mockito.when(countryLanguageRepository.findAll()).thenReturn(list);
        Mockito.when(countryLanguageRepository.findById(any())).thenReturn(Optional.of(countryLanguage1));
    };

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
        String countryCode = "TNZ";
        String language = "Suahilli";
        double percentage = 79;
        boolean isOfficial = false;
        CountryLanguage updateCountryLanguage  = countryLanguageService.updateCountryLanguage(countryCode,language,percentage,isOfficial);
        System.out.println(updateCountryLanguage);
        Assertions.assertEquals(percentage,updateCountryLanguage.getPercentage());
        Assertions.assertEquals(isOfficial,updateCountryLanguage.getIsOfficial());
    }

    @Test
    public void deleteCountryLanguage() {
        String countryCode = "2525hdjj";
        String language = "pret";
        countryLanguageService.deleteCountryLanguage(countryCode,language);
        Mockito.verify(countryLanguageRepository).deleteById(any());
    }

//    @Test
//
//    public void testGetAllByCountry() {
//        String code = "skksksddkdk";
//        service.getAllCitiesByCountry(code);
//        Mockito.verify(repository).findCitiesByCountryCode(code);
//
//    }
}


//        CountryLanguagePk pk = new CountryLanguagePk(countryCode, language);
//        Optional<CountryLanguage> languageOptional = repository.findById(pk);
//        if (languageOptional.isPresent()) {
//            CountryLanguage countryLanguage = languageOptional.get();
//            countryLanguage.setPercentage(percentage);
//            countryLanguage.setIsOfficial(isOfficial ? IsOfficial.T : IsOfficial.F);
//            return repository.save(countryLanguage);
//        }
//       return null;