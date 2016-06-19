package com.seavus.practice.newsportal.models;

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
public class Likes {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private int mark;

    @ManyToOne(fetch= FetchType.LAZY, cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            })
    @JoinColumn(name = "article_id")
    private Article leftOnArticle;

    @ManyToOne(fetch= FetchType.LAZY, cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            })
    @JoinColumn(name = "user_id")
    private UserProfile leftByUser;

    Likes(){};

    Likes(int mark){
        this.mark = mark;
    }
}
