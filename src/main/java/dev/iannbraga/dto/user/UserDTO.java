package dev.iannbraga.dto.user;

import java.util.Set;

import javax.validation.constraints.NotBlank;

import dev.iannbraga.model.user.Role;


public record UserDTO(
    @NotBlank(message = "O campo username deve ser informado.")
    String username,

    @NotBlank(message = "O campo password deve ser informado.")
    String password,
    
    Set<Role> roles
){}