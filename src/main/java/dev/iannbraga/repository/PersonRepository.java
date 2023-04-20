package dev.iannbraga.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.iannbraga.model.person.PersonEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<PersonEntity>{
    public List<PersonEntity> findByName(String username){
        if(username == null) return null;

        String value = "%"+username.toUpperCase()+"%";
        return list("UPPER(first_name) like ?1", value);
    }
}
