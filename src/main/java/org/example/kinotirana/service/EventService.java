package org.example.kinotirana.service;

import org.example.kinotirana.entity.Cinema;
import org.example.kinotirana.entity.Event;
import org.example.kinotirana.repository.CinemaRep;
import org.example.kinotirana.repository.EventRep;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EventService {
    private final EventRep eventRep;
    private final CinemaRep cinemaRep;
    public EventService (EventRep eventRep, CinemaRep cinemaRep){

        this.eventRep = eventRep;
        this.cinemaRep = cinemaRep;
    }
    public List <Event> getAll() {

        return eventRep.findByEventIsActiveTrue();
    }

    public Event create(Event event) {
        if (event.getCinema() == null || event.getCinema().getCinemaId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "cinema.cinemaId is required");
             }
        Long cinemaId = event.getCinema().getCinemaId();
        Cinema cinema = cinemaRep.findById(cinemaId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cinema not found"));

        event.setCinema(cinema);
        event.setEventIsActive(true);
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
        if (newEvent.getCinema() != null && newEvent.getCinema().getCinemaId() != null) {
            Cinema cinema = cinemaRep.findById(newEvent.getCinema().getCinemaId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cinema not found"));
            e.setCinema(cinema);
        }
        return eventRep.save(e);
    }

    @Transactional
    public void delete (Long eventId){
        Event e = eventRep.findById(eventId).orElseThrow(() -> new RuntimeException("Event with id: " + eventId + " not found!"));
        e.setEventIsActive(false);
    }
}