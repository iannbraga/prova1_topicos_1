package dev.iannbraga.dto.product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import dev.iannbraga.model.product.BuyPipeProduct;

public record BuyPipeProductDTO(
    @NotBlank(message = "O campo description não pode ser nulo")
    Long idPipeProduct,
    
    @NotNull(message = "O campo idBuy não pode ser nulo")
    Long idBuy,
    
    @NotNull(message = "O campo amount não pode ser nulo")
    int amount
){
    public BuyPipeProductDTO(BuyPipeProduct e){
        this(
            e.getPipeProduct().getId(), 
            e.getBuy().getId(), 
            e.getAmount()
        );
    }
}