package com.adithyan.Employee.services;

import java.util.List;

import com.adithyan.Employee.model.Employee; 

public interface EmployeeService {  

	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployees();

	boolean deleteEmployee(long id);

	Employee getEmployeeId(Long id);


	Employee updateEmployee(Long id, Employee employee);

//	List<Employee> getAllEmployees(Employee employee);

}
