package dev.iannbraga.dto.product;

import java.util.List;
import java.util.stream.Collectors;

import dev.iannbraga.model.product.BuyEntity;

public record BuyResponseDTO (
    String description,

    String nameUser,

    String address,

    List<String> products
){
    public BuyResponseDTO(BuyEntity b){
        this(
            b.getDescription(), 
            b.getPerson().getFirstName(), 
            b.getAddress().getAddress(), 
            b.getPipeProducts().stream().map(
                p -> p.getPipeProduct().getDescription()
                ).collect(Collectors.toList())
        );
    }
}
