package com.anantraj.cruddemo.dao;

import com.anantraj.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    Employee saveEmployee(Employee employee);

    void deleteEmployee(int id);
}
