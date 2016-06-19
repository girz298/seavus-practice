package com.seavus.practice.newsportal.repositories;

import com.seavus.practice.newsportal.models.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by MK on 10.06.2016.
 */
@PreAuthorize("hasRole('GENERAL_USER')")
public interface ArticleRepository extends CrudRepository<Article, String> {

    @Override
    @PreAuthorize("#article?.author?.user?.login == authentication?.login")
    Article save(@Param("article") Article article);

    @Override
    @PreAuthorize("@articleRepository.findOne(#id)?.author?.user?.login == authentication?.name")
    void delete(@Param("id") String id);

    @Override
    @PreAuthorize("#article?.author?.user?.login == authentication?.login")
    void delete(@Param("article") Article article);

}
