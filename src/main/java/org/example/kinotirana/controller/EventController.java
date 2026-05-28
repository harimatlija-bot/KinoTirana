package org.example.kinotirana.controller;

import jakarta.validation.Valid;
import org.example.kinotirana.dto.EventRequest;
import org.example.kinotirana.entity.Event;
import org.example.kinotirana.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evente")
public class EventController {
    private final EventService eventService;
    public EventController(EventService eventService) {

        this.eventService = eventService;
    }
    @GetMapping
    public List<Event> getAll() {
        return eventService.getAll();
    }
    @PostMapping
    public Event create(@Valid @RequestBody EventRequest eventRequest) {
        return eventService.create(eventRequest);
    }
    @PutMapping("/{id}")
    public Event update(@PathVariable Long id,@Valid @RequestBody Event event) {
        return eventService.update(id, event);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eventService.delete(id);
    }
}