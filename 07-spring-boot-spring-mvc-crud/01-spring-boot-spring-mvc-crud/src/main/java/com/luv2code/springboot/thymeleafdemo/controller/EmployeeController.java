package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //add mapping để list
    @GetMapping("/list")
    public String listEmployee(Model theModel){
        // get the employees from db
        List<Employee> theEmployees = employeeService.findAllByOrderByLastNameAsc();


        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        // tạo model attribute cho binding
        Employee employee = new Employee();

        theModel.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
        // lấy employee được truyền qua từ form
        Employee employee = employeeService.findById(theId);

        //set employee vào model và trả cho form
        theModel.addAttribute("employee", employee);


        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        //save employee
        employeeService.save(theEmployee);
        //redirect để tránh duplicate submissions khi refresh browser
        return "redirect:/employees/list";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){
        // delete the employee
        employeeService.deleteById(theId);
        // redirect to the /employees/list
        return "redirect:/employees/list";
    }
}
