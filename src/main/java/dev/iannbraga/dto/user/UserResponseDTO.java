package dev.iannbraga.dto.user;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

import dev.iannbraga.model.user.Role;
import dev.iannbraga.model.user.UserEntity;

public record UserResponseDTO (
    Long id, 
    
    String username,

    Set<Role> role,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    LocalDateTime createdAt
){
        public UserResponseDTO(UserEntity entity){        
            this(entity.getId(), entity.getUsername(), entity.getRoles(), entity.getCreatedAt());
        }
}
