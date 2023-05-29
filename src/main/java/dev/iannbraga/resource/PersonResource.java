package dev.iannbraga.resource;

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
import dev.iannbraga.dto.person.PersonDTO;
import dev.iannbraga.dto.person.PersonResponseDTO;
import dev.iannbraga.service.PersonServiceImpl;

@Path("/people")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    private PersonServiceImpl personService;

    @GET
    public Response listAll() {
        List<PersonResponseDTO> list = personService.listAll();
        return Response.ok(list).build();
    }

    @GET
    @Path("/search/{name}")
    public Response findByName(@PathParam("name") String name) {   
        List<PersonResponseDTO> list = personService.findByName(name);
        return Response.ok(list).build();
    }

    @GET
    @Path("/{id}")
    public PersonResponseDTO findById(@PathParam("id") Long id) {
        return personService.findById(id);
    }

    @POST
    public Response persist(@RequestBody PersonDTO receivedEntity) {
        try {
            PersonResponseDTO entity =  personService.persist(receivedEntity);
            return Response.status(Status.CREATED).entity(entity).build();
        }  catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }

    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @RequestBody PersonDTO receivedEntity) {
        try {
            PersonResponseDTO entity = personService.update(id, receivedEntity);;
            return Response.status(Status.NO_CONTENT).entity(entity).build();
        
        }  catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") Long id) {
        personService.deleteById(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/count")
    public Response count() {
        Long count = personService.count();
        return Response.status(Status.OK).entity(count).build();
    }
}