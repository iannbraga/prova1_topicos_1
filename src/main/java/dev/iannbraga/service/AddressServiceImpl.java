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

import dev.iannbraga.dto.AddressDTO;
import dev.iannbraga.dto.AddressResponseDTO;
import dev.iannbraga.dto.AddressDTO;
import dev.iannbraga.model.address.AddressEntity;
import dev.iannbraga.repository.AddressRepository;
import dev.iannbraga.repository.CityRepository;
import dev.iannbraga.repository.PersonRepository;

@ApplicationScoped
public class AddressServiceImpl implements AddressService{

    @Inject
    private CityRepository cityRepository;
    
    @Inject
    private AddressRepository addressRepository;
    
    @Inject
    private PersonRepository personRepository;

    @Inject
    private Validator validator;

    @Override
    public List<AddressResponseDTO> listAll() {
        List<AddressEntity> list = addressRepository.listAll();
        
        return list.stream().map(
            s -> new AddressResponseDTO(s)
        ).collect(Collectors.toList());
    }

    @Override
    public AddressResponseDTO findById(Long id) {
        AddressEntity entity = addressRepository.findById(id);     
        if(entity == null)
            throw new NotFoundException("State not found.");
        return new AddressResponseDTO(entity);
    }
    
    @Override
    public List<AddressResponseDTO> findByStreet(String name) {
        List<AddressEntity> list = addressRepository.findByName(name);
        
        return list.stream().map(
            s -> new AddressResponseDTO(s)
        ).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AddressResponseDTO persist(AddressDTO receivedEntity) throws ConstraintViolationException{
        validate(receivedEntity);
        
        AddressEntity entity = new AddressEntity();
        entity.setAddress(receivedEntity.address());
        entity.setComplement(receivedEntity.complement());
        entity.setCity(cityRepository.findById(receivedEntity.idCity()));
        entity.setPerson(personRepository.findById(receivedEntity.idPerson()));
        addressRepository.persist(entity);
        
        return new AddressResponseDTO(entity);
    }

    @Override
    @Transactional
    public AddressResponseDTO update(Long id, AddressDTO receivedEntity) throws ConstraintViolationException{
        validate(receivedEntity);

        AddressEntity entity = addressRepository.findById(id);
        entity.setAddress(receivedEntity.address());
        entity.setComplement(receivedEntity.complement());
        entity.setCity(cityRepository.findById(receivedEntity.idCity()));
        entity.setPerson(personRepository.findById(receivedEntity.idPerson()));

        return new AddressResponseDTO(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public long count() {
        return addressRepository.count();
    }
    
    private void validate(AddressDTO entity) throws ConstraintViolationException {
        Set<ConstraintViolation<AddressDTO>> violations = validator.validate(entity);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }

}
