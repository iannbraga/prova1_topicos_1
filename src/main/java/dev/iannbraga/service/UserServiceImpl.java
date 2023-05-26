package dev.iannbraga.service;

import java.util.HashSet;
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

import dev.iannbraga.dto.user.UserDTO;
import dev.iannbraga.dto.user.UserResponseDTO;
import dev.iannbraga.model.user.Role;
import dev.iannbraga.model.user.UserEntity;
import dev.iannbraga.repository.UserRepository;

@ApplicationScoped
public class UserServiceImpl implements UserService{

    @Inject
    private UserRepository userRepository;

    @Inject
    HashServiceImpl hashService;

    @Inject
    private Validator validator;

    @Override
    public List<UserResponseDTO> listAll() {
        List<UserEntity> list = userRepository.listAll();
        
        return list.stream().map(
            s -> new UserResponseDTO(s)
        ).collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO findById(Long id){
        UserEntity entity = userRepository.findById(id);     
        if(entity == null)
            throw new NotFoundException("State not found.");
        return new UserResponseDTO(entity);
    }
    
    @Override
    public List<UserResponseDTO> findByName(String name){
        List<UserEntity> list = userRepository.findByName(name);
        
        return list.stream().map(
            s -> new UserResponseDTO(s)
        ).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserResponseDTO persist(UserDTO receivedEntity) throws ConstraintViolationException {
        validate(receivedEntity);
        
        UserEntity entity = new UserEntity();
        entity.setUsername(receivedEntity.username());
        if (receivedEntity.password().equals(receivedEntity.confirmPassword())) {
            entity.setPassword(hashService.getHashSenha(receivedEntity.confirmPassword()));
        }
        entity.setRoles(receivedEntity.roles());
        userRepository.persist(entity);
        
        return new UserResponseDTO(entity);
    }

    @Override
    @Transactional
    public UserResponseDTO update(Long id, UserDTO receivedEntity) throws ConstraintViolationException {
        validate(receivedEntity);

        UserEntity entity = userRepository.findById(id);
        
        entity.setUsername(receivedEntity.username());
        if (receivedEntity.password().equals(receivedEntity.confirmPassword())) {
            entity.setPassword(hashService.getHashSenha(receivedEntity.confirmPassword()));
        }
        entity.setPassword(receivedEntity.password());
        
        entity.setRoles(receivedEntity.roles());
        return new UserResponseDTO(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public long count() {
        return userRepository.count();
    }
    
    private void validate(UserDTO entity) throws ConstraintViolationException {
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(entity);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }

    @Override
    public UserEntity findByUsernameAndPassword(String username, String hash) {
        return userRepository.findByUsernameAndPassword(username, hash);
    }

    @Override
    public UserResponseDTO findByLogin(String username) {
        UserEntity user = userRepository.findByLogin(username);
        if (user == null)
            throw new NotFoundException("Usuário não encontrado.");
        return new UserResponseDTO(user);
    }

    @Override
    public UserResponseDTO updatePassword(Long id, String username) {
        UserEntity user = userRepository.findByLogin(username);
        
        return update(id, new UserDTO(user.getUsername(), user.getPassword(), user.getPassword(), user.getRoles()));
    }
    
}
