package org.example.kinotirana.Entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String user_name;
    private String user_surname;
    private String user_email;
    @Temporal(TemporalType.TIMESTAMP)
    private Date user_birthdate;
    private boolean user_is_active;

    public User(int user_id, String user_name, String user_surname, String user_email, Date user_birthdate, boolean user_is_active) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_surname = user_surname;
        this.user_email = user_email;
        this.user_birthdate = user_birthdate;
        this.user_is_active = user_is_active;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_surname() {
        return user_surname;
    }

    public void setUser_surname(String user_surname) {
        this.user_surname = user_surname;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Date getUser_birthdate() {
        return user_birthdate;
    }

    public void setUser_birthdate(Date user_birthdate) {
        this.user_birthdate = user_birthdate;
    }

    public boolean isUser_is_active() {
        return user_is_active;
    }

    public void setUser_is_active(boolean user_is_active) {
        this.user_is_active = user_is_active;
    }
}
