package com.blackcoffee.pma.dao;

import com.blackcoffee.pma.dto.ChartData;
import com.blackcoffee.pma.dto.EmployeeByProject;
import com.blackcoffee.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    List<Project> findAll();

    @Query(nativeQuery = true, value = "select stage as label, count(*) as projectStatus \n" +
            "from project \n" +
            "group by stage;")
    List<ChartData> projectStatus();

    @Override
    Optional<Project> findById(Long projectId);

    @Query(nativeQuery = true, value="select p.name as projectName, p.stage, e.first_name as firstName, e.last_name as lastName, e.email, p.description \n" +
            "from project_employee as pe \n" +
            "join employee as e on pe.employee_id = e.employee_id \n" +
            "join project as p on p.project_id= pe.project_id \n" +
            "where pe.project_id= :projectId")
    List<EmployeeByProject> findAllEmployeeByProject(@Param("projectId") Long projectId);

}
