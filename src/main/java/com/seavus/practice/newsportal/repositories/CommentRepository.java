package com.seavus.practice.newsportal.repositories;

import com.seavus.practice.newsportal.models.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by MK on 10.06.2016.
 */
public interface CommentRepository extends CrudRepository<Comment, String> {

}
