package dev.iannbraga.model.address;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import dev.iannbraga.model.DefaultEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "city")
public class CityEntity extends DefaultEntity{
    
    private String name;
    
    @ManyToOne
    private StateEntity state;
}
