package com.telran.worldcitiesapp.repository;

import com.telran.worldcitiesapp.model.CountryLanguagePk;
import com.telran.worldcitiesapp.model.CountryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguagePk> {

    List<CountryLanguage> findCountryLanguagesByCountryCode(String code);

}
