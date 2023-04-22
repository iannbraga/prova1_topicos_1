package dev.iannbraga.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

import dev.iannbraga.dto.person.PersonDTO;
import dev.iannbraga.dto.person.PersonResponseDTO;
import dev.iannbraga.model.person.PersonEntity;
import dev.iannbraga.repository.AddressRepository;
import dev.iannbraga.repository.PersonRepository;
import dev.iannbraga.repository.UserRepository;

@ApplicationScoped
public class PersonServiceImpl implements PersonService{

    @Inject
    private PersonRepository personRepository;

    @Inject
    private UserRepository userRepository;
    
    @Inject
    private Validator validator;

    @Override
    public List<PersonResponseDTO> listAll() {
        List<PersonEntity> list = personRepository.listAll();
        
        return list.stream().map(
            s -> new PersonResponseDTO(s)
        ).collect(Collectors.toList());
    }

    @Override
    public PersonResponseDTO findById(Long id){
        PersonEntity entity = personRepository.findById(id);     
        if(entity == null)
            throw new NotFoundException("State not found.");
        return new PersonResponseDTO(entity);
    }
    
    @Override
    public List<PersonResponseDTO> findByName(String name){
        List<PersonEntity> list = personRepository.findByName(name);
        
        return list.stream().map(
            s -> new PersonResponseDTO(s)
        ).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PersonResponseDTO persist(PersonDTO receivedEntity) throws ConstraintViolationException {
        validate(receivedEntity);
        
        PersonEntity entity = new PersonEntity();
        entity.setFirstName(receivedEntity.firstName());
        entity.setLastName(receivedEntity.lastName());
        entity.setCpf(receivedEntity.cpf());
        entity.setRg(receivedEntity.rg());
        entity.setDateOfBirth(convertStringToDate(receivedEntity.dateOfBirth()));
        entity.setUser(userRepository.findById(receivedEntity.idUser()));
        // TODO Address

        personRepository.persist(entity);
        
        return new PersonResponseDTO(entity);
    }

    @Override
    @Transactional
    public PersonResponseDTO update(Long id, PersonDTO receivedEntity) throws ConstraintViolationException {
        validate(receivedEntity);

        PersonEntity entity = personRepository.findById(id);
        entity.setFirstName(receivedEntity.firstName());
        entity.setLastName(receivedEntity.lastName());
        entity.setCpf(receivedEntity.cpf());
        entity.setRg(receivedEntity.rg());
        entity.setDateOfBirth(convertStringToDate(receivedEntity.dateOfBirth()));
        entity.setUser(userRepository.findById(receivedEntity.idUser()));
        // TODO Address

        return new PersonResponseDTO(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public long count() {
        return personRepository.count();
    }
    
    private void validate(PersonDTO entity) throws ConstraintViolationException {
        Set<ConstraintViolation<PersonDTO>> violations = validator.validate(entity);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }

    public LocalDateTime convertStringToDate(String date){
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        LocalDateTime dateTime = LocalDate.parse(date, parser).atStartOfDay();
        return dateTime;
    }
    
}
