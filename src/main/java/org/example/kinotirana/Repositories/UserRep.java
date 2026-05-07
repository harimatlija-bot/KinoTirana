package org.example.kinotirana.Repositories;

import org.example.kinotirana.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRep extends JpaRepository<User, Long> {
    List<User> findByUserIsActiveTrue();
}