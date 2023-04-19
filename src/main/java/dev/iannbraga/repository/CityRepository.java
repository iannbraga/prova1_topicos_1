package dev.iannbraga.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.iannbraga.model.address.CityEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CityRepository implements PanacheRepository<CityEntity>{

    List<CityEntity> findByName(String name){
        String value = "%"+name.toUpperCase()+"%";
        return list("UPPER(name) like ?1", value);
    }
}
