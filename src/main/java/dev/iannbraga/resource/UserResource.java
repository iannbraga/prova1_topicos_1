package dev.iannbraga.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import dev.iannbraga.model.user.UserEntity;
import dev.iannbraga.repository.UserRepository;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    private UserRepository userRepository;

    @GET
    public List<UserEntity> listAll() {
        return userRepository.findAll().list();
    }

    @GET
    @Path("/{id}")
    public UserEntity findById(@PathParam("id") Long id) {
        return userRepository.findById(id);
    }

    @POST
    @Transactional
    public UserEntity persist(@RequestBody UserEntity receivedEntity) {
        userRepository.persist(receivedEntity);
        return receivedEntity;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public UserEntity persist(@PathParam("id") Long id, @RequestBody UserEntity receivedEntity) {
 
        UserEntity persistedEntity = userRepository.findById(id);
        persistedEntity.setUsername(receivedEntity.getUsername());
        persistedEntity.setPassword(receivedEntity.getPassword());
        persistedEntity.setRole(receivedEntity.getRole());
        
        return persistedEntity;
    }

    @DELETE
    @Path("/{id}")
    public void deleteById(@PathParam("id") Long id){
        userRepository.deleteById(id);
    }
}