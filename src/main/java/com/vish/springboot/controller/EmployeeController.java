package com.vish.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vish.springboot.model.Employee;
import com.vish.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired private EmployeeService employeeService;
	
	@GetMapping
	public String employeeHome() {
		return "Welcome to Employee API";
	}
	
	@PostMapping(path = "/createEmployee", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public String createEmployee(@RequestBody Employee employee) {
		System.out.println(employee.getFirstName());
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping(path = "/getEmployee/{id}", produces = "application/json")
	public Employee getEmployee(@PathVariable int id) {
		return employeeService.getEmployee(id);
	}
	
	@GetMapping(path = "/getAllEmployees", produces = "application/json")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@DeleteMapping(path = "/deleteEmployee/{id}", produces = "application/json")
	public Employee deleteEmployee(@PathVariable("id") int id) {
		return employeeService.deleteEmployee(id);
	}
	
	@PutMapping(path = "/updateEmployee/{id}", consumes = "application/json", produces = "application/json")
	public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employeeDetails) throws Exception {
		return employeeService.updateEmployee(id, employeeDetails);
	}
}
