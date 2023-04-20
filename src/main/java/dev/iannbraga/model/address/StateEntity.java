package dev.iannbraga.model.address;

import javax.persistence.Entity;
import javax.persistence.Table;

import dev.iannbraga.model.DefaultEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "state")
@NoArgsConstructor
@AllArgsConstructor
public class StateEntity extends DefaultEntity{
    
    private String name;
    
    private String acronym;

    // @OneToMany(mappedBy = "state", cascade = CascadeType.ALL, orphanRemoval = true)
    // @JsonManagedReference
    // private List<CityEntity> cities;
}
