package com.employees.apirest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.employees.apirest.models.dao.IEmployeeDao;
import com.employees.apirest.models.entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired 
	private IEmployeeDao iEmployeeDao ;
	
	@Override
	@Transactional(readOnly = true)
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return iEmployeeDao.findAll();
	}

	@Transactional
	@Override
	public void saveEmployee(Employee employee) {
		
		iEmployeeDao.save(employee);
		
	}
	@Transactional
	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		iEmployeeDao.deleteById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public Employee findById(Long id) {
		// TODO Auto-generated method stub
	return iEmployeeDao.findById(id).orElse(null);
	}

	@Override
	public Employee updateStatusEmployee(Long id) {
		
			Employee employee = findById(id);
			
				if(employee.isState()) {
					iEmployeeDao.updateStatus(false, employee.getId());
				}else {
					iEmployeeDao.updateStatus(true, employee.getId());
				}
	return employee;
		}
	

}
