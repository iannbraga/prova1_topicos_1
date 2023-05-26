package dev.iannbraga.dto.person;

import java.time.LocalDateTime;
import java.util.Set;

import dev.iannbraga.model.person.PersonEntity;
import dev.iannbraga.model.user.Role;

public record PersonResponseDTO (
    
    Long id, 
    String firstName,
    String lastName,
    String cpf,
    String rg,
    LocalDateTime dateOfBirth,
    String email
){
        public PersonResponseDTO(PersonEntity entity){        
            this(
                entity.getId(), 
                entity.getFirstName(),
                entity.getLastName(), 
                entity.getCpf(), 
                entity.getRg(), 
                entity.getDateOfBirth(),
                entity.getUser().getUsername()
            );
    }
}
