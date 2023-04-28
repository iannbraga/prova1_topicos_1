package dev.iannbraga.model.product;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
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
