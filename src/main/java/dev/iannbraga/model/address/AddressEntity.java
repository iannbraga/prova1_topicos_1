package dev.iannbraga.model.address;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import dev.iannbraga.model.DefaultEntity;
import dev.iannbraga.model.person.PersonEntity;
import lombok.Data;

@Entity
@Data
@Table(name = "address")
public class AddressEntity extends DefaultEntity{
    
    private String address;
    
    private String complement;
    
    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;
}
