package com.learning.demo.service;
/**
 * @author Igor Adulyan
 */
import com.learning.demo.model.Employee;

import java.util.List;

/**
 * EmployeeService simulates jpa
 * repository operations
 */
public interface EmployeeService {

    public void addEmployee(Employee employee);
    public Employee findEmployeeByEmail(String email);
    public List<Employee> getAllEmployees();
}
