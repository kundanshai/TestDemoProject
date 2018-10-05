package com.simple.TestDemoProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.TestDemoProject.model.EmployeeInfo;

public interface EmployeeRepository extends JpaRepository<EmployeeInfo, String> {

}
