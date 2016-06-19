package com.seavus.practice.newsportal.models.localization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by MK on 19.06.2016.
 */
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Locale {
    @Id
    private String culture;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Control titles;

    public Locale(){};

    public Locale(String language){
        this.culture = language;
    }
}
