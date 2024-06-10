package com.spring.start.inscripcion;

import java.io.Serializable;

import jakarta.persistence.Column;

public class InscripcionId implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Column(name = "estudiante_id")
    private Long estudianteId;

    @Column(name = "curso_id")
    private Long cursoId;
    
    

	

	public Long getEstudianteId() {
		return estudianteId;
	}

	public void setEstudianteId(Long estudianteId) {
		this.estudianteId = estudianteId;
	}

	public Long getCursoId() {
		return cursoId;
	}

	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}
    
    
    
    
    
}
