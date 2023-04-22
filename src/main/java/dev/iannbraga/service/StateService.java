package dev.iannbraga.service;

import java.util.List;

import dev.iannbraga.dto.address.StateDTO;
import dev.iannbraga.dto.address.StateResponseDTO;

public interface StateService {

    List<StateResponseDTO> listAll();

    StateResponseDTO findById(Long id);
    
    List<StateResponseDTO> findByName(String name);

    StateResponseDTO persist(StateDTO receivedEntity);

    StateResponseDTO update(Long id, StateDTO receivedEntity);
    
    void deleteById(Long id);

    long count();
}
