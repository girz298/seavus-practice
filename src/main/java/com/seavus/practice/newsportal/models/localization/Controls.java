package com.seavus.practice.newsportal.models.localization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by MK on 19.06.2016.
 */
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Controls {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @MapsId
    @OneToOne
    @JoinColumn(name="locale")
    private Locale locale;

    @ElementCollection
    private Map<String, String> titles;

    Controls(){}

    Controls(Map titles){
        this.titles = titles;
    }

}
