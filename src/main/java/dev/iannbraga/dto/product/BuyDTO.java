package dev.iannbraga.dto.product;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import dev.iannbraga.model.product.BuyEntity;

public record BuyDTO(
    @NotBlank(message = "O campo description não pode ser nulo")
    String description,

    @NotNull(message = "O campo idUser não pode ser nulo")
    Long idUser,

    @NotNull(message = "O campo idAddress não pode ser nulo")
    Long idAddress,

    @NotNull(message = "O campo idProducts não pode ser nulo")
    List<Long> idPipeProducts
){
    public BuyDTO(BuyEntity e){
        this(
            e.getDescription(), 
            e.getPerson().getId(), 
            e.getAddress().getId(),
            e.getPipeProducts().stream().map(
                p -> p.getPipeProduct().getId()
                ).collect(Collectors.toList())
        );
    }
}