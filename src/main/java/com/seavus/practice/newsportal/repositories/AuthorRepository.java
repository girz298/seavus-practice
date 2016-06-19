package com.seavus.practice.newsportal.repositories;

import com.seavus.practice.newsportal.models.Author;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by MK on 10.06.2016.
 */
@RepositoryRestResource(exported = false)
public interface AuthorRepository extends Repository<Author, String> {

    Author save(Author author);

    Author findByLogin(String login);

}