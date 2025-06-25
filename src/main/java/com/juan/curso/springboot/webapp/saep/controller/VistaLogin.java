package com.juan.curso.springboot.webapp.saep.controller;

import com.juan.curso.springboot.webapp.saep.model.Usuarios;
import com.juan.curso.springboot.webapp.saep.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VistaLogin {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; // login.html
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String username,
                                @RequestParam String password,
                                Model model, HttpSession session) {
        Usuarios usuario = usuarioRepository.findByNumeroAndClave(username, password);

        if (usuario != null) {

            if ("Activo".equalsIgnoreCase(usuario.getEstado())) {
                String nombreRol = usuario.getRol().getRoles();

                session.setAttribute("usuarioLogueado", usuario);
                session.setAttribute("idUsuarioLogueado", usuario.getId_usuarios());
                session.setAttribute("nombreRol", usuario.getRol().getRoles());
                System.out.println("USUARIO: " + usuario);
                System.out.println("ROL: " + (usuario != null ? usuario.getRol() : "null"));


                switch (nombreRol.trim().toUpperCase()) {
                    case "ADMINISTRADOR DEL SISTEMA":
                        return "redirect:/menu";
                    case "EVALUADOR":
                        return "redirect:/vista/empresas";
                    case "APRENDIZ":
                        return "redirect:/menu";
                    default:
                        model.addAttribute("error", "Rol no reconocido: " + nombreRol);
                        return "login";
                }

            } else {
                model.addAttribute("error", "Usuario inactivo");
                return "login";
            }

        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }
}

