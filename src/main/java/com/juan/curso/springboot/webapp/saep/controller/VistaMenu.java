package com.juan.curso.springboot.webapp.saep.controller;

import com.juan.curso.springboot.webapp.saep.model.Usuarios;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaMenu {

    @GetMapping("/menu")
    public String mostrarMenu(HttpSession session, Model model) {
        Usuarios usuario = (Usuarios) session.getAttribute("usuarioLogueado");

        if (usuario == null) {
            return "redirect:/login"; // No hay sesión activa
        }

        model.addAttribute("usuario", usuario); // Lo mandamos a la vista
        return "menu"; // Carga menu.html
    }


}
