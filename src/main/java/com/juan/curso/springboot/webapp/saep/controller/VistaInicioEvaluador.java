package com.juan.curso.springboot.webapp.saep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaInicioEvaluador {
    @GetMapping("/inicioEvaluador")
    public String mostrarVistaAdmin() {
        return "inicioEvaluador";
    }
}
