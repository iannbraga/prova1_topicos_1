package dev.iannbraga.dto.address;

import dev.iannbraga.model.address.StateEntity;

public record StateResponseDTO (
    Long id, 
    
    String name,

    String acronym
    
){
        public StateResponseDTO(StateEntity entity){        
            this(entity.getId(), entity.getName(), entity.getAcronym());
        }
}
