package com.spring.start.inscripcion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.spring.start.curso.CursoDAO;
import com.spring.start.estudiante.EstudianteDAO;

@Controller
public class InscripcionController {

	
	@Autowired
    private CursoDAO cursoRepository;

    @Autowired
    private EstudianteDAO estudianteRepository;

    @Autowired
    private InscripcionDAO inscripcionRepository;
    
    
    @GetMapping("/del/{idCurso}/{idEstudiante}")
    public ModelAndView eliminarContiene(
    				@PathVariable Long idCurso,
    				@PathVariable Long idEstudiante) {
        

    	InscripcionId id = new InscripcionId();
    	id.setCursoId(idCurso);
    	id.setEstudianteId(idEstudiante);
    	inscripcionRepository.deleteById(id);
    	
    	
    	ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/estudiante/"+idEstudiante);
		
		return model;
    }

    
    @GetMapping("/add/{idCurso}/{idEstudiante}")
    public ModelAndView anadirContiene(
    				@PathVariable Long idCurso,
    				@PathVariable Long idEstudiante) {
        

    	// añade de contiene {idProducto}/{idCategoria}
    	InscripcionId id = new InscripcionId();
    	id.setCursoId(idCurso);
    	id.setEstudianteId(idEstudiante);
    	
    	Inscripcion inscripcion = new Inscripcion();
    	inscripcion.setId(id);
    	inscripcion.setCurso(cursoRepository.findById(idCurso).get());
    	inscripcion.setEstudiante(estudianteRepository.findById(idEstudiante).get());
    	
    	inscripcionRepository.save(inscripcion);
    	
    	
    	ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/estudiante/"+idEstudiante);
		
		return model;
    }
    
}
