package dev.iannbraga.model.user;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import dev.iannbraga.model.DefaultEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity extends DefaultEntity{

    private String username;
    
    @Column
    private String password;
    
    @ElementCollection
    @Column(name = "role", length = 30)
    @CollectionTable(name = "role", joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"))
    private Set<Role> roles;
}
