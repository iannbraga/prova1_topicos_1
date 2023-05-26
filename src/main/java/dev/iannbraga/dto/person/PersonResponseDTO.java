package dev.iannbraga.dto.person;

import dev.iannbraga.model.person.PersonEntity;

public record PersonResponseDTO (
    
    Long id, 
    String firstName,
    String lastName,
    String cpf,
    String rg,
    String dateOfBirth,
    String email
){
        public PersonResponseDTO(PersonEntity entity){        
            this(
                entity.getId(), 
                entity.getFirstName(),
                entity.getLastName(), 
                entity.getCpf(), 
                entity.getRg(), 
                entity.getDateOfBirth().toString(),
                entity.getUser().getUsername()
            );
    }
}
