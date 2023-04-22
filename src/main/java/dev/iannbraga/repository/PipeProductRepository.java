package dev.iannbraga.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.iannbraga.model.product.PipeProduct;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PipeProductRepository implements PanacheRepository<PipeProduct>{

    public List<PipeProduct> findByName(String name){
        if(name == null) return null;

        String value = "%"+name.toUpperCase()+"%";
        return list("UPPER(description) like ?1", value);
    }

}
