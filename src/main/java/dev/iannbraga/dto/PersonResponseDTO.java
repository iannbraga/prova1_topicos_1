package dev.iannbraga.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import dev.iannbraga.model.person.PersonEntity;

public record PersonResponseDTO (
    
    Long id, 
    String firstName,
    String lastName,
    String cpf,
    String rg,
    String email,
    String role,
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    LocalDateTime createdAt,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    LocalDateTime updatedAt
){
        public PersonResponseDTO(PersonEntity entity){        
            this(
                entity.getId(), 
                entity.getFirstName(),
                entity.getLastName(), 
                entity.getCpf(), 
                entity.getRg(), 
                entity.getUser().getUsername(),
                entity.getUser().getRole().name(), 
                entity.getCreatedAt(), 
                entity.getUpdatedAt()
            );
    }
}
