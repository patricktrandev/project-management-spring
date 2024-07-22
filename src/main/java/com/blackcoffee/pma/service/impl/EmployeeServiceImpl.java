package com.blackcoffee.pma.service.impl;

import com.blackcoffee.pma.dao.EmployeeRepository;
import com.blackcoffee.pma.dto.EmployeeDto;
import com.blackcoffee.pma.dto.EmployeeProject;
import com.blackcoffee.pma.entities.Employee;
import com.blackcoffee.pma.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
        Employee newEmployee= mapToEntity(employeeDto);
       Employee employee= employeeRepository.save(newEmployee);
        return mapToDto(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<EmployeeProject> assignEmployeeToProject() {
        return employeeRepository.assignEmployeeProject();
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findByEmployeeId(id);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    private EmployeeDto mapToDto(Employee employee){
        EmployeeDto employeeDto= new EmployeeDto();
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        return employeeDto;
    }
    private Employee mapToEntity(EmployeeDto employeeDto){
        Employee employee= new Employee();
        employee.setEmployeeId(employeeDto.getEmployeeId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        return employee;
    }
}
