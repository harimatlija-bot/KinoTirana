package org.example.kinotirana.Services;

import org.example.kinotirana.Entities.Event;
import org.example.kinotirana.Repositories.EventRep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventService {
    private final EventRep eventRep;
    public EventService (EventRep eventRep){
        this.eventRep = eventRep;
    }
    public List <Event> getAll() {
        return eventRep.findAll();
    }
    public Event create(Event event) {
        return eventRep.save(event);
    }
    @Transactional
    public Event update(Long eventId, Event newEvent) {
        Event e = eventRep.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
        e.setEventAccess(newEvent.getEventAccess());
        e.setEventTitle(newEvent.getEventTitle());
        e.setEventDescription(newEvent.getEventDescription());
        e.setEventLocation(newEvent.getEventLocation());
        e.setEventOnline(newEvent.isEventOnline());
        e.setEventIsActive(newEvent.isEventIsActive());
        e.setEventTimestamp(newEvent.getEventTimestamp());

        return eventRep.save(e);
    }
    @Transactional
    public void delete (Long eventId){
        Event e = eventRep.findById(eventId).orElseThrow(() -> new RuntimeException("Event with id: " + eventId + " not found!"));
        e.setEventIsActive(false);
    }
}