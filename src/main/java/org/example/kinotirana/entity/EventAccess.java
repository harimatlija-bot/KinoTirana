package org.example.kinotirana.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EventAccess {
    PUBLIC, PRIVATE;
    @JsonCreator
    public static EventAccess fromString(String value) {
        return value == null ? null : EventAccess.valueOf(value.toUpperCase());
    }
}