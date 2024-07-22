package com.blackcoffee.pma.service;

import com.blackcoffee.pma.dto.ChartData;
import com.blackcoffee.pma.dto.EmployeeByProject;
import com.blackcoffee.pma.entities.Project;

import java.util.List;

public interface ProjectService {

    Project createNewProject(Project project);
    Project findProjectById(Long id);

    List<EmployeeByProject> findEmployeesByProjectId(Long id);
    List<Project> findAllProjects();
    List<ChartData> findProjectStatus();


}
