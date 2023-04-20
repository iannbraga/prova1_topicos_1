package dev.iannbraga.resource;

import java.util.List;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import dev.iannbraga.application.Result;
import dev.iannbraga.dto.UserDTO;
import dev.iannbraga.dto.UserResponseDTO;
import dev.iannbraga.service.UserServiceImpl;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    private UserServiceImpl userService;

    @GET
    public Response listAll() {
        List<UserResponseDTO> list = userService.listAll();
        return Response.ok(list).build();
    }

    @GET
    @Path("/search/{name}")
    public Response findByName(@PathParam("name") String name) {   
        List<UserResponseDTO> list = userService.findByName(name);
        return Response.ok(list).build();
    }

    @GET
    @Path("/{id}")
    public UserResponseDTO findById(@PathParam("id") Long id) {
        return userService.findById(id);
    }

    @POST
    public Response persist(@RequestBody UserDTO receivedEntity) {
        try {
            UserResponseDTO entity =  userService.persist(receivedEntity);
            return Response.status(Status.CREATED).entity(entity).build();
        }  catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }

    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @RequestBody UserDTO receivedEntity) {
        try {
            UserResponseDTO entity = userService.update(id, receivedEntity);;
            return Response.status(Status.CREATED).entity(entity).build();
        
        }  catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") Long id) {
        userService.deleteById(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/count")
    public Response count() {
        Long count = userService.count();
        return Response.status(Status.OK).entity(count).build();
    }
}