package com.learning.demo.contoller.withvalidation;

import com.learning.demo.model.validation.lombok.Employee;
import com.learning.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Igor Adulyan
 */


/**
 * EmployeeController implements
 * basic business logic by adding
 * and reading employee data
 * from database
 *
 */
@Controller
@RequestMapping("/validation")
public class EmployeeControllerValidation {

    private EmployeeService employeeService;

    public EmployeeControllerValidation(EmployeeService employeeService) {
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

        return "form-validation-example";
    }


    /**
     * Using ModelAtribute
     * and @valid annotation to
     * get determine violation
     * of constraints
     * @param employee
     * @return
     */

    /*
    This is very simple example for learning purposes
    Usually this type of validation used to ensure
     */
    @PostMapping("/process-employee")
    public String processEmployee(@Valid @ModelAttribute ("employee")Employee employee,
                                  BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "form-validation-example";
        }

        return "result";
    }

}
