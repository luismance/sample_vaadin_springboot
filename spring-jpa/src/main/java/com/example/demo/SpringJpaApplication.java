package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Employee;
import com.example.demo.domain.EmployeeRepository;

@SpringBootApplication
public class SpringJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	// CommandLineRunner executes the code after the server starts
	// @Bean -> Indicates that a method produces a bean to be managed by the Spring
	// container.
	@Bean
	public CommandLineRunner loadData(EmployeeRepository repo) {

		return args -> {
			repo.save(new Employee("fname", "lname"));
			repo.save(new Employee("fname1", "lname1"));

			log.info("Employee found : ");
			log.info("-----------------");
			for (Employee emp : repo.findAll()) {
				log.info(emp.toString());
			}
		};
	}
}
