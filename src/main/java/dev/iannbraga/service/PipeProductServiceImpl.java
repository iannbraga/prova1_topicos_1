package dev.iannbraga.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.NotFoundException;

import dev.iannbraga.dto.product.PipeProductDTO;
import dev.iannbraga.dto.product.PipeProductResponseDTO;
import dev.iannbraga.model.product.PipeProduct;
import dev.iannbraga.repository.PipeProductRepository;

@ApplicationScoped
public class PipeProductServiceImpl implements PipeProductService{

    @Inject
    private PipeProductRepository pipeRepository;
    
    @Inject
    private Validator validator;

    @Override
    public List<PipeProductResponseDTO> listAll() {
        List<PipeProduct> list = pipeRepository.listAll();
        
        return list.stream().map(
            s -> new PipeProductResponseDTO(s)
        ).collect(Collectors.toList());
    }

    @Override
    public PipeProductResponseDTO findById(Long id) {
        PipeProduct entity = pipeRepository.findById(id);     
        if(entity == null)
            throw new NotFoundException("State not found.");
        return new PipeProductResponseDTO(entity);
    }
    
    @Override
    public List<PipeProductResponseDTO> findByDescription(String name) {
        List<PipeProduct> list = pipeRepository.findByName(name);
        
        return list.stream().map(
            s -> new PipeProductResponseDTO(s)
        ).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PipeProductResponseDTO persist(PipeProductDTO receivedEntity) throws ConstraintViolationException{
        validate(receivedEntity);
        
        PipeProduct entity = new PipeProduct();
        entity.setDescription(receivedEntity.description());
        entity.setCharacters(receivedEntity.characters());
        entity.setStock(receivedEntity.stock());
        entity.setPrice(receivedEntity.price());
        entity.setMaterial(receivedEntity.material());
        pipeRepository.persist(entity);
        
        return new PipeProductResponseDTO(entity);
    }

    @Override
    @Transactional
    public PipeProductResponseDTO update(Long id, PipeProductDTO receivedEntity) throws ConstraintViolationException{
        validate(receivedEntity);

        PipeProduct entity = pipeRepository.findById(id);
        entity.setDescription(receivedEntity.description());
        entity.setCharacters(receivedEntity.characters());
        entity.setStock(receivedEntity.stock());
        entity.setPrice(receivedEntity.price());
        entity.setMaterial(receivedEntity.material());

        return new PipeProductResponseDTO(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        pipeRepository.deleteById(id);
    }

    @Override
    public long count() {
        return pipeRepository.count();
    }
    
    private void validate(PipeProductDTO entity) throws ConstraintViolationException {
        Set<ConstraintViolation<PipeProductDTO>> violations = validator.validate(entity);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }

}
