package com.seavus.practice.newsportal.utility;

import com.seavus.practice.newsportal.models.Article;
import com.seavus.practice.newsportal.models.User;
import com.seavus.practice.newsportal.models.UserProfile;
import com.seavus.practice.newsportal.repositories.ArticleRepository;
import com.seavus.practice.newsportal.repositories.UserProfileRepository;
import com.seavus.practice.newsportal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
    public DatabaseLoader(UserRepository userRepository, UserProfileRepository userProfileRepository, ArticleRepository articleRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        UserProfile userProfile = new UserProfile("testName", "testLogin", "image", null);
        User user = new User("user", "password", null, userProfile);
        userRepository.save(user);
        userProfileRepository.save(userProfile);
        Article article = new Article("header", "test", userProfile);
        articleRepository.save(article);
    }
}