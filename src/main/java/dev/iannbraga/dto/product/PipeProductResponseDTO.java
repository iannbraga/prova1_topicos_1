package dev.iannbraga.dto.product;

import dev.iannbraga.model.product.PipeProduct;

public record PipeProductResponseDTO (
    String description,
    
    String characters,
    
    int stock,

    Double price,

    String material
){
    public PipeProductResponseDTO(PipeProduct p){
        this(
            p.getDescription(), 
            p.getCharacters(), 
            p.getStock(), 
            p.getPrice(),
            p.getMaterial()
        );
    }
}
