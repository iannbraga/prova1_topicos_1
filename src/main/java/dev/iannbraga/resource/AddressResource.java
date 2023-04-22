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
import dev.iannbraga.dto.address.AddressDTO;
import dev.iannbraga.dto.address.AddressResponseDTO;
import dev.iannbraga.service.AddressServiceImpl;

@Path("/addresses")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AddressResource {

    @Inject
    private AddressServiceImpl addressService;

    @GET
    public Response listAll() {
        List<AddressResponseDTO> list = addressService.listAll();
        return Response.ok(list).build();
    }

    @GET
    @Path("/search/{name}")
    public Response findByName(@PathParam("name") String name) {   
        List<AddressResponseDTO> list = addressService.findByStreet(name);
        return Response.ok(list).build();
    }

    @GET
    @Path("/{id}")
    public AddressResponseDTO findById(@PathParam("id") Long id) {
        return addressService.findById(id);
    }

    @POST
    public Response persist(@RequestBody AddressDTO receivedEntity) {
        try {
            AddressResponseDTO entity =  addressService.persist(receivedEntity);
            return Response.status(Status.CREATED).entity(entity).build();
        }  catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }

    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @RequestBody AddressDTO receivedEntity) {
        try {
            AddressResponseDTO entity = addressService.update(id, receivedEntity);;
            return Response.status(Status.CREATED).entity(entity).build();
        
        }  catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteById(@PathParam("id") Long id) {
        addressService.deleteById(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/count")
    public Response count() {
        Long count = addressService.count();
        return Response.status(Status.OK).entity(count).build();
    }
}