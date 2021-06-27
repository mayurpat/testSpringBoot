package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.dao.Repository.EmployeeRepository;
import com.example.demo.dao.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository ;
	

    public long getEmployeesCount() {
        return employeeRepository.count();
    }
	
	public Iterable<Employee> getAllEmployee(){		
		return employeeRepository.findAll();
	}
	
	public Optional<Employee> getEmployeeById(Long id) {
		return employeeRepository.findById(id);
	}
	
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Employee employeeDetails) throws ResourceNotFoundException {		
		Employee employee = employeeRepository.findById(employeeDetails.getId()).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeDetails.getId()));
		
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return updatedEmployee;

	}
	
	public void removeEmployee(Long id) throws ResourceNotFoundException{
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		employeeRepository.delete(employee);
		
	}
	
}
