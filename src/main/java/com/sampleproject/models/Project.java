package com.sampleproject.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by MK on 09.06.2016.
 */
@Data
@Entity
public class Project {
    private @Id
    @GeneratedValue
    Long id;
    private String name;

    public Project() {}

    public Project(String name) {
        this.name = name;
    }
}
