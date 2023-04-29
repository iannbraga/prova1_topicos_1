package dev.iannbraga.dto.product;

import dev.iannbraga.model.product.PipeEntity;

public record PipeResponseDTO(
    Long id,
    
    String description,
    
    String characters,
    
    int stock,

    Double price,

    String status,

    String material
){
    public PipeResponseDTO(PipeEntity p){
        this(
            p.getId(),
            p.getDescription(), 
            p.getCharacters(), 
            p.getStock(), 
            p.getPrice(),
            p.getStatus().name(),
            p.getMaterial()
        );
    }
}
