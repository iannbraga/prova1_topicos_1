package dev.iannbraga.dto.product;

import dev.iannbraga.model.product.PipeEntity;

public record PipeResponseDTO (
    String description,
    
    String characters,
    
    int stock,

    Double price,

    String material
){
    public PipeResponseDTO(PipeEntity p){
        this(
            p.getDescription(), 
            p.getCharacters(), 
            p.getStock(), 
            p.getPrice(),
            p.getMaterial()
        );
    }
}
