package com.employees.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employees.apirest.models.entity.Employee;
@Repository
public interface IEmployeeDao extends JpaRepository<Employee, Long> {

	@Transactional
	@Modifying 
	@Query("update Employee c set c.state = ?1 where c.id=?2")
	void updateStatus(Boolean state, Long id);
}
