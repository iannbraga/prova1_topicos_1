package dev.iannbraga.repository;

import javax.enterprise.context.ApplicationScoped;

import dev.iannbraga.model.product.BuyPipe;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class BuyPipeRepository implements PanacheRepository<BuyPipe>{

    // public List<BuyPipeProduct> findByName(String name){
    //     if(name == null) return null;

    //     String value = "%"+name.toUpperCase()+"%";
    //     return list("UPPER(address) like ?1", value);
    // }

}
