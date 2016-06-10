package com.seavus.practice.newsportal.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MK on 10.06.2016.
 */
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Article {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String header;
    private String text;

    @ManyToOne(fetch=FetchType.LAZY, cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            })
    @JoinColumn(name = "user_id")
    private UserProfile author;

    @OneToMany(mappedBy = "relatedToArticle", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> commentaries = new ArrayList<>();

    public Article(String header, String text, UserProfile author) {
        this.header = header;
        this.text = text;
        this.author = author;
    }

    public Article() {
    }
}
