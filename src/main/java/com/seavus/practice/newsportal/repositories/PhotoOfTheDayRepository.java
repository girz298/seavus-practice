package com.seavus.practice.newsportal.repositories;

import com.seavus.practice.newsportal.models.PhotoOfTheDay;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by MK on 19.06.2016.
 */
public interface PhotoOfTheDayRepository extends CrudRepository<PhotoOfTheDay, String> {

}