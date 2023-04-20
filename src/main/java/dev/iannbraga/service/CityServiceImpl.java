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

import dev.iannbraga.dto.CityDTO;
import dev.iannbraga.dto.CityResponseDTO;
import dev.iannbraga.model.address.CityEntity;
import dev.iannbraga.repository.CityRepository;
import dev.iannbraga.repository.StateRepository;

@ApplicationScoped
public class CityServiceImpl implements CityService{

    @Inject
    private CityRepository cityRepository;
    
    @Inject
    private StateRepository stateRepository;
    
    @Inject
    private Validator validator;

    @Override
    public List<CityResponseDTO> listAll() {
        List<CityEntity> list = cityRepository.listAll();
        
        return list.stream().map(
            s -> new CityResponseDTO(s)
        ).collect(Collectors.toList());
    }

    @Override
    public CityResponseDTO findById(Long id) {
        CityEntity entity = cityRepository.findById(id);     
        if(entity == null)
            throw new NotFoundException("State not found.");
        return new CityResponseDTO(entity);
    }
    
    @Override
    public List<CityResponseDTO> findByName(String name) {
        List<CityEntity> list = cityRepository.findByName(name);
        
        return list.stream().map(
            s -> new CityResponseDTO(s)
        ).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CityResponseDTO persist(CityDTO receivedEntity) throws ConstraintViolationException{
        validate(receivedEntity);
        
        CityEntity entity = new CityEntity();
        entity.setName(receivedEntity.name());
        entity.setState(stateRepository.findById(receivedEntity.idState()));
        cityRepository.persist(entity);
        
        return new CityResponseDTO(entity);
    }

    @Override
    @Transactional
    public CityResponseDTO update(Long id, CityDTO receivedEntity) throws ConstraintViolationException{
        validate(receivedEntity);

        CityEntity entity = cityRepository.findById(id);
        entity.setName(receivedEntity.name());      
        entity.setState(stateRepository.findById(receivedEntity.idState()));
        return new CityResponseDTO(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public long count() {
        return cityRepository.count();
    }
    
    private void validate(CityDTO entity) throws ConstraintViolationException {
        Set<ConstraintViolation<CityDTO>> violations = validator.validate(entity);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }

}
