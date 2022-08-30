package com.learning.demo.contoller;
/**
 * @author Igor Adulyan
 */

import com.learning.demo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Basic controller tells
 * what type of urls available for users
 * in application. This could be
 * compared with email addresses, or
 * phone numbers or other unique identifiers
 *Thus, every controller have routes which
 * give access to specific content in application
 */
@Controller
public class MainController {

    /**Request application maps both GET and POST requests
    indexPage method use Model class which passed as argument
    to method. Model class holds objects which add to model
    using addAttribute method (there are other methods also exist
    for simplicity we will use only addAttribute). Objects added to
    model passed to template and become available in template as
    attributes of html elements. In this example string with
    name 'message' passed as attribute to index.html template
     @param model
     @return string
    */
    @RequestMapping("/") // However, it is not recommended to use RequestMapping
    // in production from security viewpoint
    //always specify request type
    public String indexPage(Model model)
    {
        model.addAttribute("message", "Welcome to my main page");
        return "index";
    }


    /**
     * employeePage create new object
     * using Employee class and add it
     * to Model class with name "employee"
     * @param model
     * @return string
     */
    @GetMapping("/employee")
    public String employeePage(Model model)
    {
        Employee employee = new Employee("John", "Smith", "john@perscholas.org");
        model.addAttribute("employee" , employee);

        return "object-example";
    }

}
