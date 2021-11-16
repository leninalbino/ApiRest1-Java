package com.employees.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.apirest.models.entity.Charge;
import com.employees.apirest.service.IChargeService;

@RestController
@RequestMapping("/change")
public class ChargeController {
	@Autowired
	IChargeService iChargeService;
	

	@GetMapping
	
	public ResponseEntity<List<Charge>> listChargen(){
		List<Charge> list = iChargeService.listCharge();
		return ResponseEntity.ok().body(list);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Charge> findById(Integer id) {
		Charge search = iChargeService.findById(id);
		return ResponseEntity.ok().body(search);
		
	}
	@PostMapping
	
	public ResponseEntity<Charge> saveChargen(@RequestBody Charge charge){
		iChargeService.saveCharge(charge);
		return ResponseEntity.status(HttpStatus.CREATED).body(charge);
		
	}
	
}
