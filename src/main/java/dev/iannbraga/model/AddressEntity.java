package dev.iannbraga.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "address")
public class AddressEntity extends DefaultEntity{
    
    private String address;
    
    private String complement;
    // TODO Relacionamento entre Address e City
    // private City city;
}
