package com.capgemini.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.entity.Employee;
import com.capgemini.model.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	// CREATE SINGLE EMPLOYEE
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	// CREATE MULTIPLE EMPLOYEES
	public List<Employee> saveEmployeeAll(List<Employee> employees) {
		return employeeRepository.saveAll(employees);
	}

	// GET EMPLOYEE BY ID
	public Employee getEmployee(Integer id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
	}

	// GET ALL EMPLOYEES
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	// UPDATE EMPLOYEE
	public Employee updateEmployee(Integer id, Employee newEmployee) {

		Employee existing = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));

		existing.setName(newEmployee.getName());
		existing.setMailId(newEmployee.getMailId());
		existing.setContactNumber(newEmployee.getContactNumber());

		return employeeRepository.save(existing);
	}

	public void deleteEmployee(Integer id) {
		Employee existing = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));

		employeeRepository.delete(existing);
	}

	public Employee patchEmployee(Integer id, Map<String, Object> updates) {

		Employee existing = employeeRepository.findById(id).get();
		for (Map.Entry<String, Object> field : updates.entrySet()) {
			String key = field.getKey();
			Object value = field.getValue();
			if (key.equals("name")) {
				existing.setName((String) value);
			}
			if (key.equals("mailId")) {
				existing.setMailId((String) value);
			}
			if (key.equals("contactNumber")) {
				existing.setContactNumber((Long) value);
			}

		}
		return employeeRepository.save(existing);
	}
}