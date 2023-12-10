package com.adithyan.Employee.services;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.adithyan.Employee.model.Employee;
import com.adithyan.Employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private final EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository)
	{
	this.employeeRepository = employeeRepository;
	}

   @Override
	public Employee createEmployee(Employee employee)
	{
	return employeeRepository.save(employee);
		
	}

   @Override
   public List<Employee> getAllEmployees() {
	List<Employee> employees = employeeRepository.findAll()
			.stream()
			.map(emp -> new Employee(
					emp.getId(),
					emp.getFirstName(),
					emp.getLastName(),
					emp.getEmailId())
					)
			.collect(Collectors.toList());

	 return employees;
   }

@Override
public boolean deleteEmployee(long id) {

	Employee employee= employeeRepository.findById(id).get() ;
	employeeRepository.delete(employee);
	
	return true;
}



@Override
public Employee getEmployeeId(Long id) {
Employee employee = employeeRepository.findById(id).get();
BeanUtils.copyProperties(employee, employee);


return employee;
}

@Override
public Employee updateEmployee(Long id, Employee employee) {

	Employee existingEmployee = employeeRepository.findById(id).get();
	 if (existingEmployee != null) {
		 existingEmployee.setEmailId(employee.getEmailId());
		 existingEmployee.setFirstName(employee.getFirstName());
		 existingEmployee.setLastName(employee.getLastName());
	 
	
	employeeRepository.save(employee);
	
	 }
	return employee;
}


}