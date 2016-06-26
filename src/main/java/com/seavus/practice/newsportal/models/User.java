package com.seavus.practice.newsportal.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

/**
 * Created by MK on 10.06.2016.
 */
@Data
@ToString(exclude = "password")
@Entity
public class User {

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Id
    private String login;
    @JsonIgnore
    private String password;

    private String[] roles;

    @MapsId
    @OneToOne
    @JoinColumn(name="login")
    private UserProfile userProfile;

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public User(String login, String password, String[] roles, UserProfile userProfile) {
        this.login = login;
        this.userProfile = userProfile;
        this.setPassword(password);
        this.roles = roles;
    }

    public User() {
    }
}
