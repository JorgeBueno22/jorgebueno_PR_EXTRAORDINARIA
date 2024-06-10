package com.spring.start.estudiante;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.start.curso.Curso;

public interface EstudianteDAO extends CrudRepository<Estudiante, Long>{

	
	@Query(value="SELECT * FROM Estudiante est WHERE est.id NOT IN (SELECT i.estudiante_id FROM Inscripcion i WHERE i.estudiante_id = :estudiante)",nativeQuery=true)
	List<Estudiante> findNotEstudiante(@Param("estudiante") Long estudiante);
}
