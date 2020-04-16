package com.ideaas.web.controller;

import com.ideaas.services.bean.AESPasswordEncoder;
import com.ideaas.services.service.interfaces.UsuarioService;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * Created by federicoberon on 08/10/2019.
 */
@Controller
@RequestMapping("user")
public class UserController {

    private UsuarioService usuarioService;
    private AESPasswordEncoder encoder;

    @Autowired
    public UserController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
        this.encoder = new AESPasswordEncoder();
    }

    @RequestMapping("list")
    public String findAll(@RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(defaultValue = "0") Integer page, Model model){
        model.addAttribute("users", usuarioService.findAll(size, page, "id"));

        return "user/list";
    }


    @RequestMapping("/auth")
    public String hello(HttpServletRequest request, @CookieValue("Authorization") String authorization, @CookieValue("Token") String token) {
            String username = authorization.substring(6);
            UserDetails userDetails = usuarioService.loadUserByUsername(username);

            if (Objects.nonNull(userDetails) && userDetails.getPassword().equals(token)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    return "panel";
            }

            else return "login";
    }
}
