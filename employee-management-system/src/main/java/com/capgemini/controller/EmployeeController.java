package com.capgemini.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.entity.Employee;
import com.capgemini.model.service.EmployeeService;


@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/saveEmployee")
	public void postEmployee(@RequestBody Employee employee)
	{
			employeeService.saveEmployee(employee);
			System.out.println("Employee saved successfully");
		
	}
	@PostMapping("/saveEmployeeAll")
	public void postEmployeeAll(@RequestBody List<Employee> employees)
	{
			employeeService.saveEmployeeAll(employees);
			System.out.println("Employees saved successfully");
		
	}
	@PostMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable Integer id)
	{
			return employeeService.getEmployee(id);
	}
}
