package dev.iannbraga.resource;

import dev.iannbraga.dto.user.AuthUsuarioDTO;
import dev.iannbraga.dto.user.UserDTO;
import dev.iannbraga.model.user.UserEntity;
import dev.iannbraga.service.HashService;
import dev.iannbraga.service.TokenJwtService;
import dev.iannbraga.service.UserService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

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