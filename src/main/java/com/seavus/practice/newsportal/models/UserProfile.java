package com.seavus.practice.newsportal.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by MK on 09.06.2016.
 */
@Data
@Entity
public class UserProfile {

    @Id
    private String id;
    private String name;
    private String surname;
    private String profileImageURL;

    @MapsId
    @OneToOne
    @JoinColumn(name="id")
    private User user;

    private UserProfile() {}

    public UserProfile(String name, String surname, String profileImageURL, User user) {
        this.name = name;
        this.surname = surname;
        this.profileImageURL = profileImageURL;
        this.user = user;
    }
}
