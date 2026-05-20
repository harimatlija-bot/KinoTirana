package org.example.kinotirana.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Event")
public class Event {
    @JsonIgnoreProperties({"movieCinemas", "events"})
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
    private LocalDateTime eventTimestamp;
    @Embedded
    private Address eventLocation;
    private boolean eventOnline;
    private boolean eventIsActive = true;
}