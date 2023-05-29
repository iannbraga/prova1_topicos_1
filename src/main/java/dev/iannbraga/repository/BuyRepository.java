package dev.iannbraga.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

import dev.iannbraga.model.product.BuyEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class BuyRepository implements PanacheRepository<BuyEntity>{

    public List<BuyEntity> findByName(String name){
        if(name == null) return null;

        String value = "%"+name.toUpperCase()+"%";
        return list("UPPER(description) like ?1", value);
    }

}
