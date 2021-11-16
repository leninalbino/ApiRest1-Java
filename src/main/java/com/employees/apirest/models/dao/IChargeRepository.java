package com.employees.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employees.apirest.models.entity.Charge;

public interface IChargeRepository extends JpaRepository<Charge, Integer> {
	

}
