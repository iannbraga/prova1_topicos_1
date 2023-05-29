package dev.iannbraga.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PipeDTO(
    @NotBlank(message = "O campo description deve ser informado.")
    String description,
    
    @NotBlank(message = "O campo characters deve ser informado.")
    String characters,
    
    @NotNull(message = "O campo stock deve ser informado.")
    int stock,

    @NotNull(message = "O campo price deve ser informado.")
    Double price,

    @NotBlank(message = "O campo status deve ser informado.")
    String status,

    @NotBlank(message = "O campo material deve ser informado.")
    String material
){
}