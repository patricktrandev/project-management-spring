package com.blackcoffee.pma.controllers;

import com.blackcoffee.pma.dao.EmployeeRepository;
import com.blackcoffee.pma.dao.ProjectRepository;
import com.blackcoffee.pma.entities.Employee;
import com.blackcoffee.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public String displayProjects(Model model){
        List<Project> projectList= projectRepository.findAll();
        model.addAttribute("projects", projectList);
        return "projects/list-project";
    }
    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project aProject= new Project();
        Iterable<Employee> employees= employeeRepository.findAll();
        model.addAttribute("project", aProject);
        model.addAttribute("employees", employees);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Model model, Project project, @RequestParam List<Long> employees){
        //save to db
        projectRepository.save(project);
        Iterable<Employee> chosenEmployees=employeeRepository.findAllById(employees);
        for(Employee emp: chosenEmployees){
            emp.setProject(project);
            employeeRepository.save(emp);
        }
        return "redirect:/projects/new";
    }
}
