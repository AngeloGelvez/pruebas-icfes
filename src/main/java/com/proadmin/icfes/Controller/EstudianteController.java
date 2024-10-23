package com.proadmin.icfes.Controller;

import com.proadmin.icfes.Entities.Estudiante;
import com.proadmin.icfes.Entities.Prueba;
import com.proadmin.icfes.Repositories.EstudianteRepository;
import com.proadmin.icfes.Repositories.PruebaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private PruebaRepository pruebaRepository;

    @GetMapping
    public String home() {
        return "home-est.html";
    }

    @PostMapping("/login")
    public String validar(@RequestParam("numeroRegistro") String text) {
        Prueba prueba = pruebaRepository.findByNumeroRegistro(text).get();
        if(prueba.getId() != null) {
            return "redirect:/estudiante/" + prueba.getNumeroRegistro();
        }

        return "";
    }

    @GetMapping("/{numeroRegistro}")
    public String mostrar(@PathVariable String numeroRegistro, Model model) {
        Estudiante estudiante = estudianteRepository.findByNumeroRegistro(numeroRegistro).get();
        model.addAttribute("estudiante", estudiante);
        Prueba prueba = pruebaRepository.findByNumeroRegistro(estudiante.getNumeroRegistro()).get();
        model.addAttribute("puntajeTotal", prueba.calcularPuntajeTotal());
        model.addAttribute("prueba", prueba);
        return "estudiante.html";
    }

    @GetMapping("/coordinacion/{numeroRegistro}")
    public String mostrarcoor(@PathVariable String numeroRegistro, Model model) {
        Estudiante estudiante = estudianteRepository.findByNumeroRegistro(numeroRegistro).get();
        model.addAttribute("estudiante", estudiante);
        Prueba prueba = pruebaRepository.findByNumeroRegistro(estudiante.getNumeroRegistro()).get();
        model.addAttribute("puntajeTotal", prueba.calcularPuntajeTotal());
        model.addAttribute("prueba", prueba);
        return "estudiante-cor.html";
    }


}