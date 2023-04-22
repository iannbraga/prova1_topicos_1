package dev.iannbraga.model.product;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "pipe_product")
public class PipeProduct extends Product{
    
    private String material;
}
