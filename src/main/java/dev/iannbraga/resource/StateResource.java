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

import dev.iannbraga.model.address.StateEntity;
import dev.iannbraga.repository.CityRepository;
import dev.iannbraga.repository.StateRepository;

@Path("/states")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StateResource {

    @Inject
    private StateRepository stateRepository;

    @GET
    public List<StateEntity> listAll() {
        return stateRepository.findAll().list();
    }

    @GET
    @Path("/{id}")
    public StateEntity findById(@PathParam("id") Long id) {
        return stateRepository.findById(id);
    }

    @GET
    @Path("/search/{name}")
    public List<StateEntity> findByName(@PathParam("name") String name) {
        
        return stateRepository.findByName(name);
    }

    @POST
    @Transactional
    public StateEntity persit(@RequestBody StateEntity receivedEntity) {
        stateRepository.persist(receivedEntity);
        return receivedEntity;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public StateEntity update(@PathParam("id") Long id, @RequestBody StateEntity receivedEntity) {
        
        StateEntity entity = stateRepository.findById(id);
        entity.setName(receivedEntity.getName());
        entity.setAcronym(receivedEntity.getAcronym());
        
        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteById(@PathParam("id") Long id) {
        stateRepository.deleteById(id);
    }
}