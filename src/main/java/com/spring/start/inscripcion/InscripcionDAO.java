package com.spring.start.inscripcion;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.start.curso.Curso;
import com.spring.start.estudiante.Estudiante;


public interface InscripcionDAO extends CrudRepository<Inscripcion, InscripcionId> {

	
	public List<Inscripcion> findByEstudiante(Estudiante estudiante);
	public List<Inscripcion> findByCurso(Curso curso);
    public List<Inscripcion> findByCursoNot(Curso curso);

}
