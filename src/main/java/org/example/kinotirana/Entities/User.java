package org.example.kinotirana.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "USER")
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
    @NotNull
    @Size(min = 4, max = 32)
    private String userPassword;
    @Past
    @Temporal(TemporalType.DATE)
    private Date userBirthdate;
    private boolean userIsActive = true;
}
