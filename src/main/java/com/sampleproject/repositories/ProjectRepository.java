package com.sampleproject.repositories;

import com.sampleproject.models.Project;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by MK on 09.06.2016.
 */
public interface ProjectRepository extends CrudRepository<Project, Long> {
}