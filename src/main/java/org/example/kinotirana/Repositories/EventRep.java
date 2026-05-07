package org.example.kinotirana.Repositories;

import org.example.kinotirana.Entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRep extends JpaRepository<Event, Long> {
    List <Event> fingByEventIsActiveTrue();
}
