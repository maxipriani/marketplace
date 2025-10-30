package com.maxi.marketplace.user.repository;
import com.maxi.marketplace.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {}
