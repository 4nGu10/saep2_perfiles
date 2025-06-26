package com.juan.curso.springboot.webapp.saep.controller;

import com.juan.curso.springboot.webapp.saep.model.Usuarios;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaInicioAdmin {
    @GetMapping("/inicioAdmin")
    public String mostrarInicioAdmin(Model model, HttpSession session) {
        Usuarios usuario = (Usuarios) session.getAttribute("usuarioLogueado");
        if (usuario == null) {
            return "redirect:/login";
        }

        model.addAttribute("usuario", usuario); // Necesario para el menú
        model.addAttribute("contentFragment", "inicioAdministradores :: content"); // O cualquier fragmento válido

        return "layout/base";
    }

}

