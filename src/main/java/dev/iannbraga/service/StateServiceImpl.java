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

import dev.iannbraga.dto.address.StateDTO;
import dev.iannbraga.dto.address.StateResponseDTO;
import dev.iannbraga.model.address.StateEntity;
import dev.iannbraga.repository.StateRepository;

@ApplicationScoped
public class StateServiceImpl implements StateService{

    @Inject
    private StateRepository stateRepository;

    @Inject
    private Validator validator;

    @Override
    public List<StateResponseDTO> listAll() {
        List<StateEntity> list = stateRepository.listAll();
        
        return list.stream().map(
            s -> new StateResponseDTO(s)
        ).collect(Collectors.toList());
    }

    @Override
    public StateResponseDTO findById(Long id){
        StateEntity entity = stateRepository.findById(id);     
        if(entity == null)
            throw new NotFoundException("State not found.");
        return new StateResponseDTO(entity);
    }
    
    @Override
    public List<StateResponseDTO> findByName(String name){
        List<StateEntity> list = stateRepository.findByName(name);
        
        return list.stream().map(
            s -> new StateResponseDTO(s)
        ).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public StateResponseDTO persist(StateDTO receivedEntity) throws ConstraintViolationException {
        validate(receivedEntity);
        
        StateEntity entity = new StateEntity();
        entity.setName(receivedEntity.name());
        entity.setAcronym(receivedEntity.acronym());
        stateRepository.persist(entity);
        
        return new StateResponseDTO(entity);
    }

    @Override
    @Transactional
    public StateResponseDTO update(Long id, StateDTO receivedEntity) throws ConstraintViolationException {
        validate(receivedEntity);

        StateEntity entity = stateRepository.findById(id);
        entity.setName(receivedEntity.name());
        entity.setAcronym(receivedEntity.acronym());
        
        return new StateResponseDTO(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        stateRepository.deleteById(id);
    }

    @Override
    public long count() {
        return stateRepository.count();
    }
    
    private void validate(StateDTO entity) throws ConstraintViolationException {
        Set<ConstraintViolation<StateDTO>> violations = validator.validate(entity);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }
    
}
