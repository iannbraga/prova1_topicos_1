package dev.iannbraga.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "people")
public class PersonEntity extends DefaultEntity{
    
    private String firstName;
    
    private String lastName;

    private String cpf;

    private String rg;

    private LocalDateTime dateOfBirth;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
