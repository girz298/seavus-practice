package com.seavus.practice.newsportal.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MK on 10.06.2016.
 */
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tag {

    @Id
    private String text;

    @ManyToMany(mappedBy = "articleTags", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Article> belongsToArticles = new ArrayList<>();

    public Tag(String text){
        this.text = text;
    }

    public Tag() {
    }

}
