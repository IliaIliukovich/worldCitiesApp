package com.telran.worldcitiesapp.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguagePk implements Serializable {

    private String countryCode;
    private String language;

}
