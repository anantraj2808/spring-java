package com.anantraj.cruddemo.service;

import com.anantraj.cruddemo.dao.EmployeeRepository;
import com.anantraj.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        } else{
            throw new RuntimeException("Employee with ID = " + id + " not found");
        }
    }

    //@Transactional - No use
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    //@Transactional - No use
    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
