package dev.iannbraga.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public record CityDTO(
    @NotBlank(message = "O campo name deve ser informado.")
    String name,

    @NotNull(message = "O campo idState deve ser informado.")
    long idState
){
    // Constructos methods
}