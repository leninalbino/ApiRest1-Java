package com.employees.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employees.apirest.models.entity.Employee;
import com.employees.apirest.service.IEmployeeService;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {
	
	@Autowired
private IEmployeeService iEmployeService;

	//@GetMapping("/listEmployee")
	@GetMapping
	public  ResponseEntity<List<Employee>>  ListEmployee(){
		List<Employee> employees = iEmployeService.findAllEmployee();
		return ResponseEntity.ok().body(employees);
		
	}
	
	// @RequestBody para recibir la data en un formato diferente la de java : json, xml, etc
	//@PostMapping("/saveEmployee")
	@PostMapping
	public   ResponseEntity< Employee> saveEmployee(@RequestBody Employee employee) {
		iEmployeService.saveEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}
	
	
	// @PathVariable (/find/{id})
	//@RequestParam
	//@GetMapping("/find/{id}") 
	@GetMapping("/{id}") 
	public ResponseEntity<Employee> findById(@PathVariable Long id){
		Employee lista = iEmployeService.findById(id);
		return ResponseEntity.ok().body(lista);	
	}
	
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
		Employee lista = iEmployeService.findById(id);
		return ResponseEntity.ok().body(lista); 
	}
	
	//@DeleteMapping("/delete/{id}")
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id){
		Employee state= iEmployeService.updateStatusEmployee(id);
		if (state == null )
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok().body(state);
		
	}
}
