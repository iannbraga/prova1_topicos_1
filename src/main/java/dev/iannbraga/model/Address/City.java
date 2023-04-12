package dev.iannbraga.model.Address;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class City {
    private Long id;
    private String name;
    private Country country;
}
