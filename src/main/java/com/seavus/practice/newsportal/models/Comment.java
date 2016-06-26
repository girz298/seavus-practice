package com.seavus.practice.newsportal.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;

/**
 * Created by MK on 10.06.2016.
 */
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Comment {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @Lob
    private String text;
    private long leftOn;

    @ManyToOne(fetch=FetchType.LAZY, optional = false, cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            })
    @JoinColumn(name = "user_id")
    private AuthorProfile commentator;

    @ManyToOne(fetch=FetchType.LAZY, optional = false, cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            })
    @JoinColumn(name = "article_id")
    private Article relatedToArticle;

    public Comment(String text, AuthorProfile commentator, Article relatedToArticle) {
        this.text = text;
        this.leftOn = Instant.now().getEpochSecond();
        this.commentator = commentator;
        this.relatedToArticle = relatedToArticle;
    }

    public Comment() {
    }
}
