package com.blackcoffee.pma.controllers;

import com.blackcoffee.pma.dao.EmployeeRepository;
import com.blackcoffee.pma.dto.EmployeeDto;
import com.blackcoffee.pma.entities.Employee;
import com.blackcoffee.pma.entities.Project;
import com.blackcoffee.pma.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String displayProjects(Model model) {
        List<Employee> employeeList = employeeService.findAllEmployees();
        model.addAttribute("employees", employeeList);
        return "employees/list-employee";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(Model model,EmployeeDto employee) {

       employeeService.createNewEmployee(employee);
        return "redirect:/employees";
    }


    @GetMapping("/update")
    public String displayEmployeeUpdateForm(Model model,@RequestParam("id") Long id){
        Employee employee= employeeService.findEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employees/new-employee";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") Long id){
        Employee employee= employeeService.findEmployeeById(id);
        employeeService.deleteEmployee(employee);
        return "redirect:/employees";
    }
}
