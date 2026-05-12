package org.example.kinotirana.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Event")
public class Event {
    @ManyToOne
    @JoinColumn(name = "cinemaId")
    private Cinema cinema;
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
    @NotBlank
    @Embedded
    private Address eventLocation;
    private boolean eventOnline;
    private boolean eventIsActive = true;
}
