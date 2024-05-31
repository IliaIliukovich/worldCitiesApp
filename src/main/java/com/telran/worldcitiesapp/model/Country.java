package com.telran.worldcitiesapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Country implements Serializable {

    @Id
    private String code;

    private String name;

}
