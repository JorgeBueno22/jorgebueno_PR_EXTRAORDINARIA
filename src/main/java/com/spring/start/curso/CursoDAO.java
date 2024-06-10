package com.spring.start.curso;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CursoDAO extends CrudRepository<Curso, Long>{

	
	@Query(value="SELECT * FROM Curso cur WHERE cur.id NOT IN (SELECT i.curso_id FROM Inscripcion i WHERE i.estudiante_id = :estudiante)",nativeQuery=true)
	List<Curso> findNotCurso(@Param("estudiante") Long estudiante);	
}
