package dev.iannbraga.dto;

import javax.validation.constraints.NotBlank;


public record StateDTO(
    @NotBlank(message = "O campo name deve ser informado.")
    String name,

    @NotBlank(message = "O campo acronym deve ser informado.")
    String acronym
)
{
    // Constructos methods
}