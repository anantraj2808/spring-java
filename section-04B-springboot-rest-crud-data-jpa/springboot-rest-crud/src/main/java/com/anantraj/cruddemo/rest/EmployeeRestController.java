package com.anantraj.cruddemo.rest;
import com.anantraj.cruddemo.entity.Employee;
import com.anantraj.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //constructor injection
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployeesList(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        Employee employee = employeeService.getEmployeeById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee with ID = " + employeeId + " not found");
        }

        return employee;
    }

    @PostMapping("employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee dbEmployee = employeeService.saveEmployee(employee);
        return dbEmployee;
    }

    @PutMapping("employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee = employeeService.saveEmployee(employee);
        return dbEmployee;
    }

    @DeleteMapping("employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee dbEmployee = employeeService.getEmployeeById(employeeId);

        if(dbEmployee == null){
            throw new RuntimeException("Employee with ID = " + employeeId + " not found");
        }
        employeeService.deleteEmployee(employeeId);
        return "Employee with ID = " + employeeId + " deleted successfully";
    }
}
