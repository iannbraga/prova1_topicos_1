package dev.iannbraga.model.address;

import javax.persistence.Entity;
import javax.persistence.Table;

import dev.iannbraga.model.DefaultEntity;
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
