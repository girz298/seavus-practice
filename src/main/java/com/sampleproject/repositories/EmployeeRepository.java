package com.sampleproject.repositories;

import com.sampleproject.models.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by MK on 09.06.2016.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}