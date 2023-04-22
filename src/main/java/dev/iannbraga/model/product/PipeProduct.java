package dev.iannbraga.model.product;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "pipe_product")
public class PipeProduct extends ProductEntity{
    
    private String material;

    @OneToMany(mappedBy = "pipeProduct", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BuyPipeProduct> pipeProducts;
}
