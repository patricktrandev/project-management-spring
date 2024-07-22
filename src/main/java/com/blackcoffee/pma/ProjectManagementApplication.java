package com.blackcoffee.pma;

import com.blackcoffee.pma.dao.EmployeeRepository;
import com.blackcoffee.pma.dao.ProjectRepository;
import com.blackcoffee.pma.entities.Employee;
import com.blackcoffee.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectManagementApplication {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	ProjectRepository projectRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

	/*@Bean
	CommandLineRunner runner() {
		return args -> {
			Employee emp1 = new Employee("John", "Warton", "	bretb1dswtir@wuuvo.com");
			Employee emp2 = new Employee("Mike", "Lanister", "cddzti9tmgw@icznn.com");
			Employee emp3 = new Employee("Steve", "Reeves", "cghssd7@icznn.com");
			Employee emp4 = new Employee("Ronald", "Salvator", "cddz34mgw@icznn.com");
			Employee emp5 = new Employee("Jim", "Henry", "tyukjkoi@icznn.com");
			Employee emp6 = new Employee("Peter", "Carson", "dsaaadun3@icznn.com");
			Employee emp7 = new Employee("Richard", "Mike", "djkasndsa789@icznn.com");
			Employee emp8 = new Employee("Honor", "Roger", "sajdndwa908@icznn.com");
			Employee emp9 = new Employee("Tony", "Jonas", "asdsdamnl12@icznn.com");


			Project pro1 = new Project("Large Production Deploy", "NOTSTARTED", "This requires all hands on deck for"
					+ "the final deployment of the software into production");
			Project pro2 = new Project("New Employee Budget", "COMPLETED", "Decide on a new employee bonus budget"
					+ "for the year and figureout who will be promoted");
			Project pro3 = new Project("Office Reconstruction", "INPROGRESS", "The office building in Monroe has "
					+ "been damaged due to hurricane in the region. This needs to be reconstructed");
			Project pro4 = new Project("Improve Intranet Security", "INPROGRESS", "With the recent data hack, the office"
					+ "security needs to be improved and proper security team needs to be hired for "
					+ "implementation");


			// need to set both sides of the relationship manually

			pro1.addEmployee(emp1);
			pro1.addEmployee(emp2);
			pro2.addEmployee(emp3);
			pro3.addEmployee(emp1);
			pro4.addEmployee(emp1);
			pro4.addEmployee(emp3);


			// need to set both sides of the relationship manually

			emp1.setProjects(pro1);
			emp1.setProjects(pro2);
			emp1.setProjects(pro3);
			emp2.setProjects(pro1);
			emp2.setProjects(pro4);
			emp3.setProjects(pro2);
			emp3.setProjects(pro1);
			emp3.setProjects(pro4);


			// save employees in database

			employeeRepository.save(emp1);
			employeeRepository.save(emp2);
			employeeRepository.save(emp3);
			employeeRepository.save(emp4);
			employeeRepository.save(emp5);
			employeeRepository.save(emp6);
			employeeRepository.save(emp7);
			employeeRepository.save(emp8);
			employeeRepository.save(emp9);


			// save projects in database

			projectRepository.save(pro1);
			projectRepository.save(pro2);
			projectRepository.save(pro3);
			projectRepository.save(pro4);

		};
}*/
}
