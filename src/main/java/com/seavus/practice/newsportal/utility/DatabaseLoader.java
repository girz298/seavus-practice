package com.seavus.practice.newsportal.utility;

import com.seavus.practice.newsportal.models.*;
import com.seavus.practice.newsportal.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MK on 09.06.2016.
 */
@Component
public class DatabaseLoader implements CommandLineRunner {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserProfileRepository userProfileRepository;
    @Autowired
    private final ArticleRepository articleRepository;
    @Autowired
    private final CommentRepository commentRepository;
    @Autowired
    private final TagRepository tagRepository;

    @Autowired
    public DatabaseLoader(UserRepository userRepository,
                          UserProfileRepository userProfileRepository,
                          ArticleRepository articleRepository,
                          CommentRepository commentRepository,
                          TagRepository tagRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        UserProfile userProfile = new UserProfile("testName", "testLogin", "image", null);
        User user = new User("user", "password", null, userProfile);
        userRepository.save(user);
        userProfileRepository.save(userProfile);
        Article article = new Article("EU referendum: Osborne warns of Brexit budget cuts", "George "+
                " Osborne says he will have to slash public spending and increase "+
                " taxes in an emergency Budget to tackle a £30bn \"black hole\" if the UK votes to leave the "+
                " European Union.", userProfile, LocalDateTime.now());
        List<Comment> articleComments = new ArrayList<>();
        articleComments.add(new Comment("amazing text1", LocalDateTime.now(), userProfile, article));
        articleComments.add(new Comment("amazing text2", LocalDateTime.now(), userProfile, article));
        article.setCommentaries(articleComments);
        List<Article> articles = new ArrayList<>();
        articles.add(article);
        List<Tag> articleTags = new ArrayList<>();
        Tag wow = new Tag("wow");
        wow.setBelongsToArticles(articles);
        articleTags.add(wow);
        Tag doge = new Tag("doge");
        doge.setBelongsToArticles(articles);
        articleTags.add(doge);
        article.setArticleTags(articleTags);
        articleRepository.save(article);
    }
}