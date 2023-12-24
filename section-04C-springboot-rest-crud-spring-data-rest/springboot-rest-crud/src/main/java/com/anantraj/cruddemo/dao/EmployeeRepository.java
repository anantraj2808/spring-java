package com.anantraj.cruddemo.dao;

import com.anantraj.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //Jpa gives pre defined generic functions
}
