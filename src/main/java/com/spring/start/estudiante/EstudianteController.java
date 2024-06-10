package com.spring.start.estudiante;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.start.curso.Curso;
import com.spring.start.curso.CursoDAO;
import com.spring.start.inscripcion.InscripcionDAO;


@Controller
public class EstudianteController {

	
	@Autowired
    private CursoDAO cursoRepository;

    @Autowired
    private EstudianteDAO estudianteRepository;

    @Autowired
    private InscripcionDAO inscripcionRepository;

    
    
 // Métodos para CRUD
    @GetMapping("/estudiante")
   
    public ModelAndView listarEstudiantes() {
        
		ModelAndView model = new ModelAndView();
		model.setViewName("estudiante");
		
		List<Estudiante> cursos = (List<Estudiante>) estudianteRepository.findAll();
		model.addObject("estudiantes", cursos);
		model.addObject("estudiante", new Estudiante());
		
		return model;	    }

    
    
    
    
    @GetMapping("/estudiante/{id}")
   
    public ModelAndView obtenerEstudiante(@PathVariable Long id) {
        
    	Optional<Estudiante> estudianteOptional = estudianteRepository.findById(id);
		
    	ModelAndView model = new ModelAndView();
    	if(estudianteOptional.isPresent()) {
    		
    		model.setViewName("estudiante");
    		model.addObject("estudiante", estudianteOptional.get());
    		model.addObject("inscripcion",inscripcionRepository.findByEstudiante(estudianteOptional.get()));
    		model.addObject("not_inscripcion",cursoRepository.findNotCurso(id));

			return model;
    	}
		model.setViewName("redirect:/estudiante");
		return model;
    	
		
    }
    

    @PostMapping("/estudiante/save")
   
    public ModelAndView agregarEstudiante(@ModelAttribute Estudiante estudiante) {

    	estudianteRepository.save(estudiante);
    	
    	ModelAndView model = new ModelAndView();
    	model.setViewName("redirect:/estudiante");
		return model;
    	
    }


    @GetMapping("/estudiante/del/{id}")
    
    public ModelAndView eliminarEstudiante(@PathVariable Long id) {
        
    	estudianteRepository.deleteById(id);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/estudiante");
		
		return model;
    }
    
}
	

