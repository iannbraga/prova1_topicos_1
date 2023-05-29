package dev.iannbraga.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddressDTO(
    @NotBlank(message = "O campo address deve ser informado.")
    String address,
    
    @NotBlank(message = "O campo complement deve ser informado.")
    String complement,
    
    @NotNull(message = "O campo idCity deve ser informado.")
    Long idCity,

    // @NotNull(message = "O campo idPerson deve ser informado.")
    Long idPerson
){
}