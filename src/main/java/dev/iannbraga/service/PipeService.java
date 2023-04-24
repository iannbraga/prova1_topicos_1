package dev.iannbraga.service;

import java.util.List;

import dev.iannbraga.dto.product.PipeDTO;
import dev.iannbraga.dto.product.PipeResponseDTO;

public interface PipeService {

    List<PipeResponseDTO> listAll();

    PipeResponseDTO findById(Long id);
    
    List<PipeResponseDTO> findByDescription(String name);

    PipeResponseDTO persist(PipeDTO receivedEntity);

    PipeResponseDTO update(Long id, PipeDTO receivedEntity);
    
    void deleteById(Long id);

    long count();
}
