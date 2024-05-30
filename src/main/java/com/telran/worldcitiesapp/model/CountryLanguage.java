package com.telran.worldcitiesapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
public class CountryLanguage {
    @Id
//    private String countryCode;
    private String language;
    private Boolean isOfficial;
    private Double percentage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CountryCode")
    private Country country;
}
