package com.learning.demo.contoller;
import com.learning.demo.model.Employee;
import com.learning.demo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author Igor Adulyan
 */


/**
 * EmployeeController implements
 * basic business logic by adding
 * and reading from database
 * employee data
 */
@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * createEmployee method create
     * empty Employee class object named
     * 'employee' and pass to template
     * later it will use form to get data
     * from user input and add it to object
     *
     * @param model
     * @return
     */
    @GetMapping("/add-employee")
    public String createEmployee(Model model)
    {
        model.addAttribute("employee", new Employee());

        return "form-example";
    }

    /**
     * Using ModelAtribute
     * @param employee
     * @return
     */
    @PostMapping("/process-employee")
    public String processEmployee(@ModelAttribute ("employee")Employee employee)
    {
        System.out.println(employee.getFirstName());
        employeeService.addEmployee(employee);

        return "result";
    }

    @GetMapping("/all-employees")
    public String getAllEmployees(Model model)
    {
        List<Employee> employeeList = employeeService.getAllEmployees();
        model.addAttribute("employees", employeeList);

        return "employees";
    }
}
