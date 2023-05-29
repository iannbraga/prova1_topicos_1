package dev.iannbraga.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

import dev.iannbraga.model.address.StateEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class StateRepository implements PanacheRepository<StateEntity>{       
    
    public List<StateEntity> findByName(String name){
        if(name == null) return null;

        String value = "%"+name.toUpperCase()+"%";
        return list("UPPER(name) like ?1", value);
    }
}
