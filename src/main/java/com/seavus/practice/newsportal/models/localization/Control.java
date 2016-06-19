package com.seavus.practice.newsportal.models.localization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by MK on 19.06.2016.
 */
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Control {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String authorization;
    private String registration;
    private String search;
    private String lookFor;
    private String sport;
    private String culture;
    private String society;
    private String politics;
    private String economics;
    private String others;
    private String actualNews;
    private String readFull;
    @MapsId
    @OneToOne
    @JoinColumn(name="localeCulture")
    private Locale localeCulture;

    public Control(String authorization, String registration, String search, String lookFor, String sport, String culture, String society, String politics, String economics, String others, String actualNews, String readFull, Locale localeCulture) {
        this.authorization = authorization;
        this.registration = registration;
        this.search = search;
        this.lookFor = lookFor;
        this.sport = sport;
        this.culture = culture;
        this.society = society;
        this.politics = politics;
        this.economics = economics;
        this.others = others;
        this.actualNews = actualNews;
        this.readFull = readFull;
        this.localeCulture = localeCulture;
    }

    public Control() {
    }
}