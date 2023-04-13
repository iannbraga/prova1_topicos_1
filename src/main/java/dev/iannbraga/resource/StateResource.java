package dev.iannbraga.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.iannbraga.model.StateEntity;
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
}