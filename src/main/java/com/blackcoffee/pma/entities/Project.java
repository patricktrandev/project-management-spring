package com.blackcoffee.pma.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_gen")
    @SequenceGenerator(name = "project_gen", sequenceName = "project_seq",allocationSize = 1,initialValue=1)
    private Long projectId;
    @Column(name = "name")
    private String name;
    @Column(name = "stage")
    private String stage;
    @Column(name = "description")
    private String description;

    @ManyToMany(cascade ={ CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employees;

    public Project(String name, String stage, String description) {
        this.name = name;
        this.stage = stage;
        this.description = description;
    }

    public Project(Long projectId, String name, String stage, String description) {
        this.projectId = projectId;
        this.name = name;
        this.stage = stage;
        this.description = description;
    }

    public Project(){}

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", stage='" + stage + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void addEmployee(Employee emp) {
        if(this.employees==null) {
            this.employees= new ArrayList<>();
        }
        employees.add(emp);
    }
}
