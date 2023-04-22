package dev.iannbraga.service;

import java.util.List;

import dev.iannbraga.dto.AddressResponseDTO;
import dev.iannbraga.dto.AddressDTO;

public interface AddressService {

    List<AddressResponseDTO> listAll();

    AddressResponseDTO findById(Long id);
    
    List<AddressResponseDTO> findByStreet(String name);

    AddressResponseDTO persist(AddressDTO receivedEntity);

    AddressResponseDTO update(Long id, AddressDTO receivedEntity);
    
    void deleteById(Long id);

    long count();
}
