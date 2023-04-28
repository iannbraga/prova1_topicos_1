package dev.iannbraga.dto.user;

import javax.validation.constraints.NotBlank;


public record UserDTO(
    @NotBlank(message = "O campo username deve ser informado.")
    String username,

    @NotBlank(message = "O campo password deve ser informado.")
    String password,
    
    @NotBlank(message = "O campo role deve ser informado.")
    String role
)
{
}