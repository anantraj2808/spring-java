package com.anantraj.cruddemo.service;

import com.anantraj.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    Employee saveEmployee(Employee employee);

    void deleteEmployee(int id);

}
