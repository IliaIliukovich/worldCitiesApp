package com.telran.worldcitiesapp.model;

import com.telran.worldcitiesapp.model.enums.IsOfficial;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Table (name = "countrylanguage")

@IdClass(CountryLanguagePk.class)
public class CountryLanguage {

    @Id
    private String countryCode;

    @Id
    private String language;

    @Enumerated(EnumType.STRING)
    private IsOfficial isOfficial;

    private double percentage;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="CountryCode", nullable=false)
//    private Country country;
}
