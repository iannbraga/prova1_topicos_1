package dev.iannbraga.repository;

import javax.enterprise.context.ApplicationScoped;

import dev.iannbraga.model.CityEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CityRepository implements PanacheRepository<CityEntity>{    
}
