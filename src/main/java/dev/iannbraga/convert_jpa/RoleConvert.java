package dev.iannbraga.convert_jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import dev.iannbraga.model.user.Role;


@Converter(autoApply = true)
public class RoleConvert implements AttributeConverter<Role, String>{

    @Override
    public String convertToDatabaseColumn(Role role) {
        return role == null ? null : role.getLabel();
    }

    @Override
    public Role convertToEntityAttribute(String label) {
        return label == null ? null : Role.valueOf(label.toUpperCase());
    }
    
}
