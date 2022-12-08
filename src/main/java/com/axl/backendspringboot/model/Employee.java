package com.axl.backendspringboot.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="empleados")
public class Employee {
	/*A la clase de empleado le falta un generador de secuencias,
	por lo que Hibernate no puede insertar la fila. debería ser
	algo como esto que aumente la columna de conteo de identificación en 1*/
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
	@SequenceGenerator(name="SEQUENCE1", sequenceName="SEQUENCE1", allocationSize=1)
	@Column(name = "ID")
	private long id;
	@NotNull
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@NotNull
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@NotNull
	@Column(name = "email_address", nullable = false)
	private String emailId;

/*
	public Employee() {

	}

	public Employee(String firstName, String lastName, String emailId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}

	*//*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)*//*
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email_address", nullable = false)
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}*/
}
