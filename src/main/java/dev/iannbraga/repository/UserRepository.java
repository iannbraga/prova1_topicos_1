package dev.iannbraga.repository;

import javax.enterprise.context.ApplicationScoped;

import dev.iannbraga.model.UserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity>{    
}
