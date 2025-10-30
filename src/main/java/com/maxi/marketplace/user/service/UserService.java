package com.maxi.marketplace.user.service;

import com.maxi.marketplace.user.model.UserEntity;
import com.maxi.marketplace.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repo;
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<UserEntity> list() {
        return repo.findAll();
    }

    public UserEntity getOrThrow(Long id) {
        Optional<UserEntity> optionalUserEntity = repo.findById(id);
        if (optionalUserEntity.isEmpty()) {
            throw new IllegalArgumentException("User not found: " + id);
        }
        return optionalUserEntity.get();
    }

    public UserEntity create(String name, String email) {
        UserEntity e = new UserEntity(null, name, email);
        return repo.save(e);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
