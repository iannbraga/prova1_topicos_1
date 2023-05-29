package dev.iannbraga.model.person;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import dev.iannbraga.model.DefaultEntity;
import dev.iannbraga.model.address.AddressEntity;
import dev.iannbraga.model.user.UserEntity;
import lombok.Data;

@Entity
@Data
@Table(name = "person")
public class PersonEntity extends DefaultEntity{
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;

    private String cpf;

    private String rg;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AddressEntity> address;
}
