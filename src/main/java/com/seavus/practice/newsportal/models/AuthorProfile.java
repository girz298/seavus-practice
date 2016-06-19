package com.seavus.practice.newsportal.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MK on 09.06.2016.
 */
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AuthorProfile {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String name;
    private String surname;
    private String profileImageURL;

    @OneToOne
    private Author author;

    @OneToMany(mappedBy = "author", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Article> articles = new ArrayList<>();

    @OneToMany(mappedBy = "commentator", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> leftComments = new ArrayList<>();

    @OneToMany(mappedBy = "leftByAuthor", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();

    public AuthorProfile(String name, String surname, String profileImageURL, Author author) {
        this.name = name;
        this.surname = surname;
        this.profileImageURL = profileImageURL;
        this.author = author;
    }

    public AuthorProfile() {
    }
}
