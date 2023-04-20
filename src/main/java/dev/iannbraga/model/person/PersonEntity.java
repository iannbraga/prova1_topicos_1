package dev.iannbraga.model.person;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dev.iannbraga.model.DefaultEntity;
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

}
