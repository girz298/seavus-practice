package com.seavus.practice.newsportal.utility;

import com.seavus.practice.newsportal.models.Article;
import com.seavus.practice.newsportal.models.Comment;
import com.seavus.practice.newsportal.models.User;
import com.seavus.practice.newsportal.models.UserProfile;
import com.seavus.practice.newsportal.repositories.ArticleRepository;
import com.seavus.practice.newsportal.repositories.CommentRepository;
import com.seavus.practice.newsportal.repositories.UserProfileRepository;
import com.seavus.practice.newsportal.repositories.UserRepository;
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
    public DatabaseLoader(UserRepository userRepository,
                          UserProfileRepository userProfileRepository,
                          ArticleRepository articleRepository,
                          CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        UserProfile userProfile = new UserProfile("testName", "testLogin", "image", null);
        User user = new User("user", "password", null, userProfile);
        userRepository.save(user);
        userProfileRepository.save(userProfile);
        Article article = new Article("header", "test", userProfile);
        List<Comment> articleComments = new ArrayList<>();
        articleComments.add(new Comment("amazing text1", LocalDateTime.now(), userProfile, article));
        articleComments.add(new Comment("amazing text2", LocalDateTime.now(), userProfile, article));
        article.setCommentaries(articleComments);
        articleRepository.save(article);

    }
}