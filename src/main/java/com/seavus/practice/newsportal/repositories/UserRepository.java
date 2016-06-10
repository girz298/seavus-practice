package com.seavus.practice.newsportal.repositories;

import com.seavus.practice.newsportal.models.User;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by MK on 10.06.2016.
 */
@RepositoryRestResource(exported = false)
public interface UserRepository extends Repository<User, String> {

    User save(User user);

    User findByLogin(String login);

}