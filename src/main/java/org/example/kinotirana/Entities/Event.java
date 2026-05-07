package org.example.kinotirana.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    @Enumerated(EnumType.STRING)
    private EventAccess eventAccess;
    @Lob
    private String eventDescription;
    @NotBlank
    private String eventTitle;
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventTimestamp;
    @NotNull
    private Address eventLocation;
    private boolean eventOnline;
    private boolean eventIsActive = true;

    public Event(){}

    public Long getEventId() {
        return eventId;
    }
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public EventAccess getEventAccess() {return eventAccess;}
    public void setEventAccess(EventAccess eventAccess) {this.eventAccess = eventAccess;}

    public String getEventDescription() {
        return eventDescription;
    }
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventTitle() {
        return eventTitle;
    }
    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public Date getEventTimestamp() {
        return eventTimestamp;
    }
    public void setEventTimestamp(Date eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public Address getEventLocation() {
        return eventLocation;
    }
    public void setEventLocation(Address eventLocation) {
        this.eventLocation = eventLocation;
    }

    public boolean isEventOnline() {
        return eventOnline;
    }
    public void setEventOnline(boolean eventOnline) {
        this.eventOnline = eventOnline;
    }

    public boolean isEventIsActive() {return eventIsActive;}
    public void setEventIsActive(boolean eventIsActive) {
        this.eventIsActive = eventIsActive;
    }
}
