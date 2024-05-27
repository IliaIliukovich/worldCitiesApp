package com.telran.worldcitiesapp.repository;

import com.telran.worldcitiesapp.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    @Query("select c from Country c")
    List<Country> customQuery();

    List<Country> findCountriesByCodeOrderByName(String code);


}
