package dev.iannbraga.resource;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
