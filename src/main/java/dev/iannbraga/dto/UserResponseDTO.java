package dev.iannbraga.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import dev.iannbraga.model.user.UserEntity;

public record UserResponseDTO (
    Long id, 
    
    String username,

    String role,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    LocalDateTime createdAt,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    LocalDateTime updatedAt
){
        public UserResponseDTO(UserEntity entity){        
            this(entity.getId(), entity.getUsername(), entity.getRole().name(), entity.getCreatedAt(), entity.getUpdatedAt());
        }
}
