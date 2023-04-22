package dev.iannbraga.service;

import java.util.List;

import dev.iannbraga.dto.address.CityDTO;
import dev.iannbraga.dto.address.CityResponseDTO;

public interface CityService {

    List<CityResponseDTO> listAll();

    CityResponseDTO findById(Long id);
    
    List<CityResponseDTO> findByName(String name);

    CityResponseDTO persist(CityDTO receivedEntity);

    CityResponseDTO update(Long id, CityDTO receivedEntity);
    
    void deleteById(Long id);

    long count();
}
