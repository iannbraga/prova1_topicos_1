package dev.iannbraga.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import dev.iannbraga.model.address.StateEntity;

public record StateResponseDTO (
    Long id, 
    
    String name,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    LocalDateTime createdAt,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    LocalDateTime updatedAt
){
        public StateResponseDTO(StateEntity entity){        
            this(entity.getId(), entity.getName(), entity.getCreatedAt(), entity.getUpdatedAt());
        }
}
