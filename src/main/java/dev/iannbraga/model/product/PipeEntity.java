package dev.iannbraga.model.product;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "pipe")
public class PipeEntity extends ProductEntity{
    
    private String material;

    @OneToMany(mappedBy = "pipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BuyPipe> pipes;
}
