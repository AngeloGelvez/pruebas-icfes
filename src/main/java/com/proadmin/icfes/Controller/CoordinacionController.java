package com.proadmin.icfes.Controller;

import com.proadmin.icfes.Entities.Estudiante;
import com.proadmin.icfes.Entities.Prueba;
import com.proadmin.icfes.Repositories.CoordinadorRepository;
import com.proadmin.icfes.Repositories.EstudianteRepository;
import com.proadmin.icfes.Repositories.PruebaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/coordinacion")
public class CoordinacionController {

    @Autowired
    private CoordinadorRepository coordinadorRepository;

    @Autowired
    private PruebaRepository pruebaRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping
    public String mostrar() {
        return "home-coor.html";
    }

    @GetMapping("/examen")
    public String mostrarExamen(Model model) {
        //model.addAttribute("pruebas", pruebaRepository.findAll());
        model.addAttribute("estudiantes", estudianteRepository.findAll());
        return "exam-list.html";
    }

    @GetMapping("/examen/new")
    public String crearExam(Model model) {
        model.addAttribute("prueba", new Prueba());
        return "examen-form.html";
    }

    @GetMapping("/examen/{id}")
    public String editarExam(Model model, @PathVariable String id) {
        model.addAttribute("prueba", pruebaRepository.findById(id));
        return "examen-form.html";
    }

    @GetMapping("/examen/editar/{id}")
    public String editarExamen(Model model, @PathVariable String id) {
        model.addAttribute("prueba", pruebaRepository.findByNumeroRegistro(id));
        return "examen-form.html";
    }


    @PostMapping("/examen/save")
    public String guardarExam(@ModelAttribute("prueba") Prueba prueba) {
        if(prueba.getId().isEmpty()) {
            prueba.setId(null);
        }

        pruebaRepository.save(prueba);
        return "redirect:/coordinacion/examen";
    }

    @GetMapping("/examen/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        pruebaRepository.deleteById(id);
        return "redirect:/coordinacion/examen";
    }

    //ESTUDIANTES

    @GetMapping("/estudiante")
    public String mostrarEstudiante(Model model) {
        model.addAttribute("estudiantes", estudianteRepository.findAll());
        return "estu-list.html";
    }

    @GetMapping("/estudiante/new")
    public String crearEstudiante(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "estu-form.html";
    }

    @GetMapping("/estudiante/{id}")
    public String editarEst(Model model, @PathVariable Long id) {
        model.addAttribute("estudiante", estudianteRepository.findById(id));
        return "estu-form.html";
    }

    @PostMapping("/estudiante/save")
    public String guardarExam(@ModelAttribute("estudiante") Estudiante estudiante) {
        estudianteRepository.save(estudiante);

        return "redirect:/coordinacion/estudiante";
    }

    @GetMapping("/estudiante/eliminar/{id}")
    public String eliminarEst(@PathVariable Long id) {
        estudianteRepository.deleteById(id);
        return "redirect:/coordinacion/estudiante";
    }
}