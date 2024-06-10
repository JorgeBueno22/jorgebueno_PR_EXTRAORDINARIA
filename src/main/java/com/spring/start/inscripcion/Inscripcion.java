package com.spring.start.inscripcion;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.start.curso.Curso;
import com.spring.start.estudiante.Estudiante;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Inscripcion {

	
	@EmbeddedId
    private InscripcionId id;

    
    @ManyToOne
    @MapsId("cursoId")
    @JoinColumn(name = "curso_id")
    @JsonManagedReference
    private Curso curso;

	@ManyToOne
    @MapsId("estudianteId")
    @JoinColumn(name = "estudiante_id")
	@JsonManagedReference
    private Estudiante estudiante;
	
	
	private String curso_academico;
	private String tutor;
	

	public InscripcionId getId() {
		return id;
	}

	public void setId(InscripcionId id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public String getCurso_academico() {
		return curso_academico;
	}

	public void setCurso_academico(String curso_academico) {
		this.curso_academico = curso_academico;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	
	
	
}
