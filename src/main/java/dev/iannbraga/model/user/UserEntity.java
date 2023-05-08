package dev.iannbraga.model.user;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

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
