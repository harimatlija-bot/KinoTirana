package org.example.kinotirana.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@JsonIgnoreProperties({"reservations", "reviews"})
@Entity
@Table(name = "USER_ACCOUNT")
public class User {
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotBlank(message = "Name is required")
    private String userName;
    @NotBlank
    private String userSurname;
    @NotBlank(message = "Email is required")
    private String userEmail;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    @Size(min = 4, max = 32)
    private String userPassword;
    @Past
    private LocalDate userBirthdate;
    private boolean userIsActive = true;
}
