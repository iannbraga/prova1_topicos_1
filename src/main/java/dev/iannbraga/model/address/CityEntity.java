package dev.iannbraga.model.address;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.iannbraga.model.DefaultEntity;
import lombok.Data;

@Entity
@Data
@Table(name = "city")
public class CityEntity extends DefaultEntity{
    
    private String name;
    
    @ManyToOne
    private StateEntity state;
}
