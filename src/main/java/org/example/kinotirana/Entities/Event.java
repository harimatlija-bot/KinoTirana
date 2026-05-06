package org.example.kinotirana.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    private String eventAccess;
    @Lob
    private String eventDescription;
    private String eventTitle;
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventTimestamp;
    private Address eventLocation;
    private boolean eventOnline;
    private boolean eventIsActive;

    public Event(Long eventId, String eventAccess, String eventDescription, String eventTitle, Date eventTimestamp, Address eventLocation, boolean eventOnline, boolean eventIsActive) {
        this.eventId = eventId;
        this.eventAccess = eventAccess;
        this.eventDescription = eventDescription;
        this.eventTitle = eventTitle;
        this.eventTimestamp = eventTimestamp;
        this.eventLocation = eventLocation;
        this.eventOnline = eventOnline;
        this.eventIsActive = eventIsActive;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventAccess() {
        return eventAccess;
    }

    public void setEventAccess(String eventAccess) {
        this.eventAccess = eventAccess;
    }

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

    public boolean isEventIsActive() {
        return eventIsActive;
    }

    public void setEventIsActive(boolean eventIsActive) {
        this.eventIsActive = eventIsActive;
    }
}
