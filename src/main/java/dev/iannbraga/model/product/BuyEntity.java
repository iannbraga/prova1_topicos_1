package dev.iannbraga.model.product;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dev.iannbraga.model.DefaultEntity;
import dev.iannbraga.model.address.AddressEntity;
import dev.iannbraga.model.person.PersonEntity;
import lombok.Data;

@Entity
@Data
@Table(name = "buy")
public class BuyEntity extends DefaultEntity {
    
    // private LocalDateTime dateOfBuy;

    private String description;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @OneToMany(mappedBy = "buy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BuyPipeProduct> pipeProducts;


}
