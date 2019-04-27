package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "acnemployee", path = "acnemployee")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
