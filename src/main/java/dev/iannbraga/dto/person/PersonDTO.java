package dev.iannbraga.dto.person;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PersonDTO(
    @NotBlank(message = "O campo firstName deve ser informado.")
    String firstName,

    @NotBlank(message = "O campo lastName deve ser informado.")
    String lastName,
    
    @NotBlank(message = "O campo cpf deve ser informado.")
    String cpf,

    @NotBlank(message = "O campo rg deve ser informado.")
    String rg,

    @NotNull(message = "O campo dateOfBirth deve ser informado.")
    @NotEmpty(message = "O campo dateOfBirth deve ser informado.")
    @NotBlank(message = "O campo dateOfBirth deve ser informado.")
    String dateOfBirth,
    
    @NotNull(message = "O campo email deve ser informado.")
    Long idUser
)
{
}