package dev.iannbraga.dto.address;

import dev.iannbraga.model.address.AddressEntity;

public record AddressResponseDTO (
    Long id, 
    
    String address,

    String complement,

    String city,

    String person
){
    public AddressResponseDTO(AddressEntity entity){        
        this(
            entity.getId(), 
            entity.getAddress(), 
            entity.getComplement(), 
            entity.getCity().getName(), 
            entity.getPerson().getFirstName()
            );
    }
}
