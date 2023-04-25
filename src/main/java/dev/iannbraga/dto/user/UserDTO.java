package dev.iannbraga.dto.user;

import javax.validation.constraints.NotBlank;


public record UserDTO(
    @NotBlank(message = "O campo name deve ser informado.")
    String username,

    @NotBlank(message = "O campo acronym deve ser informado.")
    String password,
    
    @NotBlank(message = "O campo acronym deve ser informado.")
    String role
)
{
}