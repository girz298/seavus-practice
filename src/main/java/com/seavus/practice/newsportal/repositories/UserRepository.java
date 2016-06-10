package com.seavus.practice.newsportal.repositories;

import com.seavus.practice.newsportal.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by MK on 09.06.2016.
 */
public interface UserRepository extends CrudRepository<User, String> {

}