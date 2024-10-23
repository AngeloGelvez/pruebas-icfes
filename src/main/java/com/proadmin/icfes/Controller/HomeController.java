package com.proadmin.icfes.Controller;

import com.proadmin.icfes.Entities.Coordinacion;
import com.proadmin.icfes.Repositories.CoordinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private CoordinadorRepository coordinadorRepository;

    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("coordinador", new Coordinacion());
        return "login.html";
    }

    @GetMapping("/")
    public String mostrar() {
        return "home.html";
    }

    @PostMapping("/inicio-sesion")
    public String envio(@ModelAttribute("coordinador") Coordinacion coordinacion) {
        String usuario = coordinacion.getUsuario();
        String contra = coordinacion.getContra();

        Coordinacion coordinacion1 = coordinadorRepository.findByUsuario(usuario).get();

        if(usuario.equals(coordinacion1.getUsuario()) && contra.equals(coordinacion1.getContra())) {
            return "redirect:/coordinacion";
        }
        return "redirect:/";
    }
}