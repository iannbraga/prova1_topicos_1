package dev.iannbraga.service;

import java.util.List;

import dev.iannbraga.dto.person.PersonDTO;
import dev.iannbraga.dto.person.PersonResponseDTO;

public interface PersonService {

    List<PersonResponseDTO> listAll();

    PersonResponseDTO findById(Long id);
    
    List<PersonResponseDTO> findByName(String name);

    PersonResponseDTO persist(PersonDTO receivedEntity);

    PersonResponseDTO update(Long id, PersonDTO receivedEntity);
    
    void deleteById(Long id);

    long count();
}
