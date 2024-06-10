package com.spring.start.curso;

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
public class Curso {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    private Long id;
	private String titulo;
	
	@OneToMany(mappedBy = "curso",targetEntity = Inscripcion.class)
	@JsonBackReference
    private Set<Inscripcion> inscribe = new HashSet<>();
	
	
	
	public Long getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@Override
	public String toString() {
		return "[" + id + "] - " + titulo + "]";
	}
	
}
