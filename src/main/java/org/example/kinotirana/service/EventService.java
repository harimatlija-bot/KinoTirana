package org.example.kinotirana.service;

import org.example.kinotirana.dto.EventRequest;
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

    public Event create(EventRequest eventRequest) {
        Cinema cinema = cinemaRep.findById(eventRequest.getCinemaId())
                .orElseThrow(() -> new RuntimeException("Cinema not found"));
        if (eventRep.existsByEventTitleAndEventTimestampAndEventLocation(
                eventRequest.getEventTitle(),
                eventRequest.getEventTimestamp(),
                eventRequest.getEventLocation()
        )){throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "This event already exists");
        }
        Event event = new Event();
        event.setCinema(cinema);
        event.setEventIsActive(true);
        event.setEventAccess(eventRequest.getEventAccess());
        event.setEventDescription(eventRequest.getEventDescription());
        event.setEventLocation(eventRequest.getEventLocation());
        event.setEventTimestamp(eventRequest.getEventTimestamp());
        event.setEventTitle(eventRequest.getEventTitle());
        event.setEventOnline(eventRequest.isEventOnline());
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