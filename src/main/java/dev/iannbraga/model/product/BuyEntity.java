package dev.iannbraga.model.product;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
    private List<BuyPipe> pipes;


}
