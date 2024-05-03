package com.blackcoffee.pma.controllers;

import com.blackcoffee.pma.dao.EmployeeRepository;
import com.blackcoffee.pma.dao.ProjectRepository;
import com.blackcoffee.pma.dto.EmployeeByProject;
import com.blackcoffee.pma.entities.Employee;
import com.blackcoffee.pma.entities.Project;
import com.blackcoffee.pma.utils.ProjectStages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
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
    public String createProject(Model model, Project project){
        //save to db
        projectRepository.save(project);

        return "redirect:/projects";
    }

    @GetMapping("/search")
    public String findProjectBYId(@RequestParam(name="id") Long id, Model model){

        List<EmployeeByProject> employeeByProjects= projectRepository.findAllEmployeeByProject(id);
        String projectName= employeeByProjects.get(0).getProjectName();
        String stageProject= employeeByProjects.get(0).getStage();
        ProjectStages stages= new ProjectStages();
        for (String i : stages.getStages().keySet()) {
            //System.out.println("key: " + i + " value: " +  stages.getStages().get(i));
            if(stageProject.equals( i)){
                stageProject= stages.getStages().get(i);
                break;
            }
        }
        model.addAttribute("employeeByProjects",employeeByProjects);
        model.addAttribute("projectName",projectName);
        model.addAttribute("projectStage",stageProject);
        return "projects/single-project";
    }

}
