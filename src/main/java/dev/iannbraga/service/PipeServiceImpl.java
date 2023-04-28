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

import dev.iannbraga.dto.product.PipeDTO;
import dev.iannbraga.dto.product.PipeResponseDTO;
import dev.iannbraga.model.product.PipeEntity;
import dev.iannbraga.model.product.ProductStatus;
import dev.iannbraga.repository.PipeRepository;

@ApplicationScoped
public class PipeServiceImpl implements PipeService{

    @Inject
    private PipeRepository pipeRepository;
    
    @Inject
    private Validator validator;

    @Override
    public List<PipeResponseDTO> listAll() {
        List<PipeEntity> list = pipeRepository.listAll();
        
        return list.stream().map(
            s -> new PipeResponseDTO(s)
        ).collect(Collectors.toList());
    }

    @Override
    public PipeResponseDTO findById(Long id) {
        PipeEntity entity = pipeRepository.findById(id);     
        if(entity == null)
            throw new NotFoundException("State not found.");
        return new PipeResponseDTO(entity);
    }
    
    @Override
    public List<PipeResponseDTO> findByDescription(String name) {
        List<PipeEntity> list = pipeRepository.findByName(name);
        
        return list.stream().map(
            s -> new PipeResponseDTO(s)
        ).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PipeResponseDTO persist(PipeDTO receivedEntity) throws ConstraintViolationException{
        validate(receivedEntity);
        
        PipeEntity entity = new PipeEntity();
        entity.setDescription(receivedEntity.description());
        entity.setCharacters(receivedEntity.characters());
        entity.setStock(receivedEntity.stock());
        entity.setPrice(receivedEntity.price());
        entity.setStatus(validateStatus(receivedEntity.status()));
        entity.setMaterial(receivedEntity.material());
        
        pipeRepository.persist(entity);
        
        return new PipeResponseDTO(entity);
    }

    @Override
    @Transactional
    public PipeResponseDTO update(Long id, PipeDTO receivedEntity) throws ConstraintViolationException{
        validate(receivedEntity);

        PipeEntity entity = pipeRepository.findById(id);
        entity.setDescription(receivedEntity.description());
        entity.setCharacters(receivedEntity.characters());
        entity.setStock(receivedEntity.stock());
        entity.setPrice(receivedEntity.price());
        entity.setMaterial(receivedEntity.material());

        return new PipeResponseDTO(entity);
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
    
    private void validate(PipeDTO entity) throws ConstraintViolationException {
        Set<ConstraintViolation<PipeDTO>> violations = validator.validate(entity);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }

    private ProductStatus validateStatus(String status){
        if(status.toUpperCase().equals("DISPONIVEL")){
            return ProductStatus.DISPONIVEL;
        }
        else if(status.toUpperCase().equals("INDISPONIVEL")){
            return ProductStatus.INDISPONIVEL;
        }
        else{
            return null;
        }
    }

}
