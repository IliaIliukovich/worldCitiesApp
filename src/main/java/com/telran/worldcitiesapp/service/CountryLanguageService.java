package com.telran.worldcitiesapp.service;

import com.telran.worldcitiesapp.model.CountryLanguage;
import com.telran.worldcitiesapp.model.CountryLanguagePk;
import com.telran.worldcitiesapp.model.enums.IsOfficial;
import com.telran.worldcitiesapp.repository.CountryLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryLanguageService {

    private final CountryLanguageRepository repository;

    @Autowired
    public CountryLanguageService(CountryLanguageRepository repository) {
        this.repository = repository;
    }

    public List<CountryLanguage> getAllCountryLanguages() {
        return repository.findAll();
    }

    public List<CountryLanguage> getAllCountryLanguagesByCountryCode(String code) {
        return repository.findCountryLanguagesByCountryCode(code);
    }

    public void addCountryLanguage(CountryLanguage language) {
        CountryLanguagePk pk = new CountryLanguagePk(language.getCountryCode(), language.getLanguage());
        Optional<CountryLanguage> languageOptional = repository.findById(pk);
        if (languageOptional.isPresent()) throw new RuntimeException("Language is already present");
        repository.save(language);
    }

    public CountryLanguage updateCountryLanguage(String countryCode, String language, double percentage, boolean isOfficial) {
        CountryLanguagePk pk = new CountryLanguagePk(countryCode, language);
        Optional<CountryLanguage> languageOptional = repository.findById(pk);
        if (languageOptional.isPresent()) {
            CountryLanguage countryLanguage = languageOptional.get();
            countryLanguage.setPercentage(percentage);
            countryLanguage.setIsOfficial(isOfficial ? IsOfficial.T : IsOfficial.F);
            return repository.save(countryLanguage);
        }
        return null;
    }

    public void deleteCountryLanguage(String countryCode, String language) {
        repository.deleteById(new CountryLanguagePk(countryCode, language));
    }

    @Override
    public String toString() {
        return "CountryLanguageService{" +
                "repository=" + repository +
                '}';
    }
}
