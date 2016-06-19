package com.seavus.practice.newsportal.utility;

import com.seavus.practice.newsportal.models.*;
import com.seavus.practice.newsportal.repositories.*;
import com.seavus.practice.newsportal.repositories.localization.LocaleRepository;
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
    private final AuthorRepository authorRepository;
    @Autowired
    private final AuthorProfileRepository authorProfileRepository;
    @Autowired
    private final ArticleRepository articleRepository;
    @Autowired
    private final CommentRepository commentRepository;
    @Autowired
    private final TagRepository tagRepository;
    @Autowired
    private final LocaleRepository localeRepository;

    @Autowired
    public DatabaseLoader(AuthorRepository authorRepository,
                          AuthorProfileRepository authorProfileRepository,
                          ArticleRepository articleRepository,
                          CommentRepository commentRepository,
                          TagRepository tagRepository,
                          LocaleRepository localeRepository) {
        this.authorRepository = authorRepository;
        this.authorProfileRepository = authorProfileRepository;
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
        this.tagRepository = tagRepository;
        this.localeRepository = localeRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        AuthorProfile authorProfile = new AuthorProfile("testName", "testLogin", "image", null);
        Author author = new Author("author", "password", "GENERAL_USER");
        authorProfile.setAuthor(author);
        authorRepository.save(author);
        authorProfileRepository.save(authorProfile);
        Article article = new Article("EU referendum: Osborne warns of Brexit budget cuts", "George "+
                " Osborne says he will have to slash public spending and increase "+
                " taxes in an emergency Budget to tackle a £30bn \"black hole\" if the UK votes to leave the "+
                " European Union.", authorProfile, LocalDateTime.now());
        Article article1 = new Article("Alligator drags boy into water near Orlando Disney resort", "The boy was on the shoreline of the Seven Seas Lagoon by the Disney Grand Floridian Resort and Spa in Orlando when he was dragged away late on Tuesday, officials said.", authorProfile, LocalDateTime.now());
        Article article2 = new Article("US charges Chinese ex-IBM worker with espionage", "The Department of Justice did not name the employer, but it is widely reported to be software developer IBM.\n" +
                "Mr Xu intended to sell the code for his own profit and for the benefit of the Chinese government, authorities said.", authorProfile, LocalDateTime.now());
        List<Comment> articleComments = new ArrayList<>();
        articleComments.add(new Comment("amazing text1", LocalDateTime.now(), authorProfile, article));
        articleComments.add(new Comment("amazing text2", LocalDateTime.now(), authorProfile, article));
        article.setCommentaries(articleComments);
        List<Article> articles = new ArrayList<>();
        articles.add(article);
        articles.add(article1);
        articles.add(article2);
        List<Like> articleLikes = new ArrayList<>();
        Like like1 = new Like(1);
        like1.setLeftByAuthor(authorProfile);
        like1.setLeftOnArticle(article);
        articleLikes.add(like1);
        Like like2 = new Like(-1);
        like2.setLeftByAuthor(authorProfile);
        like2.setLeftOnArticle(article);
        articleLikes.add(like2);
        article.setLikes(articleLikes);
        List<Tag> articleTags = new ArrayList<>();
        Tag wow = new Tag("wow");
        wow.setBelongsToArticles(articles);
        articleTags.add(wow);
        Tag doge = new Tag("doge");
        doge.setBelongsToArticles(articles);
        articleTags.add(doge);
        article.setArticleTags(articleTags);
        articleRepository.save(articles);
    }
}