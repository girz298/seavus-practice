package com.seavus.practice.newsportal.repositories;

import com.seavus.practice.newsportal.models.Likes;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by MK on 19.06.2016.
 */
public interface LikeRepository extends CrudRepository<Likes, String> {

}
