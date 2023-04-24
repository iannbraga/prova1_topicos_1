package dev.iannbraga.dto.person;

import java.time.LocalDateTime;

import dev.iannbraga.model.person.PersonEntity;

public record PersonResponseDTO (
    
    Long id, 
    String firstName,
    String lastName,
    String cpf,
    String rg,
    LocalDateTime dateOfBirth,
    String email,
    String role
){
        public PersonResponseDTO(PersonEntity entity){        
            this(
                entity.getId(), 
                entity.getFirstName(),
                entity.getLastName(), 
                entity.getCpf(), 
                entity.getRg(), 
                entity.getDateOfBirth(),
                entity.getUser().getUsername(),
                entity.getUser().getRole().name()
            );
    }
}
