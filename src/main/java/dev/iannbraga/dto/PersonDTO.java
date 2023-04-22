package dev.iannbraga.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public record PersonDTO(
    @NotBlank(message = "O campo firstName deve ser informado.")
    String firstName,

    @NotBlank(message = "O campo lastName deve ser informado.")
    String lastName,
    
    @NotBlank(message = "O campo cpf deve ser informado.")
    String cpf,

    @NotBlank(message = "O campo rg deve ser informado.")
    String rg,

    @NotBlank(message = "O campo dateOfBirth deve ser informado.")
    String dateOfBirth,
    
    @NotNull(message = "O campo email deve ser informado.")
    Long idUser
)
{
    // Constructos methods
}