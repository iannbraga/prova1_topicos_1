package dev.iannbraga.dto.address;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import dev.iannbraga.model.address.AddressEntity;

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