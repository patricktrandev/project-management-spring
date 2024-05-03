package com.blackcoffee.pma.controllers;

import com.blackcoffee.pma.dao.EmployeeRepository;
import com.blackcoffee.pma.dao.ProjectRepository;
import com.blackcoffee.pma.dto.ChartData;
import com.blackcoffee.pma.dto.EmployeeProject;
import com.blackcoffee.pma.entities.Employee;
import com.blackcoffee.pma.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Value("${version}")
    String ver;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        model.addAttribute("verNum", ver);

        List<Project> projectList= projectRepository.findAll();

        List<EmployeeProject> employeeList= employeeRepository.assignEmployeeProject();

        List<ChartData> projectStatusData= projectRepository.projectStatus();

        ObjectMapper objectMapper= new ObjectMapper();
        String projectStatusArr =objectMapper.writeValueAsString(projectStatusData);

        model.addAttribute("projects", projectList);
        model.addAttribute("employees", employeeList);
        model.addAttribute("projectStatusCount", projectStatusArr);
        return "main/home";
    }
}
