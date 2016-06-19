package com.seavus.practice.newsportal.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by MK on 19.06.2016.
 */
@Data
@Entity
public class PhotoOfTheDay {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String photoURL;

    PhotoOfTheDay(){};

    PhotoOfTheDay(String photoURL) {
        this.photoURL = photoURL;
    }
}
