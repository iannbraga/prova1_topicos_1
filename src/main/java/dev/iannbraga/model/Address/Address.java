package dev.iannbraga.model.Address;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Address {
    private Long id;
    private String address;
    private String complement;
    private City city;
}
