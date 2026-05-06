package org.example.kinotirana.Repositories;

import org.example.kinotirana.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User, Long> {
}
