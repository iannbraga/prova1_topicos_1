package dev.iannbraga.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.iannbraga.model.CityEntity;
import dev.iannbraga.repository.CityRepository;

@Path("/cities")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CityResource {

    @Inject
    private CityRepository cityRepository;

    @GET
    public List<CityEntity> listAll() {
        return cityRepository.findAll().list();
    }
}