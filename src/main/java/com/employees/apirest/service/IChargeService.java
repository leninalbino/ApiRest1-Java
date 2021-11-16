package com.employees.apirest.service;

import java.util.List;

import com.employees.apirest.models.entity.Charge;

public interface IChargeService {

	List<Charge> listCharge();
	void  saveCharge(Charge charge);
	Charge findById(Integer id);
	
}
