package com.employees.apirest.models.entity;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Charge {

	private Integer id;
	private String namCharge;
	
}
