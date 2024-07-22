package com.blackcoffee.pma.service;

import com.blackcoffee.pma.dto.EmployeeDto;
import com.blackcoffee.pma.dto.EmployeeProject;
import com.blackcoffee.pma.entities.Employee;

import java.util.List;


public interface EmployeeService {

    EmployeeDto createNewEmployee(EmployeeDto employeeDto);
    List<Employee> findAllEmployees();
    List<EmployeeProject> assignEmployeeToProject();

    Employee findEmployeeById(Long id);
    void deleteEmployee(Employee employee);
}
