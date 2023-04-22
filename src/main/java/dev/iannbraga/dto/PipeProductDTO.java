package dev.iannbraga.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import dev.iannbraga.model.product.PipeProduct;

public record PipeProductDTO(
    @NotBlank(message = "O campo address deve ser informado.")
    String description,
    
    @NotBlank(message = "O campo address deve ser informado.")
    String characters,
    
    @NotNull(message = "O campo idPerson deve ser informado.")
    @Min(value = 1)
    @Max(value = 50)
    int stock,

    @NotNull(message = "O campo idPerson deve ser informado.")
    @Min(value = 0)
    Double price,

    @NotBlank(message = "O campo address deve ser informado.")
    String material
){
    public PipeProductDTO(PipeProduct p){
        this(
            p.getDescription(), 
            p.getCharacters(), 
            p.getStock(), 
            p.getPrice(),
            p.getMaterial()
        );
    }
}