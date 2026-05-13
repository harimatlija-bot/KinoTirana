package org.example.kinotirana.repository;

import org.example.kinotirana.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRep extends JpaRepository<User, Long> {
    List<User> findByUserIsActiveTrue();
}