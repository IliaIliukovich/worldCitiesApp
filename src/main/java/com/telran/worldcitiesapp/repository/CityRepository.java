package com.telran.worldcitiesapp.repository;

import com.telran.worldcitiesapp.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findCitiesByCountryCode(String code);

}
