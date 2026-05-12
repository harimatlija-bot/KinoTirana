package org.example.kinotirana.Entities;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Embeddable
public class Address {
    @NotBlank
    private String cityName;
    @NotBlank
    private String streetName;
    @NotNull
    private double streetNr;
    @NotNull
    private int zipCode;
    @NotBlank
    private String country;
}
