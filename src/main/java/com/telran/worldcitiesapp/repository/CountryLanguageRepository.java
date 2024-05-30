package com.telran.worldcitiesapp.repository;

import com.telran.worldcitiesapp.model.CountryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, String> {
}
