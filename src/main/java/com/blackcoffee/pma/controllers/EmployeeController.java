package com.blackcoffee.pma.controllers;

import com.blackcoffee.pma.dao.EmployeeRepository;
import com.blackcoffee.pma.entities.Employee;
import com.blackcoffee.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public String displayProjects(Model model){
        List<Employee> employeeList= employeeRepository.findAll();
        model.addAttribute("employees", employeeList);
        return "employees/list-employee";
    }
    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee employee= new Employee();
        model.addAttribute("employee", employee);
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(Model model, Employee employee){
        employeeRepository.save(employee);
        return "redirect:/employees/new";
    }
}
