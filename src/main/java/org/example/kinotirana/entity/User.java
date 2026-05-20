package org.example.kinotirana.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "USER_ACCOUNT")
public class User {
    @JsonCreator
    public User(@JsonProperty("userId") Long userId) {
        this.userId = userId;
    }
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
    private LocalDateTime userBirthdate;
    private boolean userIsActive = true;
}
