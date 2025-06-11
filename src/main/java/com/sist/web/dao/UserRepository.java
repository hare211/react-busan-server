package com.sist.web.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sist.web.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	Optional<UserEntity> findByUsername(String username);
}
