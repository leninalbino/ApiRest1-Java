package com.employees.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employees.apirest.models.entity.Employee;
import com.employees.apirest.service.IEmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
private IEmployeeService iEmployeService;

	@GetMapping("/listEmployee")
	public List<Employee> ListEmployee(){
		return iEmployeService.findAllEmployee();
		
	}
	
	@PostMapping("/saveEmployee")
	public void saveEmployee(Employee employee) {
		iEmployeService.saveEmployee(employee);
	}
}
