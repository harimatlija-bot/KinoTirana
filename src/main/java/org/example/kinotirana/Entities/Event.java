package org.example.kinotirana.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Event")
public class Event {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int event_id;
    private String event_access;
    @Lob
    private String event_description;
    private String event_title;
    @Temporal(TemporalType.TIMESTAMP)
    private Date event_timestamp;
    private String event_location;
    private boolean event_online;
    private boolean event_isActive;

    public Event(int event_id, String event_access, String event_description, String event_title, boolean event_isActive, boolean event_online, String event_location, Date event_timestamp) {
        this.event_id = event_id;
        this.event_access = event_access;
        this.event_description = event_description;
        this.event_title = event_title;
        this.event_isActive = event_isActive;
        this.event_online = event_online;
        this.event_location = event_location;
        this.event_timestamp = event_timestamp;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_access() {
        return event_access;
    }

    public void setEvent_access(String event_access) {
        this.event_access = event_access;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public Date getEvent_timestamp() {
        return event_timestamp;
    }

    public void setEvent_timestamp(Date event_timestamp) {
        this.event_timestamp = event_timestamp;
    }

    public String getEvent_location() {
        return event_location;
    }

    public void setEvent_location(String event_location) {
        this.event_location = event_location;
    }

    public boolean isEvent_online() {
        return event_online;
    }

    public void setEvent_online(boolean event_online) {
        this.event_online = event_online;
    }

    public boolean isEvent_isActive() {
        return event_isActive;
    }

    public void setEvent_isActive(boolean event_isActive) {
        this.event_isActive = event_isActive;
    }
}
