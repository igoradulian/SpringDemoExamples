package com.learning.demo.service;

import com.learning.demo.model.Employee;
import org.springframework.stereotype.Service;
/**
 * @author Igor Adulyan
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * In order to simulate basic database
 * functionality employeeDB map is created
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    /*email is used as unique identifier of employee.
    In production applications maps can be used as
    a part of user security and management. For
    example, to monitor logged in users for non-session
    based security applications. However, for such situations
    it is recommended to use ConcurrentMaps  which are thread safe.
     */
    private static final Map<String, Employee> employeeDB = new HashMap<>();

    /**
     * saves employee to employeeDB
     * map.
     * @param employee
     */
    @Override
    public void addEmployee(Employee employee) {
        employeeDB.put(employee.getEmail(), employee);
    }

    /**
     * Find employee object by
     * employee email
     * @param email
     * @return
     */
    @Override
    public Employee findEmployeeByEmail(String email) {
        return employeeDB.get(email);
    }

    /**
     * Return all employees as a list
     * @return
     */
    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeDB.values());
    }
}
