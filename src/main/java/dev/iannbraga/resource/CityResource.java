package dev.iannbraga.resource;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import dev.iannbraga.application.Result;
import dev.iannbraga.dto.address.CityDTO;
import dev.iannbraga.dto.address.CityResponseDTO;
import dev.iannbraga.service.CityServiceImpl;

@Path("/cities")
@PermitAll
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CityResource {

    @Inject
    private CityServiceImpl cityService;

    @GET
    public Response listAll() {
        List<CityResponseDTO> list = cityService.listAll();
        return Response.ok(list).build();
    }

    @GET
    @Path("/search/{name}")
    public Response findByName(@PathParam("name") String name) {   
        List<CityResponseDTO> list = cityService.findByName(name);
        return Response.ok(list).build();
    }

    @GET
    @Path("/{id}")
    public CityResponseDTO findById(@PathParam("id") Long id) {
        return cityService.findById(id);
    }

    @POST
    @RolesAllowed("Admin")
    public Response persist(@RequestBody CityDTO receivedEntity) {
        try {
            CityResponseDTO entity =  cityService.persist(receivedEntity);
            return Response.status(Status.CREATED).entity(entity).build();
        }  catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }

    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("Admin")
    public Response update(@PathParam("id") Long id, @RequestBody CityDTO receivedEntity) {
        try {
            CityResponseDTO entity = cityService.update(id, receivedEntity);;
            return Response.status(Status.NO_CONTENT).entity(entity).build();
        
        }  catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("Admin")
    public Response deleteById(@PathParam("id") Long id) {
        cityService.deleteById(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/count")
    public Response count() {
        Long count = cityService.count();
        return Response.status(Status.OK).entity(count).build();
    }
}