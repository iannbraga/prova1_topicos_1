package dev.iannbraga.model.Address;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Country {
    private Long id;
    private String name;
    private String acronym;
}
