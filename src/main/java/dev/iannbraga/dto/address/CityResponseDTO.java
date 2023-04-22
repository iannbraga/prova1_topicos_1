package dev.iannbraga.dto.address;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import dev.iannbraga.model.address.CityEntity;

public record CityResponseDTO (
    Long id, 
    
    String name,

    String state,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    LocalDateTime createdAt,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    LocalDateTime updatedAt
){
        public CityResponseDTO(CityEntity entity){        
            this(entity.getId(), entity.getName(), entity.getState().getName(), entity.getCreatedAt(), entity.getUpdatedAt());
        }
}
