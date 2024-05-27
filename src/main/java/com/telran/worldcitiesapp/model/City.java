package com.telran.worldcitiesapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class City {

    @Id
    private Long id;

    private String name;

    private double population;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CountryCode")
    private Country country;

}
