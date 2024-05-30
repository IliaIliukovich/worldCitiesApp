package com.telran.worldcitiesapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Entity
public class Country {

    @Id
    private String code;

    private String name;

    @Override
    public String toString() {
        return "Country {" +
                "code = '" + code + '\'' +
                ", name = '" + name + '\'' +
                '}';
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "country")
    private List<City> city;

}
