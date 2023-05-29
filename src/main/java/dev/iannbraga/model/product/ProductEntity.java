package dev.iannbraga.model.product;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;

import dev.iannbraga.model.DefaultEntity;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class ProductEntity extends DefaultEntity{
 
    private String description;

    private String characters;

    private int stock;

    private Double price;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;
}
