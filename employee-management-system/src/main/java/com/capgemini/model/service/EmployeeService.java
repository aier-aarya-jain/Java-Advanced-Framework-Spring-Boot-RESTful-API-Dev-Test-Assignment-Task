package com.capgemini.model.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.entity.Employee;
import com.capgemini.model.repository.EmployeeRepository;
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public void saveEmployee(Employee employee)
	{
		employeeRepository.save(employee);
		System.out.println("Employee saved successfully");
	}
	
	public void saveEmployeeAll(List<Employee> employees)
	{
		employeeRepository.saveAll(employees);
		System.out.println("Employee saved successfully");
	}

	public Employee getEmployee(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).orElse(null);
	}
}
