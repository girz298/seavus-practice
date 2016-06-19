package com.seavus.practice.newsportal.models.localization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by MK on 19.06.2016.
 */
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Locale {
    @Id
    private String Language;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Controls localizedControls;

    public Locale(){};

    public Locale(String Language){
        this.Language = Language;
    }
}
