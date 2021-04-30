package com.ideaas.web.controller;

import com.ideaas.services.domain.Usuario;
import com.ideaas.services.service.interfaces.UsuarioService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class LoginController {

    private UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping(value = {"/home" , ""})
    public String homePage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Usuario user = usuarioService.getByUsername(username);

        if(user.getTipoUsuario().getId() == 1L){
            return "home";
        }else{
            return "inspector";
        }
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/perform_login")
    public String doLogin(@RequestParam("username") String username, @RequestParam String password) {
        System.out.println("ok");
        return "ok";
    }

}

