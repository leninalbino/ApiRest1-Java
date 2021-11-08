package com.employees.apirest.service;

import java.util.List;

import com.employees.apirest.models.entity.Employee;

public interface IEmployeeService {

	List<Employee>findAllEmployee ();
	 void saveEmployee(Employee employee);
	Employee findById ( Long id);
	void deleteEmployee(Long id);
	Boolean statusEmployee(Long id);
}
