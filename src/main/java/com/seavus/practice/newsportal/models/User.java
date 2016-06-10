package com.seavus.practice.newsportal.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by MK on 09.06.2016.
 */
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String name;
    private String surname;
    private String profileImageURL;

    private User() {}

    public User(String name, String surname, String profileImageURL) {
        this.name = name;
        this.surname = surname;
        this.profileImageURL = profileImageURL;
    }
}
