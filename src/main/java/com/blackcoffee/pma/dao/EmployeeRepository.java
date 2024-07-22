package com.blackcoffee.pma.dao;

import com.blackcoffee.pma.dto.EmployeeDto;
import com.blackcoffee.pma.dto.EmployeeProject;
import com.blackcoffee.pma.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    List<Employee> findAll();

    Employee save(Employee employee);
    Employee findByEmployeeId(Long id);

    @Query(nativeQuery = true, value = "SELECT first_name as firstName, last_name as lastName, COUNT(pe.EMPLOYEE_ID) as numberProject \n" +
            "FROM EMPLOYEE AS e LEFT JOIN PROJECT_EMPLOYEE AS pe \n" +
            "ON e.employee_id = pe.employee_id \n" +
            "GROUP BY first_name, last_name order by numberProject desc")
    List<EmployeeProject> assignEmployeeProject();




}
