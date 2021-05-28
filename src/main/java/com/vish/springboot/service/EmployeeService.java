package com.vish.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vish.springboot.data.EmployeeRepository;
import com.vish.springboot.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public String createEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "Employee Created Successfully";
	}

	public Employee getEmployee(int id) {
		return employeeRepository.findById(id).get();
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee deleteEmployee(int id) {
		Employee employee = getEmployee(id);
		if (employee == null) {
			System.out.println("Employee not found with employee ID: " + id);
			return null;
		} else {
			employeeRepository.delete(employee);
		}
		return employee;
	}

	@Transactional
	public Employee updateEmployee(int id, Employee employeeDetails) throws Exception {
		Employee employee = employeeRepository.findById(id).get();
		if (employeeDetails.getAddress() != null)
			employee.setAddress(employee.getAddress());

		if (employeeDetails.getFirstName() != null)
			employee.setFirstName(employeeDetails.getFirstName());

		if (employeeDetails.getLastName() != null)
			employee.setLastName(employeeDetails.getLastName());

		if (employeeDetails.getJoiningDate() != null)
			employee.setJoiningDate(employeeDetails.getJoiningDate());

		if (employeeDetails.getPanNumber() != null)
			employee.setPanNumber(employeeDetails.getPanNumber());

		return employeeRepository.save(employee);
	}
}
