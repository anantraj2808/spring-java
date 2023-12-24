package com.anantraj.cruddemo.dao;

import com.anantraj.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//For changing endpoint
//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //Jpa gives pre defined generic functions
}
