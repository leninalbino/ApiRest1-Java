package com.employees.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employees.apirest.models.dao.IChargeRepository;
import com.employees.apirest.models.entity.Charge;
@Service
public class ChargeServiceImpl implements IChargeService{

	@Autowired
	IChargeRepository iChargeRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Charge> listCharge() {
		// TODO Auto-generated method stub
		return iChargeRepository.findAll();
	}

	@Override
	@Transactional
	public void saveCharge(Charge charge) {
		// TODO Auto-generated method stub
		iChargeRepository.save(charge);
	}

	@Override
	@Transactional(readOnly = true)
	public Charge findById(Integer id) {
		// TODO Auto-generated method stub
		return iChargeRepository.findById(id).orElse(null);
	}

}
