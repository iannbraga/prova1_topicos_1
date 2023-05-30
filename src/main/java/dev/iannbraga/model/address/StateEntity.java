package dev.iannbraga.model.address;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import dev.iannbraga.model.DefaultEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
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
