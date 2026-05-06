package org.example.kinotirana.Entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String userSurname;
    private String userEmail;
    @Temporal(TemporalType.TIMESTAMP)
    private Date userBirthdate;
    private boolean userIsActive;

    public User(Long userId, String userName, String userSurname, String userEmail, Date userBirthdate, boolean userIsActive) {
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
        this.userBirthdate = userBirthdate;
        this.userIsActive = userIsActive;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean isUserIsActive() {
        return userIsActive;
    }

    public void setUserIsActive(boolean userIsActive) {
        this.userIsActive = userIsActive;
    }

    public Date getUserBirthdate() {
        return userBirthdate;
    }

    public void setUserBirthdate(Date userBirthdate) {
        this.userBirthdate = userBirthdate;
    }
}
