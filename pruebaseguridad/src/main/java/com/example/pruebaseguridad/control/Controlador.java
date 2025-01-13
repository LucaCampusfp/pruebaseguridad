package com.example.pruebaseguridad.control;

import com.example.pruebaseguridad.entidad.Cliente;
import com.example.pruebaseguridad.repositories.ClienteRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class Controlador {
    @Autowired
    ClienteRepositories repoClientes;

    @RequestMapping("/")
    public ModelAndView peticion1(Authentication aut) {
        ModelAndView mv = new ModelAndView();
        String usuario;
        if (aut == null) {
            usuario = "Sin inicio de sesión";
        }
        else {
            Optional<Cliente> cliOpt = repoClientes.findById(aut.getName());
            Cliente cliente = cliOpt.get();
            usuario = cliente.getNif()+" - "+cliente.getNombre()
                    + " Perfil: "+cliente.getPermiso();
        }
        mv.addObject("usuario", usuario);
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView peticionSesion() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/carrito")
    public ModelAndView peticionCarrito() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("carrito");
        return mv;
    }

    @RequestMapping("/informacion")
    public ModelAndView peticionInformacion() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("informacion");
        return mv;
    }

    @RequestMapping("/denegado")
    public ModelAndView peticionDenegado() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("prohibido");
        return mv;
    }
}