package dev.iannbraga.service;

import java.util.List;

import dev.iannbraga.dto.user.UserDTO;
import dev.iannbraga.dto.user.UserResponseDTO;
import dev.iannbraga.model.user.UserEntity;

public interface UserService {

    List<UserResponseDTO> listAll();

    UserResponseDTO findById(Long id);
    
    List<UserResponseDTO> findByName(String name);

    UserResponseDTO persist(UserDTO receivedEntity);

    UserResponseDTO update(Long id, UserDTO receivedEntity);
    
    void deleteById(Long id);

    long count();

    UserEntity findByUsernameAndPassword(String username, String hash);
}
