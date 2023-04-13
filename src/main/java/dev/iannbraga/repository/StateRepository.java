package dev.iannbraga.repository;

import javax.enterprise.context.ApplicationScoped;

import dev.iannbraga.model.StateEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class StateRepository implements PanacheRepository<StateEntity>{    
}
