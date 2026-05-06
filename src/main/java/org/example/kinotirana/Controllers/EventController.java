package org.example.kinotirana.Controllers;

import org.example.kinotirana.Entities.Event;
import org.example.kinotirana.Services.EventService;
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
    public Event create(@RequestBody Event event) {
        return eventService.create(event);
    }
    @PutMapping("/{id}")
    public Event update(@PathVariable Long id, @RequestBody Event event) {
        return eventService.update(id, event);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eventService.delete(id);
    }
}