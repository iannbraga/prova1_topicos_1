package dev.iannbraga.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.iannbraga.model.user.UserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity>{
    public List<UserEntity> findByName(String username){
        if(username == null) return null;

        String value = "%"+username.toUpperCase()+"%";
        return list("UPPER(username) like ?1", value);
    }
}
