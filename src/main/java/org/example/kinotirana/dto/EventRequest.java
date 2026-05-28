package org.example.kinotirana.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.kinotirana.entity.Address;
import org.example.kinotirana.entity.EventAccess;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class   EventRequest {
    @NotNull
    private Long cinemaId;
    private EventAccess eventAccess;
    private String eventDescription;
    @NotBlank
    private String eventTitle;
    private LocalDateTime eventTimestamp;
    private Address eventLocation;
    private boolean eventOnline;
}
