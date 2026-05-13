package org.example.kinotirana.repository;

import org.example.kinotirana.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRep extends JpaRepository<Event, Long> {
    List <Event> findByEventIsActiveTrue();
}
