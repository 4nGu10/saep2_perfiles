package com.juan.curso.springboot.webapp.saep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaInicioAdmin {
    @GetMapping("/inicioAdmin")
    public String mostrarVistaAdmin() {
        return "inicioAdministradores"; // sin ".html"
    }
}
