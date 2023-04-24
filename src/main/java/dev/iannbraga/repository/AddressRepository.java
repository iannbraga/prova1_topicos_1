package dev.iannbraga.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.iannbraga.model.address.AddressEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class AddressRepository implements PanacheRepository<AddressEntity>{

    public List<AddressEntity> findByName(String name){
        if(name == null) return null;

        String value = "%"+name.toUpperCase()+"%";
        return list("UPPER(address) like ?1", value);
    }
}
