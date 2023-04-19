package dev.iannbraga.model.address;

import javax.persistence.Entity;
import javax.persistence.Table;


import dev.iannbraga.model.DefaultEntity;
import lombok.Data;

@Entity
@Data
@Table(name = "state")
public class StateEntity extends DefaultEntity{
    
    private String name;
    
    private String acronym;

    // @OneToMany(mappedBy = "state", cascade = CascadeType.ALL, orphanRemoval = true)
    // @JsonManagedReference
    // private List<CityEntity> cities;
}
