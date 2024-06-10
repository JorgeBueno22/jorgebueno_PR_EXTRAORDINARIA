package com.spring.start.estudiante;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.start.inscripcion.Inscripcion;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Estudiante {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    private Long id;
	private String nombre;
	
	@OneToMany(mappedBy = "estudiante",targetEntity = Inscripcion.class)
	@JsonBackReference
    private Set<Inscripcion> inscribe = new HashSet<>();
	
	
	
	public Long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "[" + id + "] - " + nombre + "]";
	}
}
