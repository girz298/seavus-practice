package com.seavus.practice.newsportal.repositories;

import com.seavus.practice.newsportal.models.Article;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by MK on 10.06.2016.
 */
public interface ArticleRepository extends CrudRepository<Article, String> {

}
