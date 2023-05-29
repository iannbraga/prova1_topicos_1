package dev.iannbraga.resource;

import jakarta.annotation.security.RolesAllowed;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.jwt.JsonWebToken;

import dev.iannbraga.dto.user.UserDTO;
import dev.iannbraga.dto.user.UserResponseDTO;
import dev.iannbraga.model.user.UserEntity;
import dev.iannbraga.service.HashService;
import dev.iannbraga.service.UserService;


@Path("/usercurrent")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserCurrentResource {

    @Inject
    JsonWebToken jwt;

    @Inject
    UserService userService;

    @Inject
    HashService hashService;

    // @Inject
    // FileService fileService;

    @GET
    @RolesAllowed({"Admin","User"})
    public Response getUsuario() {

        // obtendo o login a partir do token
        String login = jwt.getSubject();
        UserResponseDTO usuario = userService.findByLogin(login);
        return Response.ok(usuario).build();
    }
    
    @PATCH
    @Path("/{id}")
    @RolesAllowed({"Admin","User"})
    public Response updatePassword(@PathParam("id") Long id, UserDTO receivedEntity) {

        // obtendo o login a partir do token
        String login = jwt.getSubject();
        UserResponseDTO usuario = userService.updatePassword(id, login);

        return Response.ok(usuario).build();
    }
    
    // @PATCH
    // @Path("/novaimagem")
    // @RolesAllowed({"Admin","User"})
    // @Consumes(MediaType.MULTIPART_FORM_DATA)
    // public Response salvarImagem(@MultipartForm ImageForm form){
    //     String nomeImagem = "";

    //     try {
    //         nomeImagem = fileService.salvarImagemUsuario(form.getImagem(), form.getNomeImagem());
    //     } catch (IOException e) {
    //         Result result = new Result(e.getMessage());
    //         return Response.status(Status.CONFLICT).entity(result).build();
    //     }

    //     // obtendo o login a partir do token
    //     String login = jwt.getSubject();
    //     UsuarioResponseDTO usuario = userService.findByLogin(login);

    //     usuario = userService.update(usuario.id(), nomeImagem);

    //     return Response.ok(usuario).build();

    // }

    // @GET
    // @Path("/download/{nomeImagem}")
    // @RolesAllowed({"Admin","User"})
    // @Produces(MediaType.APPLICATION_OCTET_STREAM)
    // public Response download(@PathParam("nomeImagem") String nomeImagem) {
    //     ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
    //     response.header("Content-Disposition", "attachment;filename="+nomeImagem);
    //     return response.build();
    // }
    
}
