package com.capgemini.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.capgemini.model.entity.Employee;
import com.capgemini.model.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// CREATE SINGLE EMPLOYEE
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	// CREATE MULTIPLE EMPLOYEES
	@PostMapping("/bulk")
	public List<Employee> createEmployees(@RequestBody List<Employee> employees) {
		return employeeService.saveEmployeeAll(employees);
	}

	// GET ALL EMPLOYEES
	@GetMapping
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	// GET EMPLOYEE BY ID
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		return employeeService.getEmployee(id);
	}

	// UPDATE EMPLOYEE
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}

	// DELETE EMPLOYEE
	@DeleteMapping("deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
		return "Employee deleted successfully";
	}
	
	@PatchMapping("/patchEmployee/{id}")
	public Employee patchEmployee(@PathVariable Integer id,@RequestBody Map<String, Object> updates) {
	    return employeeService.patchEmployee(id, updates);
	}
}