package dev.iannbraga.service;

import java.util.List;

import dev.iannbraga.dto.PipeProductResponseDTO;
import dev.iannbraga.dto.PipeProductDTO;

public interface PipeProductService {

    List<PipeProductResponseDTO> listAll();

    PipeProductResponseDTO findById(Long id);
    
    List<PipeProductResponseDTO> findByDescription(String name);

    PipeProductResponseDTO persist(PipeProductDTO receivedEntity);

    PipeProductResponseDTO update(Long id, PipeProductDTO receivedEntity);
    
    void deleteById(Long id);

    long count();
}
