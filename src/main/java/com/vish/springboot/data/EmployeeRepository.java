package com.vish.springboot.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vish.springboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}