package com.learning.demo.service;

import com.learning.demo.SpringDemoLearningApplication;
import com.learning.demo.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringDemoLearningApplication.class)
public class EmployeeServiceTest {

    @Autowired
    EmployeeService employeeService;

    /**
     * @implNote
     * JUnit runs test in
     * alphabetical order.
     * If you want to run them in
     * specific order you need to
     * use @Order annotation
     */

    /**
     * Test of imployee retrieved from
     * database
     *
     */
    @Test
    public void save_employee_test()
    {
        Employee employee = new Employee("Jo", "Doe", "jo@mail.com");
        employeeService.addEmployee(employee);

        Assertions.assertTrue(employeeService.getAllEmployees().size() > 0);

    }

    /**
     * Test if expected
     * data saved to database
     * equal actual data
     */
    @Test
    public void get_employee_test()
    {
        Employee expectedEmployee = new Employee("Jane", "Smith", "jany@mail.com");
        employeeService.addEmployee(expectedEmployee);

        Employee actualEmployee = employeeService.findEmployeeByEmail("jany@mail.com");

        Assertions.assertEquals(expectedEmployee, actualEmployee);

    }

}
