package dev.iannbraga.model.product;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

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
