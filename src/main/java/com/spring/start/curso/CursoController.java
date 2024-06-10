package com.spring.start.curso;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.start.estudiante.EstudianteDAO;
import com.spring.start.inscripcion.InscripcionDAO;

@Controller
public class CursoController {
	
	
	@Autowired
    private CursoDAO cursoRepository;

    @Autowired
    private EstudianteDAO estudianteRepository;

    @Autowired
    private InscripcionDAO inscripcionRepository;

    
    
 // Métodos para CRUD
    @GetMapping("/curso")
   
    public ModelAndView listarCursos() {
        
		ModelAndView model = new ModelAndView();
		model.setViewName("cursos");
		
		List<Curso> cursos = (List<Curso>) cursoRepository.findAll();
		model.addObject("cursos", cursos);
		model.addObject("curso", new Curso());
		
		return model;	    }

    
    
    
    
    @GetMapping("/curso/{id}")
   
    public ModelAndView obtenerCurso(@PathVariable Long id) {
        
    	Optional<Curso> cursoOptional = cursoRepository.findById(id);
		
    	ModelAndView model = new ModelAndView();
    	if(cursoOptional.isPresent()) {
    		
    		model.setViewName("curso");
    		model.addObject("curso", cursoOptional.get());
    		model.addObject("inscripcion",inscripcionRepository.findByCurso(cursoOptional.get()));
    		model.addObject("not_inscripcion",estudianteRepository.findNotEstudiante(id));

			return model;
    	}
		model.setViewName("redirect:/curso");
		return model;
    	
		
    }
    

    @PostMapping("/curso/save")
   
    public ModelAndView agregarCurso(@ModelAttribute Curso curso) {

    	cursoRepository.save(curso);
    	
    	ModelAndView model = new ModelAndView();
    	model.setViewName("redirect:/curso");
		return model;
    	
    }


    @GetMapping("/curso/del/{id}")
    
    public ModelAndView eliminarCurso(@PathVariable Long id) {
        
    	cursoRepository.deleteById(id);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/curso");
		
		return model;
    }
    
}
