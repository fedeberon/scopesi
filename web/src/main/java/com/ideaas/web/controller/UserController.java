package com.ideaas.web.controller;

import com.ideaas.services.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by federicoberon on 08/10/2019.
 */
@Controller
@RequestMapping("user")
public class UserController {


    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("list")
    public String findAll(@RequestParam(defaultValue = "10") Integer size,
                          @RequestParam(defaultValue = "0") Integer page, Model model){
        model.addAttribute("users", usuarioService.findAll(size, page, "id"));

        return "user/list";
    }


}
