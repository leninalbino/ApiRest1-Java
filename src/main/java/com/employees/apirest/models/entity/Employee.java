package com.employees.apirest.models.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Entity()
@Data
public class Employee {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 45, nullable = false)
	private String name;
	
	@Column(length = 45, nullable = false, unique = true)
	private String email;
	@Temporal(TemporalType.DATE)
	private Date creatAt;
	
	private Boolean state;
	
	public boolean isState() {
		return state;
	}
	
	@PrePersist
	// sirve para agregar la fecha del sistema automaticamente a la base de datos
	public void prePersist() {
		// la instancia del date sirve para extraer el date del sistema (fecha, hora y zona del sistema)
		creatAt = new Date();
	}
	
}
