package dev.iannbraga.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
@Table(name = "city")
public class CityEntity extends DefaultEntity{
    
    private String name;
    
    @ManyToOne
    @JsonBackReference
    private StateEntity state;
}
