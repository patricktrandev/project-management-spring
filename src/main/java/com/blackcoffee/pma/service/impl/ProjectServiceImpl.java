package com.blackcoffee.pma.service.impl;

import com.blackcoffee.pma.dao.ProjectRepository;
import com.blackcoffee.pma.dto.ChartData;
import com.blackcoffee.pma.dto.EmployeeByProject;
import com.blackcoffee.pma.entities.Project;
import com.blackcoffee.pma.exception.ResourceNotFoundException;
import com.blackcoffee.pma.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Project createNewProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project findProjectById(Long id) {
        Project project= projectRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Project","id", id));
        return project;
    }

    @Override
    public List<EmployeeByProject> findEmployeesByProjectId(Long id) {
        return projectRepository.findAllEmployeeByProject(id);
    }

    @Override
    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public List<ChartData> findProjectStatus() {
        return projectRepository.projectStatus();
    }
}
