package dev.iannbraga.service;

import dev.iannbraga.model.user.UserEntity;

public interface TokenJwtService {
    public String generateJwt(UserEntity user);
}
