package com.blackcoffee.pma.controllers;

import com.blackcoffee.pma.dao.EmployeeRepository;
import com.blackcoffee.pma.dao.ProjectRepository;
import com.blackcoffee.pma.entities.Employee;
import com.blackcoffee.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/")
    public String displayHome(Model model){

        List<Project> projectList= projectRepository.findAll();

        List<Employee> employeeList= employeeRepository.findAll();

        model.addAttribute("projects", projectList);
        model.addAttribute("employees", employeeList);
        return "main/home";
    }
}
