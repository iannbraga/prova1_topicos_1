package dev.iannbraga.resource;

import dev.iannbraga.dto.user.AuthUsuarioDTO;
import dev.iannbraga.dto.user.UserDTO;
import dev.iannbraga.model.user.UserEntity;
import dev.iannbraga.service.HashService;
import dev.iannbraga.service.TokenJwtService;
import dev.iannbraga.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/auth")
public class AuthResource {

    @Inject
    HashService hashService;

    @Inject
    UserService userService;

    @Inject
    TokenJwtService tokenService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(AuthUsuarioDTO authDTO) {
        String hash = hashService.getHashSenha(authDTO.password());

        UserEntity user = userService.findByUsernameAndPassword(authDTO.username(), hash);

        if (user == null) {
            return Response.status(Status.NO_CONTENT)
                .entity("Usuario não encontrado").build();
        } 
        return Response.ok()
            .header("Authorization", tokenService.generateJwt(user))
            // .entity("Token: " + tokenService.generateJwt(user))
            .build();
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response register(UserDTO receivedEntity) {

        // String hash = hashService.getHashSenha(receivedEntity.password());
        
        userService.persist(receivedEntity);

        return Response.ok().build();
    }
}